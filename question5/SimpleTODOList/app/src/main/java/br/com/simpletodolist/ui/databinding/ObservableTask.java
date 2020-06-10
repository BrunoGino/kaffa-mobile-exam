package br.com.simpletodolist.ui.databinding;


import androidx.lifecycle.MutableLiveData;

import br.com.simpletodolist.model.Task;

public class ObservableTask {
    private Task task;
    private final int id;
    private final MutableLiveData<String> title = new MutableLiveData<>();
    private final MutableLiveData<String> description = new MutableLiveData<>();

    public ObservableTask(Task task) {
        this.id = task.getTaskId();
        this.title.setValue(task.getTitle());
        this.description.setValue(task.getDescription());
    }

    public void update(Task task) {
        title.postValue(task.getTitle());
        description.postValue(task.getDescription());
    }

    public Task toTask() {
        Task task = new Task();
        task.setTaskId(id);
        task.setTitle(title.getValue());
        task.setDescription(description.getValue());

        return task;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public MutableLiveData<String> getTitle() {
        return title;
    }

    public MutableLiveData<String> getDescription() {
        return description;
    }
}
