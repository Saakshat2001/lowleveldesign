import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static void main() {

                    User a = new User("1" , "Alice");
                    User b = new User("2" , "Bob");
                    User c = new User("3" , "Charlie");

                    Group group = new Group("Trip");
                    group.addMember(a);
                    group.addMember(b);
                    group.addMember(c);

        List<Split> breakfast= Arrays.asList(
                new Split(a, 300),
                new Split(b, 300),
                new Split(c, 300)
        );

        group.addExpense(a , 900, breakfast, ExpenseType.EQUAL);


        List<Split> lunch= Arrays.asList(
                new Split(a, 400),
                new Split(b, 100)
        );
        group.addExpense(b, 500, lunch, ExpenseType.UNEQUAL);
        group.showBalances();

//                    ExpenseManager expenseManager = new ExpenseManager();
//                    List<Split> splits= Arrays.asList(
//                            new Split(a, 300),
//                            new Split(b, 300),
//                            new Split(c, 300)
//                    );
//                    expenseManager.addExpense(a,900,splits,ExpenseType.EQUAL);
//
//        List<Split> splits2 = Arrays.asList(
//                new Split(a, 400),
//                new Split(b, 100)
//        );
//        expenseManager.addExpense(b,500,splits2 ,ExpenseType.UNEQUAL);
//
//
//                    expenseManager.showBalances();

    }
}
