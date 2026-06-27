import java.util.HashMap;
import java.util.Stack;

public class VendingMachine {

        VendingState state = new IdleState();
        int balance = 0;
        HashMap<Integer, Item> inventory = new HashMap<>();

        public void setState(VendingState state){
            this.state = state;
        }

        public void insertCoin(Coin coin){
           state.insertCoin(this, coin);
        }
        public void selectProduct(int code){
            state.selectProduct(this, code);
        }
        public void addItem(int code, Item item){
            inventory.put(code, item);
        }

}
