public class DispenseState implements VendingState{
    @Override
    public void insertCoin(VendingMachine vm, Coin coin) {
        System.out.println("Dispensing in progress...");
    }

    @Override
    public void selectProduct(VendingMachine vm, int code) {
        Item item = vm.inventory.get(code);

        System.out.println(
                "Dispensed -> "
                        + item.name
        );

        vm.inventory.remove(code);
        vm.balance = 0;
        vm.setState(new IdleState());
        System.out.println("Machine back to Idle State");
    }
}
