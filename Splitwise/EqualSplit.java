import java.util.List;

public class EqualSplit implements ExpenseSplit{
    @Override
    public void validate(List<Split> splits, double totalAmount) {
        double each = totalAmount/ splits.size();
        for(Split split : splits){
            if(split.getAmount() != each){
                throw new RuntimeException("Invalid Equal Split");
            }
        }
    }
}
