package ATMStates;

import ATMRoomComponents.ATM;
import ATMRoomComponents.Card;
import enums.TransactionType;

public class SelectOperationState extends ATMState{

    public SelectOperationState(){
            showOperations();
    }

    public void selectOperation(ATM atm, Card card, TransactionType type){

            switch (type){
                case CASH_WITHDRAWAL:
                    atm.setCurrentAtmState(new CashWithdrawlState());
                    break;
                case CHECK_BALANCE :
                    atm.setCurrentAtmState(new CheckBalanceState());
                    break;
                default:
                    System.out.println("Invalid Option");
                    exit(atm);
            }
    }

    @Override
    public void exit(ATM atm) {
        System.out.println("Please collect your card");
        atm.setCurrentAtmState(new IdleState());
        System.out.println("Exit happens");
    }

    private void showOperations() {
        System.out.println("Please select the Operation");
        TransactionType.showAllTransactionTypes();
    }


}
