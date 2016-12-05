package com.bob;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kieran on 29/11/2016.
 */
public class BalanceDisplayGui extends JFrame implements ActionListener {
    float WithdrawAmt, NewBalance;
    JTextField WithdrawTxt;
    JButton WithdrawBtn, BackBtn;
    Container pane = getContentPane();

    public BalanceDisplayGui() {
        ImageIcon img = new ImageIcon("bankicon.png");
        setIconImage(img.getImage());


        setTitle("Display Balance - Bank Of Ireland");
        setLocation(365,200);
        setSize(600, 380);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container pane = getContentPane();
        setLayout(new BorderLayout());

        pane.setLayout(new BorderLayout());
        this.setContentPane(new JLabel(new ImageIcon("BankOfIreland1.jpg")));

        pane.setLayout(null);

        JLabel WithdrawalLbl = new JLabel("Display Balance");
        WithdrawalLbl.setFont(new Font("", Font.BOLD, 16));
        WithdrawalLbl.setForeground(Color.WHITE);
        WithdrawalLbl.setLocation(230,100);
        WithdrawalLbl.setSize(180,25);
        this.add(WithdrawalLbl);

        JLabel BalanceLbl = new JLabel("Your Current Balance Is:");
        BalanceLbl.setLocation(220,125);
        BalanceLbl.setForeground(Color.white);
        BalanceLbl.setSize(180,25);
        this.add(BalanceLbl);

        JTextArea BalanceDisplayLbl = new JTextArea();
        BalanceDisplayLbl.setFont(new Font("Welcome ", Font.ITALIC, 20));
        BalanceDisplayLbl.setText(String.format("€%.2f", + (HomePage.loggedInUser.getBankAccount().getBalance())));
        BalanceDisplayLbl.setBorder(BorderFactory.createLineBorder(Color.white,3));
        BalanceDisplayLbl.setLocation(245,155);
        BalanceDisplayLbl.setBackground(Color.white);
        BalanceDisplayLbl.setForeground(Color.darkGray);
        BalanceDisplayLbl.setSize(100,30);
        this.add(BalanceDisplayLbl);


        BackBtn = new JButton("Main Menu");
        BackBtn.setLocation(245,220);
        BackBtn.setSize(100,25);
        BackBtn.addActionListener(this);
        this.add(BackBtn);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BackBtn) {
            this.dispose(); // Closes Window For the lodge GUI
        }
    }
}


