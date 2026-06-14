import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {

    Deque<Player> players;
       Board gameBoard;
       Player winner;

       public void initializeGame(){
            players = new LinkedList();
           Player p1 = new Player("Player A", new PlayingPiece(PieceType.O));
           Player p2 = new Player("Player B", new PlayingPiece(PieceType.X));
           players.add(p1);
           players.add(p2);
           gameBoard = new Board(3);
       }

       public GameStatus startGame() {
           while(true) {
               Player currentPlayer = players.removeFirst();
               if (!gameBoard.checkFreeSpace()) return GameStatus.DRAW;
               gameBoard.printBoard();

               Scanner inputScanner = new Scanner(System.in);
               System.out.println(currentPlayer.playerName + " Enter move index: ");
               String s = inputScanner.next();
               String[] values = s.split(",");
               int row = Integer.parseInt(values[0]);
               int column = Integer.parseInt(values[1]);
               if (row < 0 || column < 0 || row >= gameBoard.size || column >= gameBoard.size) {
                   System.out.println("Add correct values ");
                   players.addFirst(currentPlayer);
                   continue;
               }

           //    boolean checkIfAlreadyOccupied = gameBoard.checkFreeSpace();
//               if(!checkIfAlreadyOccupied){
//                   System.out.println("Position is already occupied ");
//                   players.addFirst(currentPlayer);
//                   continue;
//               }

//               board.board[row][column] = currentPlayer.playingPiece;
               boolean validMove= gameBoard.addPiece(row,column, currentPlayer.playingPiece);
               if(!validMove){
                   System.out.println("Position already occupied!! Try Again ");
                   players.addFirst(currentPlayer);
                   continue;
               }
               if(checkForWinner(row, column, currentPlayer.getPlayingPiece().pieceType)){
                        System.out.println("Winner Found !! "+currentPlayer.getPlayerName());
                        winner = currentPlayer;
                        return GameStatus.WIN;
               }
               players.add(currentPlayer);
           }
       }

    public boolean checkForWinner(int row, int column, PieceType pieceType) {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        // Check Row
        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType != pieceType) {
                rowMatch = false;
                break;
            }
        }

        // Check Column
        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[i][column] == null || gameBoard.board[i][column].pieceType != pieceType) {
                columnMatch = false;
                break;
            }
        }

        // Check Diagonally
        for (int i = 0, j = 0; i < gameBoard.size; i++, j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
                break;
            }
        }

        // Check Anti-Diagonally
        for (int i = 0, j = gameBoard.size - 1; i < gameBoard.size; i++, j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
                break;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}

