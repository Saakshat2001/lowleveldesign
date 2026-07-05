package ATMStates;

import ATMRoomComponents.ATM;
import ATMRoomComponents.Card;

public class HasCardState extends ATMState{

        public HasCardState(){
            System.out.println("enter your card pin number");
        }

        @Override
        public void authenticatePin(ATM atm, Card card, int pin){
            boolean isCorrectPinEntered = card.isCorrectPINEntered(pin);
            if (isCorrectPinEntered) {
                atm.setCurrentAtmState(new SelectOperationState());
            }else{
                System.out.println("Invalid PIN Number");
                exit(atm);
            }
        }

    @Override
    public void exit(ATM atm) {
        System.out.println("Please collect your card");
        atm.setCurrentAtmState(new IdleState());
        System.out.println("Exit happens");
    }

}
