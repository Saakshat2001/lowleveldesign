import java.util.List;

public class UnequalSplit implements ExpenseSplit{
    @Override
    public void validate(List<Split> splits, double totalAmount) {
        double sum = 0;
        for(Split split : splits){
            sum += split.getAmount();

        }

        if(sum != totalAmount){
            throw new RuntimeException("Invalid Unequal Split");
        }
    }
}
