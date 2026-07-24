
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalanceManager {


    //added later

    // debtor -> (creditor -> amount)
    Map<User, Map<User , Double>> balances = new HashMap<>();
    public void updateBalance(User paidBy, List<Split> splits){

        for(Split split : splits){
            if(split.getUser() == paidBy) continue;

            balances.putIfAbsent(split.getUser(), new HashMap<>());
            Map<User , Double> map = balances.get(split.getUser());
            map.put(paidBy, map.getOrDefault(paidBy, 0.0)+split.getAmount());
        }
    }

    public void showBalances(){
        for(User debtor:balances.keySet()){
            Map<User, Double> map = balances.get(debtor);
            for(User creditor : map.keySet()){
                System.out.println(debtor.getName()+ " owes "+
                        map.get(creditor) + " to "+ creditor.getName());

            }
        }
    }
}
