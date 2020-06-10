package br.com.question6.repository;

public class Resource<T> {
    private T data;
    private String error;

    public Resource(T data, String error) {
        this.data = data;
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public String getError() {
        return error;
    }
}
