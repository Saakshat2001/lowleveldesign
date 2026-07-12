import enums.PieceColor;
import enums.PieceType;

public class Pawn extends Piece{
    Pawn(PieceColor color) {
        super(color, PieceType.PAWN);
    }

    @Override
    public boolean isValidMove(Board board, Position from, Position to) {


                  Cell target = board.getCell(to);

        int direction = (color == PieceColor.WHITE) ? 1 : -1;
                  int rowDiff = to.row - from.row;
                  int colDiff = Math.abs(to.col - from.col);

                  // move one piece
                  if(colDiff == 0 && rowDiff == direction && target.piece == null){
                      return true;
                  }

                  // Capture diagonally
                if(colDiff == 1 && rowDiff==direction && target.piece!=null
                && target.piece.color !=  this.color){
                    return true;
                }

                return false;

    }
}
