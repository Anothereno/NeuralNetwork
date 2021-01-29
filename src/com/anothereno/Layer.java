package com.anothereno;

import java.util.List;

public class Layer {
    public Layer(int size) {
        for (int i = 0; i < size; i++){
            neurons.add(new Neuron(Math.random()));
        }
    }

    private List<Neuron> neurons;
}
