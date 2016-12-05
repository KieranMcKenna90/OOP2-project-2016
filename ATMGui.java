package com.bob;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kieran on 28/11/2016.
 */
public class ATMGui extends JFrame implements ActionListener{

    private JButton b1, b2, b3, b4;

    public ATMGui() {
        ImageIcon img = new ImageIcon("bankicon.png");
        setIconImage(img.getImage());

        setTitle("Online Banking - Bank Of Ireland");
        setLocation(365,200);
        setSize(600, 380);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container pane = getContentPane();
        setLayout(new BorderLayout());

        pane.setLayout(new BorderLayout());
        this.setContentPane(new JLabel(new ImageIcon("BankOfIreland1.jpg")));

        pane.setLayout(null);

        JLabel WelcomeLbl = new JLabel();
        WelcomeLbl.setFont(new Font("Welcome",Font.ITALIC, 18));
        WelcomeLbl.setForeground(Color.white);
        WelcomeLbl.setText("Welcome " + (HomePage.loggedInUser.getName()) + "....");
        WelcomeLbl.setLocation(160,100);
        WelcomeLbl.setSize(220,30);
        this.add(WelcomeLbl);

        b1 = new JButton("Deposit");
        b1.setLocation(220,130);
        b1.setSize(155,30);
        b1.addActionListener(this);
        this.add(b1);

        b2 = new JButton("Withdraw");
        b2.setLocation(220,165);
        b2.setSize(155,30);
        b2.addActionListener(this);
        this.add(b2);

        b3 = new JButton("Display Balance");
        b3.setLocation(220,200);
        b3.setSize(155,30);
        b3.addActionListener(this);
        this.add(b3);

        b4 = new JButton("Cancel");
        b4.setLocation(245,235);
        b4.setSize(105,30);
        b4.addActionListener(this);
        this.add(b4);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== b1){
            DepositGui gui = new DepositGui();
            gui.setVisible(true);
        }
        else if(e.getSource() == b2){
            WithdrawGui gui = new WithdrawGui();
            gui.setVisible(true);
        }
        else if(e.getSource() == b3){
            BalanceDisplayGui gui = new BalanceDisplayGui();
            gui.setVisible(true);
        }
        else if(e.getSource() == b4){
            this.dispose(); // Closes Window
        }
    }
}
