public class VMDriver {

        public static void main(String[] args) {

            VendingMachine vm = new VendingMachine();

            vm.addItem(101, new Item("Coke", 12));
            vm.addItem(102, new Item("Pepsi", 15));
            vm.addItem(103, new Item("Juice", 18));

            System.out.println("=== User 1 ===");

            vm.insertCoin(Coin.TEN);
            vm.insertCoin(Coin.FIVE);

            vm.selectProduct(102);

            System.out.println();

            System.out.println("=== User 2 ===");

            vm.selectProduct(101);

            vm.insertCoin(Coin.FIVE);

            vm.selectProduct(101);

            vm.insertCoin(Coin.TEN);

            vm.selectProduct(101);

            System.out.println();

            System.out.println("=== User 3 ===");

            vm.insertCoin(Coin.TEN);
            vm.insertCoin(Coin.TEN);

            vm.selectProduct(101);
        }

}
