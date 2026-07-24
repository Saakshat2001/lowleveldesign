import java.util.ArrayList;
import java.util.List;

public class Group {

         String name;
         List<User> members = new ArrayList<>();
         ExpenseManager expenseManager;

         public Group(String name){
             this.name = name;
             expenseManager = new ExpenseManager();
         }

         public void addMember(User user){
             members.add(user);
         }

         public void addExpense(User paidBy, double amount, List<Split> splits,
                                ExpenseType type){
             expenseManager.addExpense(paidBy, amount, splits, type);
         }

         public void showBalances(){
             expenseManager.showBalances();
         }

}
