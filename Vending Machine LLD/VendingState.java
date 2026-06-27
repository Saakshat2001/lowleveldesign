public interface VendingState {

       public void insertCoin(VendingMachine vm, Coin coin);
       public void selectProduct(VendingMachine vm, int code);

}
