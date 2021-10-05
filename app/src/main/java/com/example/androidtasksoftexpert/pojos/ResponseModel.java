package com.example.androidtasksoftexpert.pojos;

import java.util.List;

public class ResponseModel {
    private int status;
    private List<CarModel> data;

    public ResponseModel(int status, List<CarModel> data) {
        this.status = status;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<CarModel> getData() {
        return data;
    }

    public void setData(List<CarModel> data) {
        this.data = data;
    }
}
