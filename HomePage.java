// This is my Main home page for my program

package com.bob;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Created by @author Kieran McKenna on 28/11/2016.
 * @param
 * @return
 */
public class HomePage extends JFrame implements ActionListener, Serializable{
    JMenu AccMenu, OnlineMenu;
    User user;
    static User loggedInUser; // static because its global an can be seen and also user can change
    ArrayList<User> users;  // array list for my users
    public int cardNumber, pinNumber; // put pin and car5d number public as they can be used in another class
    int age = 0;
    double balance =0;


    public static void main( String[] args ) {
        HomePage frame = new HomePage();
        frame.setVisible(true);
    }

    // constructor
    public HomePage( ) {
        users = new ArrayList<>();

        ImageIcon img = new ImageIcon("bankicon.png");
        setIconImage(img.getImage());

        setTitle( "Welcome To Bank Of Ireland Banking System" );
        setSize( 700,600 );
        setLocation(315,85);
        Container pane = getContentPane();

        JLabel imageLabel = new JLabel(new ImageIcon("bank1.png"));
        pane.add(imageLabel);

        setDefaultCloseOperation( EXIT_ON_CLOSE );

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        createAccMenu();
        menuBar.add(AccMenu);

        createOnlineMenu();
        menuBar.add(OnlineMenu);
    }

    public void save() throws IOException {
        ObjectOutputStream os;
        os = new ObjectOutputStream(new FileOutputStream("users.dat"));
        os.writeObject(users);
        os.close();

    }

    public void load() {
        try{
            ObjectInputStream is;
            is = new ObjectInputStream(new FileInputStream ("users.dat"));
            users  = (ArrayList<User>) is.readObject();
            is.close();
            JOptionPane.showMessageDialog(null,"Account Loaded Successful");
        }
        catch(Exception e){
            showMessageDialog(null,"Load Unsuccessful");
            System.out.println(e.getMessage());
        }

    }
    /******************************* CREATING  USER METHOD *************************************/
    public void addUser(){

        boolean valid = false;
        String adminPassword =  showInputDialog("Please Enter Admin Password: ");

        while (!adminPassword.equals("admin")) {
            adminPassword = showInputDialog("Wrong Password..! Please Try Again");
        }
        String name = showInputDialog("Enter Your Name: ");
             do
             {
                 try
                 {
                     age = Integer.parseInt(showInputDialog("Enter Your Age: "));
                     valid = true;
                 }   catch (NumberFormatException a)

                 {
                     JOptionPane.showMessageDialog(null,"Please Enter Digits Only","error",JOptionPane.ERROR_MESSAGE);
                 }
             }
                     while(!valid);

        String gender = showInputDialog("Enter Your Gender: ");// check for diits

                do
                {
                    try
                    {
                        cardNumber = Integer.parseInt(showInputDialog("Enter Your Card Number: "));
                        valid = true;
                    }   catch (NumberFormatException a)

                    {
                        JOptionPane.showMessageDialog(null,"Please Enter Digits Only","error",JOptionPane.ERROR_MESSAGE);
                    }
                }
                        while(!valid);


                do
                {
                    try
                    {
                        cardNumber = Integer.parseInt(showInputDialog("Enter Your Pin Number: "));
                        valid = true;
                    }   catch (NumberFormatException a)

                    {
                        JOptionPane.showMessageDialog(null,"Please Enter Digits Only","error",JOptionPane.ERROR_MESSAGE);
                    }
                }
                        while(!valid);

                do
                {
                    try
                    {
                        cardNumber = Integer.parseInt(showInputDialog("Enter Your Balance: "));
                        valid = true;
                    }   catch (NumberFormatException a)

                    {
                        JOptionPane.showMessageDialog(null,"Please Enter Digits Only","error",JOptionPane.ERROR_MESSAGE);
                    }
                }
                while(!valid);

        user = new User(name,age,gender,cardNumber, pinNumber, balance);
        users.add(user);

        showMessageDialog(null,name + "s account has successfully created");
    }
    /***************************** CREATING DISPLAY METHOD **************************************/

    public void display(){
        JTextArea area = new JTextArea();
        int numUsers = users.size();
        if (numUsers>1) {
            area.setText("Online Account Holders:\n\n");
            for (int i = 1; i<numUsers; i++)
                area.append("User No: " + i + "\n " + users.get(i).toString()+"\n\n");
            showMessage(area);
        }
        else
            showMessage("No Users in the system");
    }
    /********************************* CREATING ACCOUNT MENU ******************************************/
        private void createAccMenu(){

        AccMenu = new JMenu("Accounts");

        JMenuItem item;

        item = new JMenuItem("Add");
        item.addActionListener(this);
        AccMenu.add(item);

        item = new JMenuItem("Load");
        item.addActionListener(this);
        AccMenu.add(item);

        item = new JMenuItem("Display");
        item.addActionListener(this);
        AccMenu.add(item);

        item = new JMenuItem("Save");
        item.addActionListener(this);
        AccMenu.add(item);
    }
/**************************************** CREATING ONLINE MENU*****************************************************/
    private void createOnlineMenu(){
        OnlineMenu = new JMenu("Online");

        JMenuItem item;
        item = new JMenuItem("Login");
        item.addActionListener(this);
        OnlineMenu.add(item);

        item = new JMenuItem("Exit");
        item.addActionListener(this);
        OnlineMenu.add(item);
    }

    public void showMessage (String s){
        showMessageDialog(null,s);
    }

    public void showMessage (JTextArea s){
        showMessageDialog(null,s);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() .equals("Add")){
            addUser();
        }
        else if (e.getActionCommand().equals("Display")){
            display();
        }
        else if (e.getActionCommand().equals("Load")){
            try{
                load();
            }
            catch (Exception f) { f.printStackTrace(); }
        }
        else if (e.getActionCommand().equals ("Save")){
            try{
                save();
                showMessage("Data Saved Successfully");
            }
            catch (IOException f){
                showMessage("Not able to save the file:\n"+
                        "Check the console printout to see why ");
                f.printStackTrace();
            }
        }
        else if (e.getActionCommand().equals ("Login")){
            int cardNo = Integer.parseInt(showInputDialog("Please Enter Your Card Number?"));
            int pinNo = Integer.parseInt(showInputDialog("Please Enter Your Pin Number?"));

            if(Login(cardNo, pinNo))
            {
                ATMGui gui = new ATMGui();
                gui.setVisible(true);
            }
            else
            {
               JOptionPane.showMessageDialog(null,"Invaild Login Details", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (e.getActionCommand().equals ("Exit")){
            showMessage("Shutting down the system");
            System.exit(0);
        }
        else
            showMessage("Did not work");
    }

    private boolean Login(int cardNo, int pinNo) {

        for (User User : users) { // for every user that is in the arralylist of users check the pin and carnumber to match
            if(cardNo == User.getBankAccount().getcardNumber() && pinNo == User.getBankAccount().getpinNumber()) {
                loggedInUser = User;
                return true;
            }
        }
        return false;
    }

    public boolean isAlpha(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }
}
