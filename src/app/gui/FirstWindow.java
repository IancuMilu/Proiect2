package app.gui;

import app.classes.Reducere;
import app.classes.Restaurant;
import app.interfaces.Reduceri;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class FirstWindow extends JFrame implements ActionListener {

    JButton firstButton = new JButton();
    JButton secondButton = new JButton();
    JButton thirdButton = new JButton();
    JButton forthButton = new JButton();

    public FirstWindow() {
        JPanel firstPanel = new JPanel();
        firstPanel.setBounds(0,0,300,300);
        firstPanel.setLayout(new BorderLayout(0,0));
        firstPanel.setBackground(Color.red);

        firstButton = new JButton();
        firstButton.addActionListener(this);
        firstButton.setText("Mancaruri");
        firstButton.setHorizontalAlignment(JButton.CENTER);
        firstButton.setFocusable(false);
        firstButton.setBorder(BorderFactory.createEtchedBorder());
        firstButton.setBackground(new Color(143, 168, 147));
        firstButton.setFont(new Font("Arial", Font.PLAIN, 40));

        JPanel secondPanel = new JPanel();
        secondPanel.setBounds(300,0,300,300);
        secondPanel.setLayout(new BorderLayout(0,0));
        secondPanel.setBackground(Color.green);

        secondButton = new JButton();
        secondButton.addActionListener(this);
        secondButton.setText("Bauturi");
        secondButton.setFocusable(false);
        secondButton.setBorder(BorderFactory.createEtchedBorder());
        secondButton.setBackground(new Color(143, 168, 147));
        secondButton.setFont(new Font("Arial", Font.PLAIN, 40));

        JPanel thirdPanel = new JPanel();
        thirdPanel.setBounds(0,300,300,300);
        thirdPanel.setLayout(new BorderLayout(0,0));
        thirdPanel.setBackground(Color.blue);

        thirdButton = new JButton();
        thirdButton.addActionListener(this);
        thirdButton.setText("Finalizare plata");
        thirdButton.setFocusable(false);
        thirdButton.setBorder(BorderFactory.createEtchedBorder());
        thirdButton.setBackground(new Color(143, 168, 147));
        thirdButton.setFont(new Font("Arial", Font.PLAIN, 40));

        JPanel forthPanel = new JPanel();
        forthPanel.setBounds(300,300,300,300);
        forthPanel.setLayout(new BorderLayout(0,0));
        forthPanel.setBackground(Color.black);

        forthButton = new JButton();
        forthButton.addActionListener(this);
        forthButton.setText("Iesire");
        forthButton.setFocusable(false);
        forthButton.setBorder(BorderFactory.createEtchedBorder());
        forthButton.setBackground(new Color(143, 168, 147));
        forthButton.setFont(new Font("Arial", Font.PLAIN, 40));

        this.setTitle("Meniu Principal");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(600, 635);
        this.setVisible(true);

        firstPanel.add(firstButton);
        secondPanel.add(secondButton);
        thirdPanel.add(thirdButton);
        forthPanel.add(forthButton);
        this.add(firstPanel);
        this.add(secondPanel);
        this.add(thirdPanel);
        this.add(forthPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == firstButton){
            SecondWindow sw = new SecondWindow();
        }

        if(e.getSource() == secondButton){
            ThirdWindow tw = new ThirdWindow();
        }

        if(e.getSource() == thirdButton){


            try {
                FileWriter myWriter = new FileWriter("Chitanta.txt");
                myWriter.write(Restaurant.cosCumparaturi + "\nTotal plata: " + Restaurant.getTotalPlata());

                if(Restaurant.getTotalPlata() > 30 && Restaurant.getTotalPlata() < 60){
                    myWriter.write("\nA fost aplicata o reducere de 5 Lei.");
                }
                else if(Restaurant.getTotalPlata() > 60){
                    myWriter.write("\nA fost aplicata o reducere de 10 Lei.");
                }
                else{
                    myWriter.write("\nNu a fost aplicata nici o reducere.");
                }
                Reducere.reducere(Restaurant.getTotalPlata());
                myWriter.write("\nTotal plata: " + Restaurant.getTotalPlata());
                myWriter.close();
                System.out.println("Chitanta a fost tiparita.");
            } catch (IOException f) {
                System.out.println("Eroare in timpul tiparirii.");
                f.printStackTrace();
            }

            Restaurant.cosCumparaturi("Total plata:" + String.valueOf(Restaurant.getTotalPlata()));
            if(Restaurant.getTotalPlata() > 30 && Restaurant.getTotalPlata() < 60){
                Restaurant.cosCumparaturi( "\nA fost aplicata o reducere de 5 Lei.");
                Restaurant.setTotalPlata(-5);
            }
            else if(Restaurant.getTotalPlata() > 60){
                Restaurant.cosCumparaturi( "\nA fost aplicata o reducere de 10 Lei.");
                Restaurant.setTotalPlata(-10);
            }
            else{
                Restaurant.cosCumparaturi("\nNu a fost aplicata nici o reducere.");
            }
            Restaurant.cosCumparaturi("\nTotal plata:" + String.valueOf(Restaurant.getTotalPlata()));
            ForthWindow Fw = new ForthWindow();

            JOptionPane.showMessageDialog(null,"Plata a fost finalizata");

            System.exit(0);
        }

        if(e.getSource() == forthButton){
            System.exit(0);
        }
    }
}