public class IdleState implements VendingState {
    @Override
    public void insertCoin(VendingMachine vm, Coin coin) {
                vm.balance += coin.value;
        System.out.println("Inserted coin: " + coin.value);
                vm.setState(new HasMoneyState());
    }

    @Override
    public void selectProduct(VendingMachine vm, int code) {
        System.out.println("Please insert money first");
    }
}
