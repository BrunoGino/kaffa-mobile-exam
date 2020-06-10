package br.com.question6.retrofit.service;

import br.com.question6.model.WorldClock;
import retrofit2.Call;
import retrofit2.http.GET;

public interface WorldClockService {
    @GET("now")
    Call<WorldClock> getCurrentDateTime();
}
