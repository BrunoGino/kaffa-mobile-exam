package br.com.simpletodolist.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import br.com.simpletodolist.model.Task;
import br.com.simpletodolist.repository.TaskRepository;

public class ListViewModel extends ViewModel {
    private final TaskRepository taskRepository = new TaskRepository();

    public LiveData<List<Task>> getAllTasks() {
        return taskRepository.getAllTasks();
    }
}
