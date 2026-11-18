void main() {
    Scanner scan = new Scanner(System.in);
    //initialization
    int correctPIN = 1234;
    int attemps = 3;
    double balance = 2500.75;
    double VIP = 5000;
    double Regular = 1000;
    double low = 1000;

    //log in
    int cnt = 0;
    do {
        System.out.print("Enter a 4-digits PIN : ");
        int PIN = scan.nextInt();
        if (PIN == correctPIN) {
            System.out.println("Correct PIN");
            cnt++;
            break;
        } else {
            cnt++;
            System.out.println("Incorrect PIN");
            System.out.println((attemps - cnt) + " attemps are left");
        }
    } while (cnt < attemps);
    if (cnt == attemps) {
        System.out.println("Your account has been locked");
        return;
    }
    //MENU
    boolean Exit = false;
    while (!Exit) {
        System.out.println("========= ATM =========");
        System.out.println("1. Check Balance\n" +
                "2. Deposit\n" +
                "3. Withdraw\n" +
                "4. Show Account Status\n" +
                "5. Exit");
        System.out.print("Enter your choice : ");
        int choice = scan.nextInt();
        switch (choice) {
            //Check Balance
            case 1:
                System.out.println("Your account balance is : " + balance);
                break;
            //Deposit
            case 2:
                System.out.print("Enter the amount to deposit : ");
                double deposit = scan.nextDouble();
                if (deposit > 0) {
                    balance += deposit;
                    System.out.println("Updated balance :" + balance);
                } else {
                    System.out.println("Invalid amount");
                }

                break;
            //Withdraw
            case 3:
                System.out.print("Enter the amount to withdraw : ");
                double withdraw = scan.nextDouble();
                if (withdraw == 0) {
                    System.out.println("Transaction cancelled");
                } else if (withdraw > 0 && withdraw <= balance) {
                    balance -= withdraw;
                    System.out.println("Updated balance :" + balance);
                    if (balance == 0) {
                        System.out.println("Warning: Your account is empty");
                    }
                } else {
                    System.out.println("Insufficient balance.");
                }
                break;
            //Show Account Status
            case 4:
                if (balance >= VIP) {
                    System.out.println("VIP Customer");
                } else if (balance >= Regular) {
                    System.out.println("Regular Customer");
                } else {
                    System.out.println("Low Balance");
                }
                break;
            //Exit
            case 5:
                System.out.println("Thank you for using our ATM");
                Exit = true;
                break;
            default:
                System.out.println("Invalid Option");
        }
    }
}
