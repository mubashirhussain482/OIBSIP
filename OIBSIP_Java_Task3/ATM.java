import java.util.Scanner;
import java.util.ArrayList;
class ATM{
    private Bank bank;
    private Scanner scanner=new Scanner(System.in);
    private Account currentAccount;
    private ArrayList<Transaction> transactionHistory=new ArrayList<>();
    ATM(Bank bank){
        this.bank=bank;
    }
    public void start(){
        if(login()){
            showMenu();
        }
    }
    public boolean login(){
        int attempts=0;
        String userId;
        String pin;
        while(attempts<3){
            System.out.println("=================================");
            System.out.println("       WELCOME TO THE ATM");
            System.out.println("=================================");
            System.out.print("Enter User ID:");
            userId=scanner.next();
            System.out.print("Enter PIN:");
            pin=scanner.next();
            Account account=bank.authenticateUser(userId,pin);
            if(account!=null){
                currentAccount=account;
                System.out.println("Login Successful.");
                System.out.println("Welcome, "+currentAccount.getUserId()+"!");
                return true;
            }
            else{
                attempts++;
                System.out.println("Invalid User ID or PIN.");
                if(attempts<3){
                    System.out.println("Remaining Attempts: "+(3-attempts));
                }           
            }
        }
        System.out.println("Access Denied.");
        return false;
    }
    public void showMenu(){
        int choice;
        do{          
            System.out.println("===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");           
            System.out.println("5. Transaction History");
            System.out.println("6. Quit");
            System.out.print("Enter your choice:");
            while(!scanner.hasNextInt()){
                System.out.println("Invalid input. Please enter a number.");
                System.out.print("Enter your choice:");
                scanner.next();
            }
            choice=scanner.nextInt();
            switch(choice){
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    showTransactionHistory();  
                    break;
                case 6:
                    quit(); 
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }while(choice!=6);
    }
    public void showTransactionHistory(){
        if(transactionHistory.isEmpty()){
            System.out.println("No Transaction History.");
            return;
        }
        for(Transaction transaction : transactionHistory){
            System.out.println(transaction);
        }
    }
    public void withdraw(){
        double amount;
        System.out.print("Enter amount to withdraw:");
        while (!scanner.hasNextDouble()){
            System.out.println("Invalid input. Please enter a valid amount.");
            System.out.print("Enter amount to withdraw:");
            scanner.next();
        }
        amount=scanner.nextDouble();
        if(currentAccount.withdraw(amount)){
            transactionHistory.add(new Transaction("Withdraw",amount,"Cash Withdrawal"));
            System.out.println("Withdrawal Successful.");
            System.out.println("Current Balance: " + currentAccount.getBalance());
        }
        else{
            if(amount<=0){
                System.out.println("Invalid Amount.");
            }
            else{
                System.out.println("Insufficient Funds.");
            }
        }
    }
    public void deposit(){
        double amount;
        System.out.print("Enter amount to deposit:");
        while(!scanner.hasNextDouble()){
            System.out.println("Invalid input. Please enter a valid amount.");
            System.out.print("Enter amount to deposit:");
            scanner.next();
        }
        amount=scanner.nextDouble();
        if(currentAccount.deposit(amount)){
            transactionHistory.add(new Transaction("Deposit",amount,"Cash Deposited"));
            System.out.println("Successfully Deposited.");
            System.out.println("Current Balance: " + currentAccount.getBalance());
        }
        else{
            System.out.println("Invalid Amount.");
        }
    }
    public void transfer() {
        String recipientId;
        double amount;
        System.out.print("Enter Recipient Account ID or User ID: ");
        recipientId=scanner.next();
        Account recipient=bank.findAccount(recipientId);
        if(currentAccount.getAccountId().equals(recipientId)||currentAccount.getUserId().equals(recipientId)){
            System.out.println("You cannot transfer to your own account.");
            return;
        }
        if(recipient==null){
            System.out.println("Account not found.");
            return;
        }
        System.out.print("Enter Amount: ");
        while(!scanner.hasNextDouble()){
            System.out.println("Invalid input. Please enter a valid amount.");
            System.out.print("Enter Recipient Account ID or User ID: ");
            scanner.next();
        }
        amount=scanner.nextDouble();
        if(currentAccount.withdraw(amount)){
            recipient.deposit(amount);
            transactionHistory.add(new Transaction("Transfer",amount,"Transferred to "+recipientId));
            System.out.println("Transfer Successful.");
            System.out.println("Current Balance:"+currentAccount.getBalance());
        }
        else{
            if(amount<=0){
                System.out.println("Invalid Amount.");
            }
            else{
                System.out.println("Insufficient Funds.");
            }
        }
    }
    public void checkBalance(){
        System.out.println("Current Balance:"+currentAccount.getBalance());
    }
    public void quit(){
        System.out.println("Thank you for using our ATM.");
    }
}
