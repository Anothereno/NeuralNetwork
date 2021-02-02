package com.anothereno;

import com.anothereno.neuralnetwork.NetworkForm;
import com.anothereno.neuralnetwork.NeuralNetwork;

public class Main {

    public static void main(String[] args) {
        NeuralNetwork network= new NeuralNetwork(4, 10, 6);
        network.printNN();

        NetworkForm networkForm = new NetworkForm(network);
    }
}
