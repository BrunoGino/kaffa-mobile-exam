package br.com.simpletodolist.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.simpletodolist.model.Task;

public class TaskRepository {
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference();
    private final MutableLiveData<List<Task>> taskMutableLiveData = new MutableLiveData<>();

    public LiveData<List<Task>> getAllTasks() {
        DatabaseReference tasks = databaseReference.child("tasks");
        tasks.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Task> tasks = new ArrayList<>();

                dataSnapshot.getChildren().forEach(dataSnapshot1 -> {
                    Task value = dataSnapshot1.getValue(Task.class);
                    tasks.add(value);
                });

                taskMutableLiveData.setValue(tasks);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        return taskMutableLiveData;
    }

    public LiveData<Task> getTask(Integer id) {
        return null;
    }

    public String save(Task task) {
        return null;
    }

    public String delete(Task task) {
        return null;
    }
}
