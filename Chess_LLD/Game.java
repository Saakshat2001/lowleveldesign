import enums.GameStatus;
import enums.PieceColor;

import java.util.ArrayList;
import java.util.List;

public class Game {


        Board board;
        Player winner;
        Player white;
        Player black;
    GameStatus status;
    List<Move> history;
    Player currentPlayer;

        public Game(){
            white = new Player("Alice" , PieceColor.WHITE);
            black = new Player("Bob" , PieceColor.BLACK);
            board = new Board();
            currentPlayer = white;
            status = GameStatus.IN_PROGRESS;
            history = new ArrayList<>();
            winner = null;
        }
        public boolean makeMove(Position from , Position to){

                   Cell source = board.getCell(from);
                   Cell destination = board.getCell(to);
                   if(source == null || destination==null) return false;
                   if(source.piece == null) return false;
                    Piece piece = source.piece;
                    if(piece.color != currentPlayer.color) return false;
                           if(!piece.isValidMove(board, from, to )){
                       return false;
                   }
                   Piece capturePiece = destination.piece;
                    destination.piece = piece;

                source.piece = null;
                history.add(new Move(from, to, piece, capturePiece));

                if(capturePiece instanceof King){
                    status = currentPlayer.color == PieceColor.BLACK?GameStatus.BLACK_WIN:
                            GameStatus.WHITE_WIN;
                    winner = currentPlayer;
                }
                switchTurn();
                return true;

        }

        public void switchTurn(){
            currentPlayer = currentPlayer == white?black:white;
        }

    public void printResult() {

        System.out.println("\n========================");
        System.out.println("Game Status : " + status);

        if (winner != null) {
            System.out.println("Winner : " + winner.name);
        }

        System.out.println("========================");
    }

}
