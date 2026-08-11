public class OIBSIP_Java_Task3{
    public static void main(String[] args){
        Bank bank = new Bank();
        ATM atm = new ATM(bank);
        atm.start();
    }
}
