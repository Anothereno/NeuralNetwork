package com.anothereno;

public class Layer {
    public Layer(int currentLayerSize, int nextLayerSize) {
        neurons = new Neuron[currentLayerSize];

        for (int i = 0; i < currentLayerSize; i++){
            neurons[i] = new Neuron(nextLayerSize);
        }
    }

    public Neuron[] getNeurons() {
        return neurons;
    }

    public void setNeurons(Neuron[] neurons) {
        this.neurons = neurons;
    }

    public void printLayer(){
        String resultNeurons = "";
        String resultRelations = "";
        for (Neuron neuron : neurons) {
            resultNeurons = resultNeurons.concat("\t\t()\t\t");
            if (!neuron.isOutputNeuron())
                for (double weight : neuron.getOutputRelationsWeight())
                    resultRelations = resultRelations.concat(String.format("\t%f\t", weight));
        }

        System.out.println(resultNeurons);
        System.out.println(resultRelations);
    }

    private Neuron[] neurons;
}
