package com.example.demo.web.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class DemoRequest {
    @Schema(example="Alan", required = false, title="Input Parameter 1")
    private String inputParam1;

    public String getInputParam1() {
        return inputParam1;
    }

    public void setInputParam1(String inputParam1) {
        this.inputParam1 = inputParam1;
    }

    @Override
    public String toString() {
        return "DemoRequest{" +
                "inputParam1='" + inputParam1 + '\'' +
                '}';
    }
}
