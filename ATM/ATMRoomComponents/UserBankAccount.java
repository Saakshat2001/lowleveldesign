package ATMRoomComponents;

public class UserBankAccount {

    int balance;

    public void withdrawalBalance(int amount){
        this.balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
