package br.com.simpletodolist.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import br.com.simpletodolist.model.Task;
import br.com.simpletodolist.repository.TaskRepository;

public class FormViewModel extends ViewModel {
    private final TaskRepository taskRepository = new TaskRepository();

    public LiveData<Task> getTask(Integer id) {
        return taskRepository.getTask(id);
    }

    public String save(Task task) {
        return taskRepository.save(task);
    }

    public String delete(Task task) {
        return taskRepository.delete(task);
    }

}
