import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {

        List<Expense> expenses= new ArrayList<>();

        BalanceManager balanceManager   = new BalanceManager();

        public void addExpense(User paidBy, double amount, List<Split> splits,
                               ExpenseType type){
            ExpenseSplit strategy = SplitFactory.getSplit(type);
            strategy.validate(splits, amount);
            Expense expense = new Expense(paidBy, amount, splits);
            expenses.add(expense);
            balanceManager.updateBalance(paidBy , splits);
        }

        public void showBalances(){
//                    for(Expense expense : expenses){
//                        System.out.println("Paid By: "+expense.getPaidBy().getName());
//
//                        for(Split split : expense.getSplits()){
//
//                            if(split.getUser() != expense.getPaidBy()){
//                                System.out.println(
//                                        split.getUser().getName()+ " owes "+
//                                                split.getAmount()+" to "
//                                        + expense.getPaidBy().getName()
//                                );
//                            }
//                            System.out.println();
//                        }
//                    }
            balanceManager.showBalances();
        }
}
