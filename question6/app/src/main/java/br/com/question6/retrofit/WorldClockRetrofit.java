package br.com.question6.retrofit;

import br.com.question6.retrofit.service.WorldClockService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WorldClockRetrofit {
    private static final String BASE_URL = "http://worldclockapi.com/api/json/utc/";
    private final WorldClockService worldClockService;


    public WorldClockRetrofit() {
        OkHttpClient restClient = getRestClient();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(restClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.worldClockService = retrofit.create(WorldClockService.class);
    }

    private OkHttpClient getRestClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
    }

    public WorldClockService getWorldClockService() {
        return worldClockService;
    }
}
