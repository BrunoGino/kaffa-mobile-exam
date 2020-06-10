package br.com.simpletodolist.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import br.com.simpletodolist.R;
import br.com.simpletodolist.databinding.ListFragmentBinding;
import br.com.simpletodolist.model.Task;
import br.com.simpletodolist.ui.recyclerview.adapter.ListAdapter;
import br.com.simpletodolist.viewmodel.ListViewModel;

public class ListFragment extends Fragment {
    private ListFragmentBinding listFragmentBinding;
    private ListViewModel taskViewModel;
    private NavController controller;
    private ListAdapter adapter;
    private ListAdapter.OnItemClickListener onItemClickListener;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        taskViewModel = ViewModelProviders.of(this).get(ListViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        listFragmentBinding = ListFragmentBinding.inflate(inflater, container, false);
        return listFragmentBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        controller = Navigation.findNavController(view);
        setupRecyclerView(view);
        configureFab();
        fetchTasks(view);
    }

    private void setupRecyclerView(View view) {
        RecyclerView recyclerView = listFragmentBinding.todoListRecyclerview;
        setOnRecyclerItemClickListener();
        adapter = new ListAdapter(view.getContext(), this.onItemClickListener);
        adapter.setHasStableIds(true);
        recyclerView.setAdapter(adapter);
    }

    private void configureFab() {
        listFragmentBinding.fabCreate.setOnClickListener(v -> goestToTaskFormNew());
    }

    private void setOnRecyclerItemClickListener() {
        this.onItemClickListener = this::goesToTaskFormEdit;
    }

    private void goestToTaskFormNew() {
        NavDirections destination = ListFragmentDirections.actionTodoListToFormFragmentNew();
        controller.navigate(destination);
    }

    private void goesToTaskFormEdit(Task task) {
        Bundle bundle = new Bundle();
        bundle.putInt("taskId", task.getTaskId());
        controller.navigate(R.id.action_todoList_to_formFragmentEdit, bundle);
    }

    private void fetchTasks(View view) {
        taskViewModel.getAllTasks().observe(getViewLifecycleOwner(), tasks -> {
            if (tasks != null) {
                adapter.addAll(tasks);
            } else {
                Snackbar.make(view, R.string.could_not_fetch_tasks, Snackbar.LENGTH_LONG).show();
            }
        });
    }

}
