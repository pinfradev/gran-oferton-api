package com.gran.oferton.granoferton.modules.products.domain.dto;

public class ProductFailureResponse implements  ProductResponse {
    private String title;
    private String errorMessage;

    public ProductFailureResponse(String title, String errorMessage) {
        this.title = title;
        this.errorMessage = errorMessage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
