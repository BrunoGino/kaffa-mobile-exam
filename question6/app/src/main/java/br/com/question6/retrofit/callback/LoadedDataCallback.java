package br.com.question6.retrofit.callback;

public interface LoadedDataCallback<T> {
    void onSuccess(T result);

    void onFail(String error);
}
