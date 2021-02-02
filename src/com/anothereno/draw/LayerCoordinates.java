package com.anothereno.draw;

public class LayerCoordinates {
    private Point[] layer;

    public LayerCoordinates(Point[] layer) {
        this.layer = layer;
    }

    public Point[] getLayer() {
        return layer;
    }

    public void setLayer(Point[] layer) {
        this.layer = layer;
    }
}
