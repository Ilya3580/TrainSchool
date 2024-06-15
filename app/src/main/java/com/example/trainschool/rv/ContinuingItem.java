package com.example.trainschool.rv;

public class ContinuingItem {
    private int imageId;
    private String text;

    public ContinuingItem(int imageId, String text) {
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