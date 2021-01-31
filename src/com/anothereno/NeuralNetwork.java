package com.anothereno;

import java.util.ArrayList;
import java.util.List;

public class NeuralNetwork {
    public NeuralNetwork(int ... neuronsAmount) {
        layers = new Layer[neuronsAmount.length];

        for (int i = 0; i < neuronsAmount.length; i++) {
            if (i == neuronsAmount.length - 1)
                this.layers[i] = new Layer(neuronsAmount[i], 0);
            else
                this.layers[i] = new Layer(neuronsAmount[i], neuronsAmount[i + 1]);
        }
    }

    public Layer[] getLayers() {
        return layers;
    }

    public void setLayers(Layer[] layers) {
        this.layers = layers;
    }

    public void loadNN(){

    }

    public void printNN(){
        for (Layer layer : layers) {
            layer.printLayer();
        }
    }

    private Layer[] layers;
}
