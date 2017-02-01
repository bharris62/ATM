import java.util.Scanner;

/**
 * Created by BHarris on 2/1/17.
 */
public class ATM {
    private double currentBalance = 1000;
    private String name;

    public ATM(){

    }

    public void getName(Scanner name){
        System.out.print("Welcome to the ATM: Please enter your name: ");
        this.name = name.nextLine();
        System.out.printf("Howdy, %s\n", this.name);

    }

    public void transaction(Scanner response){
        System.out.println("Please Enter 1. Check my balance, 2. Withdraw Funds 3.  Add Funds or 4. Cancel");
        String currentResponse = response.nextLine();

        if (currentResponse.equals("1") || currentResponse.equals("1. Check my balance") ){
            System.out.println(getCurrentBalance());
        } else if (currentResponse.equals("2") || currentResponse.equals("2. Withdraw Funds")) {
            System.out.print("How much money? ");
            double money = Double.parseDouble(response.nextLine());
            takeMoney(money);
            System.out.println(getCurrentBalance());
        } else if(currentResponse.equals("3") || currentResponse.equals("3. Add Funds")) {
            System.out.print("How much money? ");
            double money = Double.parseDouble(response.nextLine());
            addMoney(money);
            System.out.println(getCurrentBalance());
        }else if(currentResponse.equals("4") || currentResponse.equals("4. Cancel") || currentResponse.equals("4. Cancel")){
            System.out.println("Thank you and please come again.");
        }


    }

    public String getCurrentBalance(){
        return "" + "Your currentBalance is $" +this.currentBalance;
    }

    public double addMoney(double money) {
        currentBalance+=money;
        return this.currentBalance;
    }

    public double takeMoney(double money) {
        if (this.currentBalance - money > 0) {
            this.currentBalance-= money;
            return this.currentBalance;
        }
        System.out.println(notEnoughMoney());
        return this.currentBalance;

    }

    public String notEnoughMoney(){
        return "Not enough money";
    }


}
