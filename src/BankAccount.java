import java.util.Calendar;
import java.util.Random;
/**
 * Partner_Lab4：Design a BankAccount class
 *
 * @author Z Wang
 * @author Min Htet Khant
 * @since 3/29/2025
 */

/**
 * The BankAccount class:
 *      Declare an instance variable to hold the account number.
 *      Declare an instance variable to hold the balance in the account.
 *      Declare an instance variable to accumulate the transactions in the account.
 *      Use a StringBuilder variable.
 *      Add two constructors: a default constructor that initializes the balance with zero and an overloaded constructor that receives an amount to initialize the balance.
 *      Add methods to deposit, withdraw, return the balance and return a statement with all transactions.
 *      Make sure amount to be deposited or withdrawn is not negative and you have enough funds.
 *      Use the Calendar class to record the day and time of each transaction.
 */
public class BankAccount {

    //create a Random object
    Random rand = new Random();

    //Create a Calendar object
    Calendar time = Calendar.getInstance();

    //constructor
    /**
     * Default constructor
     *  Create a BankAcount object with 0 balance
     */
    public BankAccount()
    {
        this.balance = 0;//set balance to zero
        this.statement = new StringBuilder(String.format("%s\t\tCreating Account\t\tAccount number %d\t\tCurrent balance: %d\t\tAccount Created\n",time.getTime(),accountNumber,balance));//update statement
    }

    /**
     * overloaded constructor
     *  Create a Bank accountant object with the balance passed in param
     * @param balance is an int variable
     */
    public BankAccount(int balance)
    {
        this.balance = balance;//set the balance to param value
        this.statement = new StringBuilder(String.format("%s\t\tCreating Account\t\tAccount number %d\t\tCurrent balance: %d\t\tAccount Created\n",time.getTime(),accountNumber,balance));//update statement
    }




    //variable declaration

    private final int accountNumber = Math.abs(rand.nextInt());//generate a random accountNumber

    private int balance;//balance

    private StringBuilder statement;//statement


    //gets and sets

    //accountNumber
    /**
     * This method will get the Account Number
     * @return the accountNumber
     */
    public int getAccountNumber()
    {
        return this.accountNumber;
    }


    //balance

    /**
     * This method will get the balance
     * @return the balance
     */
    public int getBalance()
    {
        return this.balance;
    }


    //statement

    /**
     * This method will get the statement
     * @return the bank statement
     */
    public StringBuilder getStatement()
    {
        return statement;
    }


    //method

    /**
     * This method will deposit money to the balance
     *      -if the param is negative, balance will remain unchanged, add an error message to statement
     *      -if the param is positive, it's a valid transaction, it will add
     *  the correct amount to the balance then add a transaction record to the statement
     * @param amount an int variable
     */
    public void deposit(int amount)
    {
        //determine if the transaction is valid(positive) or not(negative)
        if (amount < 0)//if the amount is invalid(negative)
        {
            this.statement.append(String.format("%s\t\tDeposit: %d\t\t\tAccount Number %d\t\tCurrent Balance: %d\t\tTransaction Incomplete: deposit cannot be negative\n", time.getTime(), amount, this.accountNumber, balance));//print an error message to the statement
        }
        //if the transaction is valid(positive)
        else
        {
            this.balance += amount;//add amount to the balance
            this.statement.append(String.format("%s\t\tDeposit: %d\t\t\tAccount Number %d\t\tCurrent Balance: %d\t\tTransaction Completed\n", time.getTime(), amount, this.accountNumber, balance));//add a message to the statement
        }
    }


    /**
     * This method will withdraw money from the balance
     *  -withdraw cannot be negative
     *  -withdraw amount cannot be greater than current balance
     *  -if withdraw amount is valid, it will add a transaction to the statement
     * @param amount an int variable
     */
    public void withdraw(int amount)
    {
        if(amount < 0)//if amount is negative
        {
            this.statement.append(String.format("%s\t\tWithdraw: %d\t\t\tAccount Number %d\t\tCurrent Balance: %d\t\tTransaction Incomplete: cannot withdraw negative amount\n",time.getTime(),amount,this.accountNumber,balance));//add an error message to the statement
        }
        else//if amount is positive
        {
            if(this.getBalance() > amount)//if the balance is greater than withdraw amount
            {
                this.balance -= amount;//withdraw money from balance
                this.statement.append(String.format("%s\t\tWithdraw: %d\t\t\tAccount Number %d\t\tCurrent Balance: %d\t\tTransaction Completed\n",time.getTime(),amount,this.accountNumber,balance));//transaction completed
            }
            else//if the balance is less than withdraw amount
            {
                this.statement.append(String.format("%s\t\tWithdraw: %d\t\t\tAccount Number %d\t\tCurrent Balance: %d\t\tTransaction Incomplete: Not enough balance\n",time.getTime(),amount,this.accountNumber,balance));//print an error message
            }
        }
    }
}

