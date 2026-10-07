package ua.edu.nuos.web_lab_3.model;

import jakarta.annotation.Nonnull;

public record Point(double x, double y) {
    @Nonnull
    @Override
    public String toString() {
        return "Point{" + "x=" + String.format("%.2f",x) + ", y=" + String.format("%.4f",y) + '}';
    }
}
