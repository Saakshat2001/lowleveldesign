package ATMRoomComponents;

import java.time.LocalDateTime;

public class Card {

    static int PIN_NUMBER = 112211;
    private int cardNumber;
    private int expiryDate;
    private int cvv;
    private UserBankAccount bankAccount;

    public boolean isCorrectPINEntered(int pin){
        if(pin == PIN_NUMBER) return true;
        return false;
    }

    public void setBankAccount(UserBankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public int getBankBalance(){
        return bankAccount.getBalance();
    }

    public void deductBankBalance(int amount) {
        bankAccount.withdrawalBalance(amount);
    }

}
