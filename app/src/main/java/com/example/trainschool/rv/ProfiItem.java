package com.example.trainschool.rv;

public class ProfiItem {
    private int imageId;
    private String text;

    public ProfiItem(int imageId, String text) {
        this.imageId = imageId;
        this.text = text;
    }

    public int getImageId() {
        return imageId;
    }

    public String getText() {
        return text;
    }
}
