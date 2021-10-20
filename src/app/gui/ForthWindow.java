package app.gui;

import app.classes.Restaurant;

import javax.swing.*;
import java.awt.*;

public class ForthWindow extends JFrame {

    JTextArea text = new JTextArea("First text");

    public ForthWindow() {
        text.setBounds(10, 10, 300, 600);
        text.setText(Restaurant.cosCumparaturi + "\n");
        this.add(text);
        this.setTitle("Cos cumparaturi");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(400, 700);
        this.setLocation(600,0);
        this.setVisible(true);
        text.update(text.getGraphics());

    }

    public void append(String x){
        text.append(x);

    }
}
