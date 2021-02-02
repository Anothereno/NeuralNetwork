package com.anothereno.neuralnetwork;

public class Neuron {
    public Neuron(int nextLayerNeuronsAmount) {
        if (nextLayerNeuronsAmount == 0)
            isOutputNeuron = true;
        else
        {
            outputRelationsWeight = new double[nextLayerNeuronsAmount];
            for (int i = 0; i < nextLayerNeuronsAmount; i++){
                outputRelationsWeight[i] = Math.random();
            }
        }
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double[] getOutputRelationsWeight() {
        return outputRelationsWeight;
    }

    public void setOutputRelationsWeight(double[] outputRelationsWeight) {
        this.outputRelationsWeight = outputRelationsWeight;
    }

    public boolean isOutputNeuron() {
        return isOutputNeuron;
    }

    public void setOutputNeuron(boolean outputNeuron) {
        isOutputNeuron = outputNeuron;
    }

    private double value;
    private double[] outputRelationsWeight;
    private boolean isOutputNeuron = false;
}