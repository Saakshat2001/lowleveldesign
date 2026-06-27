public class HasMoneyState implements VendingState{


    @Override
    public void insertCoin(VendingMachine vm, Coin coin) {
        vm.balance += coin.value;
        System.out.println("Inserted coin: " + coin.value);
    }

    @Override
    public void selectProduct(VendingMachine vm, int code) {

        Item item = vm.inventory.get(code);
        if(item == null){
            System.out.println("Invalid code");
            return;
        }
         if(vm.balance < item.price){
             System.out.println(
                     "Insufficient money. Price = "
                             + item.price
                             + ", Paid = "
                             + vm.balance
             );
             return;
         }
        if(vm.balance > item.price){
            System.out.println(
                    "Returning change: "
                            + (vm.balance - item.price)
            );
        }
            vm.setState(new DispenseState());
            vm.state.selectProduct(vm, code);
    }
}
