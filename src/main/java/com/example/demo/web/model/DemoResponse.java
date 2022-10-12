package com.example.demo.web.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class DemoResponse {

    @Schema(required = false, title="Output Parameter 1")
    private String outputParam1;

    public String getOutputParam1() {
        return outputParam1;
    }

    public void setOutputParam1(String outputParam1) {
        this.outputParam1 = outputParam1;
    }

    @Override
    public String toString() {
        return "DemoResponse{" +
                "outputParam1='" + outputParam1 + '\'' +
                '}';
    }
}
