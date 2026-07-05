package ATMRoomComponents;

import enums.TransactionType;

public class ATMRoom {


                 ATM atm;
                 User user;

                public static void main(String[] args){
                    ATMRoom atmRoom = new ATMRoom();
                    atmRoom.initialize();
                    atmRoom.atm.printCurrentATMStatus();
                    atmRoom.atm.getCurrentAtmState().insertCard(atmRoom.atm, atmRoom.user.getCard());
                   atmRoom.atm.getCurrentAtmState().authenticatePin(atmRoom.atm, atmRoom.user.getCard(),112211);
                    atmRoom.atm.getCurrentAtmState().selectOperation(atmRoom.atm, atmRoom.user.getCard(), TransactionType.CASH_WITHDRAWAL);
                    atmRoom.atm.getCurrentAtmState().cashWithdrawal(atmRoom.atm, atmRoom.user.getCard(),1500);
                    atmRoom.atm.printCurrentATMStatus();
                }
                public void initialize(){

                    // create ATM
                    atm = ATM.getAtmObject();
                    atm.setAtmBalance(3500, 1,2,5);

                    // create User
                    UserBankAccount bankAccount = new UserBankAccount();
                    bankAccount.setBalance(3000);

                    Card card = new Card();
                    card.setBankAccount(bankAccount);

                    this.user = new User();
                    user.setCard(card);

                }

}
