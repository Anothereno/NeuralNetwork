package com.anothereno.draw;

import com.anothereno.neuralnetwork.Layer;
import com.anothereno.neuralnetwork.NeuralNetwork;

import java.awt.*;

public class NetworkCoordinates {
    public NetworkCoordinates(NeuralNetwork neuralNetwork) {
        this.neuralNetwork = neuralNetwork;
        mainOffsetY = HEIGHT / getMaxNeurons() - 20;
        mainOffsetX = WIDTH / neuralNetwork.getLayers().length - 20;

        System.out.println(mainOffsetX);
        System.out.println(mainOffsetY);
        layers = new LayerCoordinates[neuralNetwork.getLayers().length];
        calculateCoords();
    }

    private int getMaxNeurons(){
        int max = 0;

        for (Layer layer : neuralNetwork.getLayers())
            if (layer.getNeurons().length > max)
                max = layer.getNeurons().length;

        return max;
    }

    public void calculateCoords() {
        int xOffset = 0;

        for (int i = 0; i < neuralNetwork.getLayers().length; i++) {
            Layer layer = neuralNetwork.getLayers()[i];
            layers[i] = new LayerCoordinates(
                    getLayersCoordinates(
                            layer,
                            xOffset,
                            getOneNeuronPlace(layer, getMaxNeurons())
                    )
            );
            xOffset += mainOffsetX;
        }
    }

    private Point[] getLayersCoordinates(Layer layer, int xOffset, int oneNeuronPlace){
        int yOffset = 0;
        if (layer.getNeurons().length != getMaxNeurons())
            yOffset += oneNeuronPlace;
        Point[] points = new Point[layer.getNeurons().length];
        for (int j = 0; j < layer.getNeurons().length; j++){
            points[j] = new Point(xStartPosition + xOffset, yStartPosition + yOffset);
            yOffset += oneNeuronPlace;
        }
        return points;
    }

    private int getOneNeuronPlace(Layer layer, int maxNeurons) {
        return layer.getNeurons().length == maxNeurons ?
                mainOffsetY :
                (maxNeurons - 1) * mainOffsetY / (layer.getNeurons().length + 1);
    }

    public void print(Graphics g) {
        printRelations(g);
        printNeurons(g);
    }

    private void printRelations(Graphics g) {
        g.setColor(Color.BLACK);
        for (int i = 0; i < layers.length - 1; i++) {
            for (Point parentLayer : layers[i].getLayer()) {
                for (Point childrenLayer : layers[i + 1].getLayer()) {
                    g.drawLine(
                            parentLayer.getX(),
                            parentLayer.getY(),
                            childrenLayer.getX(),
                            childrenLayer.getY()
                    );
                }
            }
        }
    }

    private void printNeurons(Graphics g) {
        g.setColor(Color.MAGENTA);

        for (LayerCoordinates layerCoordinates : layers) {
            for (Point point : layerCoordinates.getLayer()) {
                g.fillOval(
                        point.getX() - radius / 2,
                        point.getY() - radius / 2,
                        radius,
                        radius
                );
            }
        }
    }

    public LayerCoordinates[] getLayers() {
        return layers;
    }

    public void setLayers(LayerCoordinates[] layers) {
        this.layers = layers;
    }

    private NeuralNetwork neuralNetwork;

    private int xStartPosition = 100;
    private int yStartPosition = 100;

    private int mainOffsetY;
    private int mainOffsetX;

    private int WIDTH = 1280;
    private int HEIGHT = 720;

    private int radius = 25;

    private LayerCoordinates[] layers;
}
