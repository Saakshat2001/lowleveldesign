package AmountWithdrawl;

import ATMRoomComponents.ATM;

public class FiveHundredWithdrawProcessor extends CashWithdrawProcessor{
    public FiveHundredWithdrawProcessor(CashWithdrawProcessor cashWithdrawalProcessor) {
        super(cashWithdrawalProcessor);
    }

    public void withdraw(ATM atm, int remainingAmount) {

            int required = remainingAmount/500;
            int balance = remainingAmount%500;
//            System.out.println(required+" "+balance);
            if(required <= atm.getNoOfFiveHundredNotes()){
                    atm.deductFiveHundredNotes(required);
            }
            else if (required > atm.getNoOfFiveHundredNotes()) {
                int g = atm.getNoOfFiveHundredNotes();
                atm.deductFiveHundredNotes(atm.getNoOfFiveHundredNotes());
//                System.out.println(required+" "+atm.getNoOfFiveHundredNotes());
                balance += (required-g)*500;
//                System.out.println("balance is "+ balance);
            }

            if(balance != 0) super.withdraw(atm,balance);
    }
}
