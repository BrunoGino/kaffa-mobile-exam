package br.com.question6.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import br.com.question6.model.WorldClock;
import br.com.question6.repository.Resource;
import br.com.question6.repository.WorldClockRepository;

public class WorldClockViewModel extends ViewModel {

    private final WorldClockRepository worldClockClient;


    public WorldClockViewModel() {
        this.worldClockClient = new WorldClockRepository();
    }

    public LiveData<Resource<WorldClock>> getClock() {
        return worldClockClient.getLiveData();
    }

}
