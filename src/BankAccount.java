import java.util.Calendar;
import java.util.Random;
/**
 * BankAccount class
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

    Random rand = new Random();

    Calendar time = Calendar.getInstance();

    //constructor
    /**
     * Default constructor
     */
    public BankAccount()
    {
        this.balance = 0;
        this.statement = new StringBuilder(String.format("%s\t\tAccount Created\t\tAccount number %d\t\tCurrent balance: %d\n",time.getTime(),accountNumber,balance));
    }

    /**
     * overloaded
     * @param balance
     */
    public BankAccount(int balance)
    {
        this.balance = balance;
        this.statement = new StringBuilder(String.format("%s\t\tAccount Created\t\tAccount number %d\t\tCurrent balance: %d\n",time.getTime(),accountNumber,balance));
    }




    //variable declaration

    private final int accountNumber = Math.abs(rand.nextInt());

    private int balance;

    private StringBuilder statement;


    //gets and sets

    //accountNumber
    public int getAccountNumber()
    {
        return this.accountNumber;
    }


    //balance
    public int getBalance()
    {
        return this.balance;
    }

    public void setBalance()
    {

    }


    //statement
    public StringBuilder getStatement()
    {
        return statement;
    }


    //method
    public void deposit(int amount)
    {
        this.balance += amount;
        this.statement.append(String.format("%s\t\tDeposit: %d\t\tAccount Number %d\t\tCurrent Balance: %d\n",time.getTime(),amount,this.accountNumber,balance));
    }

    public void withdraw(int amount)
    {
        this.balance -= amount;
        this.statement.append(String.format("%s\t\tWithdraw: %d\t\tAccount Number %d\t\tCurrent Balance: %d\n",time.getTime(),amount,this.accountNumber,balance));
    }
}
