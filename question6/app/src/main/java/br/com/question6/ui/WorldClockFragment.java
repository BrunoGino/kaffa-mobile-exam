package br.com.question6.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.snackbar.Snackbar;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

import br.com.question6.R;
import br.com.question6.databinding.WorldClockFragmentBinding;
import br.com.question6.model.WorldClock;
import br.com.question6.repository.Resource;
import br.com.question6.viewmodel.WorldClockViewModel;

public class WorldClockFragment extends Fragment {
    private WorldClockViewModel worldClockViewModel;
    private WorldClockFragmentBinding fragmentBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        worldClockViewModel = ViewModelProviders.of(this).get(WorldClockViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentBinding = WorldClockFragmentBinding.inflate(inflater, container, false);
        worldClockViewModel.getClock().observe(getViewLifecycleOwner(), this::updateView);
        return fragmentBinding.getRoot();
    }

    private void updateView(Resource<WorldClock> worldClockResource) {
        if (worldClockResource.getData() != null) {
            setBindingVariables();
            fragmentBinding.setClock(worldClockResource.getData());
        } else {
            showFetchErrorWarning(fragmentBinding.getRoot());
        }
    }

    private void setBindingVariables() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        String dayOfWeek = zonedDateTime.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
        String formattedDayOfWeek = dayOfWeek.substring(0, 1).toUpperCase() + dayOfWeek.substring(1);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter hourFormatter = DateTimeFormatter.ofPattern("HH:mm");
        fragmentBinding.setZonedDateTime(zonedDateTime);
        fragmentBinding.setDateFormatter(dateFormatter);
        fragmentBinding.setHourFormatter(hourFormatter);
        fragmentBinding.setLocalDayOfWeekValue(formattedDayOfWeek);
    }

    private void showFetchErrorWarning(@NonNull View view) {
        Snackbar.make(view, R.string.fetch_error, Snackbar.LENGTH_LONG)
                .show();
    }
}
