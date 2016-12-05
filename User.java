package com.bob;

import java.io.Serializable;

public class User implements Serializable {

    /**This is an instantiable user class.
     @author Kieran Mc Kenna
     @version 1.0 */
    // Set the attributes//
    private String name;
    private int age;
	private String gender;
	private BankAccount account;            //this is an example of compostion (A person 'has a' bank account)


    /** Multi argument constructor method
     @param name,age,gender,cardNumber,pinNumber,balance of the user */
	public User(String name,int age,String gender,int cardNumber,int pinNumber,double balance)
	{
        //setting values for attributes using multi agruments constructor//
		this.name = name;
		this.age = age;
		this.gender = gender;

		//creates an instance of my BankAccount class in the Person constructor and populates its fields.
		account = new BankAccount(cardNumber,pinNumber,balance);
	}

    //Settors//++++++++++++++++++++++++++++++++++++++++++++++++

    /** mutator method to set the user name
     *@param name the name of the user */
    public void setName(String name)
    {this.name = name;}

    /** mutator method to set the user age
     *@param age the age of the user */
    public void setAge(int age)
    {this.age = age;}

    /** mutator method to set the user gender
     *@param gender the gender of the user */
    public void setGender(String gender)
    {this.gender = gender;}

    //Gettors//+++++++++++++++++++++++++++++++++++++++++++++++++++

    /** acessor method to return the  age of user
     *@return  the age of the user */
    public int getAge()
    {return this.age;}

    /** acessor method to return the name of user
     *@return the name of the user */
    public String getName()
    {return name;}

    /** acessor method to return the user gender
     *@return the gender of the user */
    public String getGender()
    {return gender;}

    /** acessor method to return the balance of user
     *@return the balance of the user */
	public BankAccount getBankAccount()
		{return account;}

    /** toString method to return the user details
     *@return the name, gender,age,balance of the user as a string */
    public String toString()
    {
    	return "Name: "+getName()+"\nGender: " +getGender() + "\nAge: "+getAge() + "\n" + account.toString();
    }
    
    
}//end class