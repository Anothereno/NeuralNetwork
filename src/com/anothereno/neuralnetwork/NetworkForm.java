package com.anothereno.neuralnetwork;

import com.anothereno.draw.DrawPanel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class NetworkForm extends JFrame implements Runnable, MouseListener {
    public NetworkForm(NeuralNetwork neuralNetwork){
        configForm(neuralNetwork);
        new Thread().start();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void run() {
        repaint();
    }

    private void configForm(NeuralNetwork neuralNetwork) {
        drawPanel = new DrawPanel(neuralNetwork, WIDTH, HEIGHT);
        FRAME.getContentPane().add(drawPanel);

        FRAME.setSize(WIDTH, HEIGHT);
        FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FRAME.setVisible(true);
    }

    private JFrame FRAME = new JFrame("Neural network");

    private int WIDTH = 1280;
    private int HEIGHT = 720;

    private DrawPanel drawPanel;
}
