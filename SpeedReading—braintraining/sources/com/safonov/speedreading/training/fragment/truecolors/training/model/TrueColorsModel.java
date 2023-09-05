package com.safonov.speedreading.training.fragment.truecolors.training.model;

public class TrueColorsModel implements ITrueColorsModel {
    private int color;
    private String colorName;

    public TrueColorsModel(String colorName2, int color2) {
        this.colorName = colorName2;
        this.color = color2;
    }

    public String getColorName() {
        return this.colorName;
    }

    public void setColorName(String colorName2) {
        this.colorName = colorName2;
    }

    public int getColor() {
        return this.color;
    }

    public void setColor(int color2) {
        this.color = color2;
    }
}
