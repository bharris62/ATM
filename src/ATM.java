import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by BHarris on 2/1/17.
 *
 * This is a bank atm that allows you to deposit and withdraw money, and get current balances.
 */
public class ATM {
    private double currentBalance;
    private String name;
    private double DEFAULT_VAL = 50;
    int[] auditLog = new int[3];

    public ATM() {
        this.currentBalance = DEFAULT_VAL;
    }

    public ATM(double money) {
        this.currentBalance = money;

    }

    public void getName(Scanner name) {
        System.out.println("Welcome to the ATM, please Enter your name: ");

        while (true) {
            String userName = name.nextLine();
            if (!userName.equals("")) {
                this.name = userName;
                break;
            }
        }
    }

    public void transaction(Scanner response) throws Exception {
        while (true) {
            System.out.println("Please Enter 1. Check my balance, 2. Withdraw Funds 3.  Add Funds or 4. Cancel");
            String currentResponse = response.nextLine();

            if (currentResponse.equals("1") || currentResponse.equals("1. Check my balance")) {
                System.out.println("Your currentBalance is $" + this.currentBalance + "\n");
                auditLog[0] += 1;

            } else if (currentResponse.equals("2") || currentResponse.equals("2. Withdraw Funds")) {
                takeMoney(response);

            } else if (currentResponse.equals("3") || currentResponse.equals("3. Add Funds")) {
                addMoney(response);

            } else if (currentResponse.equals("4") || currentResponse.toLowerCase().contains("cancel")) {
                System.out.println("Thank you " + this.name + ", Please come again. Balance: " + this.currentBalance);
                showAuditLog();
                break;
            } else {
                throw new Exception("That is not a logical response. Please Enter a [1,2,3,4].");
            }
        }
    }


    public double addMoney(Scanner response) {
        System.out.print("How much money? ");
        double money = Double.parseDouble(response.nextLine());
        if(money > 0) {
            currentBalance += money;
        }
        System.out.println(currentBalance + "\n");
        auditLog[2] += 1;;
        return this.currentBalance;
    }

    public double takeMoney(Scanner response) {
        System.out.print("How much money? ");
        double money = Double.parseDouble(response.nextLine());
        if (this.currentBalance - money > 0) {
            this.currentBalance -= money;
            System.out.println(this.currentBalance + "\n");
            auditLog[1] += 1;
            return this.currentBalance;
        }
        System.out.println(notEnoughMoney());
        auditLog[1] += 1;
        return this.currentBalance;
    }

    public String notEnoughMoney() {
        return "Not enough money";
    }

    public void showAuditLog(){
        System.out.println("*************************************");
        System.out.printf("*********%s AUDIT LOG***********\n", this.name.toUpperCase() + "'S");
        System.out.println("*************************************");
        for (int i=0; i < auditLog.length; i++){
            switch(i) {
                case 0 :
                    System.out.printf("you have looked at current balance %d times\n", auditLog[0] );
                    break;
                case 1:
                    System.out.printf("you have withdrawn %d times\n", auditLog[1] );
                    break;
                case 2:
                    System.out.printf("You have deposited money %d times\n", auditLog[2]);
                    break;
            }
        }
    }

}
