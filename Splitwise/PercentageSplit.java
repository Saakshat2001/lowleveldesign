import java.util.List;

public class PercentageSplit implements ExpenseSplit{
    @Override
    public void validate(List<Split> splits, double totalAmount) {
        System.out.println("Percentage Validation.... ");
    }
}

