import java.util.Deque;
import java.util.LinkedList;

public class Game {

        Board board;
        Deque<Player> players= new LinkedList<>();
        Dice dice;
        Player winner;

        public Game(){
            initializeGame();
        }

        public void initializeGame(){
            board = new Board(10, 5,4);
            board.initializeBoard();
            addPlayers();
             dice = new Dice(1);
            winner=null;

        }

        public void addPlayers(){
            Player p1 = new Player("Player-1", 0);
            Player p2 = new Player("Player-2", 0);
            players.add(p1);
            players.add(p2);
        }

        public void startGame(){
                while(winner == null){
                    // get current player
                    Player playerTurn = findPlayerTurn();
                    System.out.println("Player turn:" + playerTurn.playerId + " current position is: " + playerTurn.currentPosition);

                    // roll the dice
                    int diceNumbers = dice.rollDice();

                    //add diceNumber to current position of player
//                    int newP= playerTurn.currentPosition+diceNumbers;
                    int playerNewPosition = playerTurn.currentPosition + diceNumbers;
                    playerNewPosition = jumpCheck(playerNewPosition);

                    playerTurn.currentPosition = playerNewPosition;
                    System.out.println("Player turn:" + playerTurn.playerId + " new Position is: " + playerNewPosition);
                    if (playerNewPosition >= board.boardSize * board.boardSize - 1) {
                        winner = playerTurn;
                    }
                }
            System.out.println("\n===> The Winner is:" + winner.playerId);
        }

        public int jumpCheck(int playerNewPosition){
            if(playerNewPosition >= board.boardSize* board.boardSize){
                return playerNewPosition;
            }

            Cell cell = board.getCell(playerNewPosition);
            // on that cell might be that a snake is ending or ladder is ending
            // so need to check
            if(cell.jump != null && cell.jump.start == playerNewPosition){
                String jumpBy = (cell.jump.start < cell.jump.end) ? "Ladder" : "Snake";
                System.out.println("[+] Jump done by: " + jumpBy);
                return cell.jump.end;
            }
            return playerNewPosition;

        }

        public Player findPlayerTurn(){
            Player current = players.removeFirst();
            players.add(current);
            return current;
        }

}





















