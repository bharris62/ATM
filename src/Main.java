import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM();
        atm.getName(scanner);
        atm.transaction(scanner);
    }


}
