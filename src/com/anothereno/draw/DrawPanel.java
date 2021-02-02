package com.anothereno.draw;

import com.anothereno.neuralnetwork.NeuralNetwork;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    public DrawPanel(NeuralNetwork neuralNetwork, int width, int height){
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.neuralNetwork = neuralNetwork;

        this.neuronsCoordinates = new NetworkCoordinates(neuralNetwork);
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        drawNeurons(g);
    }

    public void drawNeurons(Graphics g) {
        neuronsCoordinates.print(g);
    }

    private NeuralNetwork neuralNetwork;

    private NetworkCoordinates neuronsCoordinates;
}
