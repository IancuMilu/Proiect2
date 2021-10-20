package app.gui;

import app.classes.Bauturi;
import app.classes.Mancaruri;
import app.classes.Restaurant;
import app.classes.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondWindow extends JFrame implements ActionListener {

    JButton firstButton = new JButton();
    JButton secondButton = new JButton();
    JButton thirdButton = new JButton();
    JButton forthButton = new JButton();
    JButton fifthButton = new JButton();
    JButton sixthButton = new JButton();

    public SecondWindow() {
        JPanel firstPanel = new JPanel();
        firstPanel.setBounds(0,0,300,200);
        firstPanel.setLayout(new BorderLayout(0,0));
        firstPanel.setBackground(Color.red);

        firstButton = new JButton();
        firstButton.addActionListener(this);
        firstButton.setText("Sandwich cu snitel de pui");
        firstButton.setHorizontalAlignment(JButton.CENTER);
        firstButton.setFocusable(false);
        firstButton.setBorder(BorderFactory.createEtchedBorder());
        firstButton.setBackground(new Color(212,170,170));
        firstButton.setFont(new Font("Arial", Font.PLAIN, 20));


        JPanel secondPanel = new JPanel();
        secondPanel.setBounds(300,0,300,200);
        secondPanel.setLayout(new BorderLayout(0,0));
        secondPanel.setBackground(Color.green);

        secondButton = new JButton();
        secondButton.addActionListener(this);
        secondButton.setText("Sandwich cu ton");
        secondButton.setFocusable(false);
        secondButton.setBorder(BorderFactory.createEtchedBorder());
        secondButton.setBackground(new Color(212,170,170));
        secondButton.setFont(new Font("Arial", Font.PLAIN, 20));

        JPanel thirdPanel = new JPanel();
        thirdPanel.setBounds(0,200,300,200);
        thirdPanel.setLayout(new BorderLayout(0,0));
        thirdPanel.setBackground(Color.blue);

        thirdButton = new JButton();
        thirdButton.addActionListener(this);
        thirdButton.setText("Sandwich cu \r salam si cascaval");
        thirdButton.setFocusable(false);
        thirdButton.setBorder(BorderFactory.createEtchedBorder());
        thirdButton.setBackground(new Color(212,170,170));
        thirdButton.setFont(new Font("Arial", Font.PLAIN, 20));

        JPanel forthPanel = new JPanel();
        forthPanel.setBounds(300,200,300,200);
        forthPanel.setLayout(new BorderLayout(0,0));
        forthPanel.setBackground(Color.black);

        forthButton = new JButton();
        forthButton.addActionListener(this);
        forthButton.setText("Sandwich cu ou");
        forthButton.setFocusable(false);
        forthButton.setBorder(BorderFactory.createEtchedBorder());
        forthButton.setBackground(new Color(212,170,170));
        forthButton.setFont(new Font("Arial", Font.PLAIN, 20));

        JPanel fifthPanel = new JPanel();
        fifthPanel.setBounds(0,400,300,200);
        fifthPanel.setLayout(new BorderLayout(0,0));
        fifthPanel.setBackground(Color.white);

        fifthButton = new JButton();
        fifthButton.addActionListener(this);
        fifthButton.setText("Felie de pizza");
        fifthButton.setFocusable(false);
        fifthButton.setBorder(BorderFactory.createEtchedBorder());
        fifthButton.setBackground(new Color(212,170,170));
        fifthButton.setFont(new Font("Arial", Font.PLAIN, 20));

        JPanel sixthPanel = new JPanel();
        sixthPanel.setBounds(300,400,300,200);
        sixthPanel.setLayout(new BorderLayout(0,0));
        sixthPanel.setBackground(Color.white);

        sixthButton = new JButton();
        sixthButton.addActionListener(this);
        sixthButton.setText("Inapoi");
        sixthButton.setFocusable(false);
        sixthButton.setBorder(BorderFactory.createEtchedBorder());
        sixthButton.setBackground(new Color(212,170,170));
        sixthButton.setFont(new Font("Arial", Font.PLAIN, 20));

        this.setTitle("Mancaruri");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(600, 635);
        this.setVisible(true);

        firstPanel.add(firstButton);
        secondPanel.add(secondButton);
        thirdPanel.add(thirdButton);
        forthPanel.add(forthButton);
        fifthPanel.add(fifthButton);
        sixthPanel.add(sixthButton);
        this.add(firstPanel);
        this.add(secondPanel);
        this.add(thirdPanel);
        this.add(forthPanel);
        this.add(fifthPanel);
        this.add(sixthPanel);
    }

    ForthWindow fw = new ForthWindow();

    @Override
    public void actionPerformed (ActionEvent e){
        if(e.getSource() == firstButton){
            Restaurant.setTotalPlata(15);
            Restaurant.cosCumparaturi("Sandwich cu snitel de pui" + "\n");
            fw.append("Sandwich cu snitel de pui \n");
        }

        if(e.getSource() == secondButton){
            Restaurant.setTotalPlata(15);
            Restaurant.cosCumparaturi("Sandwich cu ton" + "\n");
            fw.append("Sandwich cu ton \n");
        }

        if(e.getSource() == thirdButton){
            Restaurant.setTotalPlata(15);
            Restaurant.cosCumparaturi("Sandwich cu salam si cascaval" + "\n");
            fw.append("Sandwich cu salam si cascaval \n");
        }

        if(e.getSource() == forthButton){
            Restaurant.setTotalPlata(15);
            Restaurant.cosCumparaturi("Sandwich cu ou" + "\n");
            fw.append("Sandwich cu ou \n");
        }

        if(e.getSource() == fifthButton){
            Restaurant.setTotalPlata(15);
            Restaurant.cosCumparaturi("Felie de pizza" + "\n");
            fw.append("Felie de pizza \n");
        }

        if(e.getSource() == sixthButton){
            dispose();
        }
    }


}