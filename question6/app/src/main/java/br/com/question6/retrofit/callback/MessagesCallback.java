package br.com.question6.retrofit.callback;

public enum MessagesCallback {
    RESPONSE_NOT_SUCCESSFUL("Response was not successful"),
    COMMUNICATION_FAILURE("Communication failure: ");
    private final String message;
    MessagesCallback(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
