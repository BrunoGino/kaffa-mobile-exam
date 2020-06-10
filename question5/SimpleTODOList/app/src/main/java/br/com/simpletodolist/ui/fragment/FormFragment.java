package br.com.simpletodolist.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.google.android.material.snackbar.Snackbar;

import br.com.simpletodolist.R;
import br.com.simpletodolist.databinding.FormFragmentBinding;
import br.com.simpletodolist.model.Task;
import br.com.simpletodolist.viewmodel.FormViewModel;

public class FormFragment extends Fragment {
    private NavController navController;
    private FormFragmentBinding formFragmentBinding;
    private FormViewModel formViewModel;
    private Task task = new Task();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        formViewModel = ViewModelProviders.of(this).get(FormViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        formFragmentBinding = FormFragmentBinding.inflate(inflater, container, false);
        return formFragmentBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        int taskId = requireArguments().getInt("taskId");

        formViewModel.getTask(taskId).observe(getViewLifecycleOwner(), task1 -> formFragmentBinding.setTask(task1));

        formFragmentBinding.formButtonCancel.setOnClickListener(v -> navController.popBackStack());
        formFragmentBinding.formButtonSave.setOnClickListener(v -> formViewModel.save(formFragmentBinding.getTask()));
        formFragmentBinding.formButtonDelete.setOnClickListener(v -> {
            formViewModel.delete(task);
            Snackbar.make(v, R.string.deleted, Snackbar.LENGTH_LONG);
            NavDirections formFragmentDirections = FormFragmentDirections.actionFormFragmentToTodoList();
            navController.navigate(formFragmentDirections);
        });
        handleOnBackPressed();
    }

    private void handleOnBackPressed() {
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                navController.popBackStack();
            }
        };
        requireActivity().getOnBackPressedDispatcher()
                .addCallback(getViewLifecycleOwner(), onBackPressedCallback);
    }
}
