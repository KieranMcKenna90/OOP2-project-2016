package com.bob;

import java.io.Serializable;

public class BankAccount implements Serializable {

    /**This is an instantiable BankAccount class.
     @author Kieran Mc Kenna
     @version 1.0 */
   // Set the attributes// 
    private int cardNumber;
    private int pinNumber;
	private double balance;

	//Creating a No agrument constructor//
    public BankAccount()
    {
        cardNumber = 0;     
    	pinNumber = 0;
        balance = 0;
    }/** Multi argument constructor method
     @param cardNumber,pinNumber,balance of the BankAccount */
	public BankAccount(int cardNumber,int pinNumber,double balance)
	{
	//setting values for attributes using multi agruments constructor//   
		this.cardNumber = cardNumber;
		this.pinNumber= pinNumber;
		this.balance = balance;	
	}
    //Settors//++++++++++++++++++++++++++++++++++++++++++++++++

    /** mutator method to set the user name
     *@param cardNumber the name of the user */
    public void setcardNumber(int cardNumber)
    {this.cardNumber = cardNumber;}

    /** mutator method to set the user name
     *@param pinNumber the name of the user */
    public void setpinNumber(int pinNumber)
    {this.pinNumber = pinNumber;}

    /** mutator method to set the user name
     *@param balance the name of the user */
    public void setBalance(double balance)
    {this.balance = balance;}

    //Gettors//+++++++++++++++++++++++++++++++++++++++++++++++++++

    /** acessor method to return the cardNumber of BankAcount
     *@return the cardNumber of the BankAccount */
    public int getcardNumber()
    {return cardNumber;}

    /** acessor method to return the pinNumber of BankAcount
     *@return the pinNumber of the BankAccount */
    public int getpinNumber()
    {return this.pinNumber;}

    /** acessor method to return the balance of BankAcount
     *@return the balance of the BankAccount */
    public double getBalance()
    {return balance;}

    /** toString method to return the BankAccount details
     *@return the cardNumber,PpinNumber,balance of the BankAccount as a string */
    public String toString()
    {
    	return "CardNumber: "+getcardNumber()+"\nPinNumber: "+getpinNumber()+"\nBalance: " + String.format("%.2f", +getBalance());
    }
    
}//end class

