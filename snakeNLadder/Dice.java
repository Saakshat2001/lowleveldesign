import java.util.concurrent.ThreadLocalRandom;

public class Dice {

        int diceCount;
        int min = 1;
        int max = 6;
    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

        public int rollDice(){

        int count = 0;
        int sum = 0;
                while(count < diceCount){
                    sum += ThreadLocalRandom.current().nextInt(min, max+1);
                    count++;
                }
                return sum;
        }

}
