package Proj;

import java.util.Scanner;

public class ATM {
    static int once = 0;
    static int balance;
    static int pin = 5400;
    static int min_wid = 2000;
    static int max_wid = 100000;
    static int min_dep = 500;
    static int max_dep = 150000;
    public static void inbal()
    {
        ATM pk = new ATM();
        Scanner bal = new Scanner(System.in);
        System.out.println("Enter you balance : ");
        ATM.balance=bal.nextInt();
    }
    public static void check()
    {
        ATM pk = new ATM();
        Scanner read = new Scanner(System.in);
        System.out.println("Do you want to check balance ? (y/n)");
        String check = read.next();
        switch(check)
        {
            case "y":
            {
                System.out.println("Your balance is : "+pk.balance);
                break;
            }
            case "n":
            {
                System.out.println("No problem!");
                break;
            }
        }
    }
    public static void withdraw() {
        ATM pk = new ATM();
        int withdraw;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount you want to withdraw : ");
        withdraw = sc.nextInt();
        if (withdraw < ATM.min_wid) {
            System.out.println("Minimum withdraw is 2000 sir/madam");
        }
        else if (withdraw>ATM.max_wid)
        {
            System.out.println("Maximum withdraw is 1-lakh sir/madam");
        }
        else if (ATM.balance<0 || withdraw>ATM.balance)
        {
            System.out.println("You cannot withdraw");
        }
        else if (ATM.balance>0 || ATM.balance==0)
        {
            ATM.balance = ATM.balance - withdraw;
        }
        System.out.println("You Current Balance Is : "+ATM.balance);
    }
    public static void deposit()
    {
        ATM pk = new ATM();
        int dep;
        Scanner sc = new Scanner(System.in);
        System.out.println("How much would you like to deposit : ");
        dep = sc.nextInt();
        if(dep<min_dep)
        {
            System.out.println("Minimum deposit is 500rs sir/madam");
        }
        else if (dep>max_dep)
        {
            System.out.println("Maximum deposit is 1.5 lakhs sir/madam");
        }
        else
        {
            ATM.balance=ATM.balance + dep;
        }
    }
    public static void pincheck()
    {
        int Pin,number;
        Scanner sc = new Scanner(System.in);
        ATM pk = new ATM();
        System.out.println("Enter the pin : ");
        Pin = sc.nextInt();
        if(ATM.pin==Pin)
        {
            while(ATM.once==0)
            {
                inbal();
                ATM.once=ATM.once+1;
                break;
            }
            System.out.println("\n 1. Withdraw \n 2. Deposit \n 3. Check Balance \n 4. Exit");
            number = sc.nextInt();
            switch(number)
            {
                case 1:
                    withdraw();
                    pincheck();
                    break;
                case 2:
                    deposit();
                    pincheck();
                    break;
                case 3:
                    check();
                    pincheck();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
        else
        {
            System.out.println("Your pin is wrong try again");
            pincheck();
        }
        ATM.once=ATM.once+1;
    }

    public static void main(String[] args)
    {
        pincheck();
    }
}
