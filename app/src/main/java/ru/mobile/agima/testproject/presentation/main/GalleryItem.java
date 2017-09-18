package ru.mobile.agima.testproject.presentation.main;


public class GalleryItem {
    private int imageRes;
    private String text;

    public GalleryItem() {
    }

    public GalleryItem(int imageRes, String text) {
        this.imageRes = imageRes;
        this.text = text;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
