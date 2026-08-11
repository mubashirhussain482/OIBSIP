import java.util.ArrayList;
class Bank{
    private ArrayList<Account> accounts=new ArrayList<>();
    public Bank(){
        accounts.add(new Account("Mubashir","2006","ACC_101",300000));
        accounts.add(new Account("Tajamil","1673","ACC_102",50000));
        accounts.add(new Account("Muzammil","8040","ACC_103",100000));
    }
    public Account authenticateUser(String userId, String pin){
        for(Account account:accounts) {
            if(account.getUserId().equals(userId)&&account.getPin().equals(pin)){
                return account;
            }
        }
        return null;
    }
    public Account findAccount(String Id){
        for(Account account:accounts) {
            if(account.getAccountId().equals(Id)||account.getUserId().equals(Id)){
                return account;
            }
        }
        return null;
    }
}
