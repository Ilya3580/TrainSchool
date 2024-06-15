package com.example.trainschool.rv;

public class BeginnerItem {
    private int imageId;
    private String text;

    public BeginnerItem(int imageId, String text) {
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
