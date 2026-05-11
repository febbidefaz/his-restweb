package com.dev.generik.models.Respons;

public class CustomResponse {
	private int code;
    private String message;

    public CustomResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    // Getters and Setters
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
