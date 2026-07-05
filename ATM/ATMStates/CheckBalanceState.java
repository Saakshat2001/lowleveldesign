package ATMStates;

import ATMRoomComponents.ATM;
import ATMRoomComponents.Card;

public class CheckBalanceState extends ATMState{

    @Override
    public void displayBalance(ATM atm, Card card) {
        System.out.println("Your Balance is: " + card.getBankBalance());
        exit(atm);
    }


    @Override
    public void exit(ATM atm) {
        System.out.println("Please collect your card");
        atm.setCurrentAtmState(new IdleState());
        System.out.println("Exit happens");
    }
}
