package br.com.question6.repository.asynctask;

public interface FinishListener<T> {
    void onFinished(T result);
}
