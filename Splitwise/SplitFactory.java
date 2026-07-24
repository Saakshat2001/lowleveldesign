public class SplitFactory {

                public static ExpenseSplit getSplit(ExpenseType type){

                    switch(type){

                        case EQUAL:
                            return new EqualSplit();
                        case UNEQUAL:
                            return new UnequalSplit();
                        case PERCENTAGE:
                            return new PercentageSplit();
                        default:
                            throw  new RuntimeException("Invalid type");

                    }
                }

}
