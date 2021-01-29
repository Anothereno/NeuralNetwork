package com.anothereno;

import java.util.ArrayList;
import java.util.List;

public class NeuralNetwork {
    public NeuralNetwork(int ... layersAmount) {
        for (int layerSize : layersAmount) {
            this.layers.add(new Layer(layerSize));
        }
    }

    public List<Layer> getLayers() {
        return layers;
    }

    public void setLayers(List<Layer> layers) {
        this.layers = layers;
    }

    public void loadNN(){

    }

    private List<Layer> layers = new ArrayList<>();
}
