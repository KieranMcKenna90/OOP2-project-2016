package com.bob;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kieran on 29/11/2016.
 */
public class DepositGui extends JFrame implements ActionListener {
    float lodgeAmt, NewBalance;
    JTextField LodgeTxt;
    JButton LodgeBtn, BackBtn;
    Container pane = getContentPane();

    public DepositGui() {
        ImageIcon img = new ImageIcon("bankicon.png");
        setIconImage(img.getImage());


        setTitle("Lodgement - Bank Of Ireland");
        setLocation(365,200);
        setSize(600, 380);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        Container pane = getContentPane();
        setLayout(new BorderLayout());

        pane.setLayout(new BorderLayout());
        this.setContentPane(new JLabel(new ImageIcon("BankOfIreland1.jpg")));

        pane.setLayout(null);

        //*********************Lodgement Header Label*******************/
        JLabel DepositLbl = new JLabel("Deposit");
        DepositLbl.setFont(new Font("", Font.BOLD, 16));
        DepositLbl.setForeground(Color.white);
        DepositLbl.setLocation(265,100);
        DepositLbl.setSize(180,25);
        this.add(DepositLbl);

        //*******Please Enter The Amount Label************************/
        JLabel LodgeLbl = new JLabel("Please Enter The Amount:");
        LodgeLbl.setLocation(220,125);
        LodgeLbl.setForeground(Color.white);
        LodgeLbl.setSize(180,25);
        this.add(LodgeLbl);

        LodgeTxt = new JTextField(10);
        LodgeTxt.setLocation(215,155);
        LodgeTxt.setSize(160,25);
        this.add(LodgeTxt);

        LodgeBtn = new JButton("Deposit");
        LodgeBtn.setLocation(225,190);
        LodgeBtn.setSize(140,25);
        LodgeBtn.addActionListener(this);
        this.add(LodgeBtn);

        BackBtn = new JButton("Cancel");
        BackBtn.setLocation(245,220);
        BackBtn.setSize(100,25);
        BackBtn.addActionListener(this);
        this.add(BackBtn);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == LodgeBtn) {
            lodgeAmt = Float.parseFloat(LodgeTxt.getText()); // check for letters // limit on what you can lode

            HomePage.loggedInUser.getBankAccount().setBalance(HomePage.loggedInUser.getBankAccount().getBalance()+lodgeAmt);
            JOptionPane.showMessageDialog(null,"        Lodgement Complete\nYour New Balance Is  €"
                    + String.format("%.2f",(HomePage.loggedInUser.getBankAccount().getBalance())));
            int choice = JOptionPane.showConfirmDialog(null, "Do You Want To Make Another Lodgement?", "Lodgement",
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


