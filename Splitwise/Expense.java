import java.util.ArrayList;
import java.util.List;

public class Expense {

            double amount;
            User paidBy;
            List<Split> splits;
            public Expense(User paidBy, double amount, List<Split> splits){
                this.paidBy = paidBy;
                this.amount = amount;
                this.splits = splits;
            }

            public User getPaidBy() {
                return paidBy;
            }

    public List<Split> getSplits() {
        return splits;
    }
}
