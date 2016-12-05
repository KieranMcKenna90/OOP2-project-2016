package com.bob;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kieran on 29/11/2016.
 */
public class WithdrawGui extends JFrame implements ActionListener {
    float WithdrawAmt, NewBalance;
    JTextField WithdrawTxt;
    JButton WithdrawBtn, BackBtn;
    Container pane = getContentPane();

    public WithdrawGui() {
        ImageIcon img = new ImageIcon("bankicon.png");
        setIconImage(img.getImage());


        setTitle("Withdrawal - Bank Of Ireland");
        setLocation(365,200);
        setSize(600, 380);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container pane = getContentPane();
        setLayout(new BorderLayout());

        pane.setLayout(new BorderLayout());
        this.setContentPane(new JLabel(new ImageIcon("BankOfIreland1.jpg")));

        pane.setLayout(null);

        JLabel WithdrawalLbl = new JLabel("Withdrawal");
        WithdrawalLbl.setFont(new Font("", Font.BOLD, 16));
        WithdrawalLbl.setLocation(250,100);
        WithdrawalLbl.setForeground(Color.white);
        WithdrawalLbl.setSize(180,25);
        this.add(WithdrawalLbl);

        JLabel AmountLbl = new JLabel("Please Enter The Amount:");
        AmountLbl.setLocation(220,125);
        AmountLbl.setForeground(Color.white);
        AmountLbl.setSize(180,25);
        this.add(AmountLbl);

        WithdrawTxt = new JTextField(10);
        WithdrawTxt.setLocation(215,155);
        WithdrawTxt.setSize(160,25);
        this.add(WithdrawTxt);

        WithdrawBtn = new JButton("Withdraw");
        WithdrawBtn.setLocation(225,190);
        WithdrawBtn.setSize(140,25);
        WithdrawBtn.addActionListener(this);
        this.add(WithdrawBtn);

        BackBtn = new JButton("Cancel");
        BackBtn.setLocation(245,220);
        BackBtn.setSize(100,25);
        BackBtn.addActionListener(this);
        this.add(BackBtn);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == WithdrawBtn) {
            WithdrawAmt = Float.parseFloat(WithdrawTxt.getText()); // validte for funds

            HomePage.loggedInUser.getBankAccount().setBalance(HomePage.loggedInUser.getBankAccount().getBalance()- WithdrawAmt);
            JOptionPane.showMessageDialog(null,"        Withdraw Complete\nYour New Balance Is €"
                    + String.format("%.2f",(HomePage.loggedInUser.getBankAccount().getBalance())));
            int choice = JOptionPane.showConfirmDialog(null, "Do You Want To Make Another Withdrawal?", "Withdrawal",
                    JOptionPane.YES_NO_OPTION);

                 if (choice == JOptionPane.NO_OPTION)
            {
                this.dispose();
            }
        }
        if (e.getSource() == BackBtn) {
            this.dispose(); // Closes Window For the lodge GUI
        }
    }
}


