package ATMStates;

import ATMRoomComponents.ATM;
import ATMRoomComponents.Card;
import AmountWithdrawl.CashWithdrawProcessor;
import AmountWithdrawl.FiveHundredWithdrawProcessor;
import AmountWithdrawl.OneHundredWithdrawProcessor;

public class CashWithdrawlState extends ATMState{

    public CashWithdrawlState() {
        System.out.println("Please enter the Withdrawal Amount");
    }

    public void cashWithdrawal(ATM atmObject, Card card, int withdrawalAmountRequest){

                        if(atmObject.getAtmBalance() < withdrawalAmountRequest){
                            System.out.println("Insufficient fund in the ATM Machine");
                            exit(atmObject);
                        }else if (card.getBankBalance() < withdrawalAmountRequest) {
                            System.out.println("Insufficient fund in the your Bank Account");
                            exit(atmObject);
                        }else{
//                            System.out.println("Aaya ");
                            card.deductBankBalance(withdrawalAmountRequest);
                            atmObject.deductATMBalance(withdrawalAmountRequest);
                            CashWithdrawProcessor withdrawProcessor =
                                    new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null));

                            withdrawProcessor.withdraw(atmObject, withdrawalAmountRequest);
                            exit(atmObject);
                        }
    }


    @Override
    public void exit(ATM atm) {
        System.out.println("Please collect your card");
        atm.setCurrentAtmState(new IdleState());
        System.out.println("Exit happens");
    }
}
