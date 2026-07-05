package ATMRoomComponents;

import ATMStates.ATMState;
import ATMStates.IdleState;

public class ATM {


    private static ATM atmObject = new ATM();
    ATMState currentAtmState;
    int noOfTwoThousandNotes;
    int noOfFiveHundredNotes;
    int noOfOneHundredNotes;
    private int atmBalance;

//    private ATM(){
//
//    }


    public static ATM getAtmObject() {
        atmObject.setCurrentAtmState(new IdleState());
        return atmObject;
    }


    public ATMState getCurrentAtmState() {
        return currentAtmState;
    }

    public void setCurrentAtmState(ATMState currentAtmState) {
        this.currentAtmState = currentAtmState;
    }

    public int getNoOfTwoThousandNotes() {
        return noOfTwoThousandNotes;
    }


    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }


    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(int atmBalance, int noOfTwoThousandNotes, int noOfFiveHundredNotes, int noOfOneHundredNotes) {
        this.atmBalance = atmBalance;
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }

    public void deductATMBalance(int amount) {
        atmBalance = atmBalance - amount;
    }

    public void deductTwoThousandNotes(int number) {
        noOfTwoThousandNotes = noOfTwoThousandNotes - number;
    }

    public void deductFiveHundredNotes(int number) {
        noOfFiveHundredNotes = noOfFiveHundredNotes - number;
    }

    public void deductOneHundredNotes(int number) {
        noOfOneHundredNotes = noOfOneHundredNotes - number;
    }

    public void printCurrentATMStatus() {
        System.out.println("Balance: " + atmBalance);
        System.out.println("2kNotes: " + noOfTwoThousandNotes);
        System.out.println("500Notes: " + noOfFiveHundredNotes);
        System.out.println("100Notes: " + noOfOneHundredNotes);
    }
}
