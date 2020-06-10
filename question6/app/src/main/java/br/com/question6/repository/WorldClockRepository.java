package br.com.question6.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import br.com.question6.model.WorldClock;
import br.com.question6.retrofit.WorldClockRetrofit;
import br.com.question6.retrofit.callback.CallbackWithResponse;
import br.com.question6.retrofit.callback.LoadedDataCallback;
import br.com.question6.retrofit.callback.ResponseCallback;
import br.com.question6.retrofit.service.WorldClockService;
import retrofit2.Call;

public class WorldClockRepository {
    private final WorldClockService worldClockService;
    private final MutableLiveData<Resource<WorldClock>> mutableLiveData = new MutableLiveData<>();

    public WorldClockRepository() {
        worldClockService = new WorldClockRetrofit().getWorldClockService();
    }

    private void fetchCurrentDateTime(LoadedDataCallback<WorldClock> callback) {
        Call<WorldClock> call = worldClockService.getCurrentDateTime();

        call.enqueue(new CallbackWithResponse<>(new ResponseCallback<WorldClock>() {
            @Override
            public void onSuccess(WorldClock result) {
                callback.onSuccess(result);
            }

            @Override
            public void onFail(String error) {
                callback.onFail(error);
            }
        }));
    }

    public LiveData<Resource<WorldClock>> getLiveData() {
        fetchCurrentDateTime(new LoadedDataCallback<WorldClock>() {
            @Override
            public void onSuccess(WorldClock result) {

                mutableLiveData.setValue(new Resource<>(result, null));
            }

            @Override
            public void onFail(String error) {
                mutableLiveData.setValue(new Resource<>(null, error));
            }
        });

        return mutableLiveData;
    }
}
