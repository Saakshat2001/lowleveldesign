import enums.PieceColor;
import enums.PieceType;

public class King extends Piece{
    King(PieceColor color) {
        super(color, PieceType.KING);
    }

    @Override
    public boolean isValidMove(Board board, Position from, Position to) {

                Cell target = board.getCell(to);
                if(!canCapture(target)){
                    return false;
                }
                int dr = Math.abs(from.row - to.row);
                int dc = Math.abs(from.col - to.col);
                return dr<=1 && dc<=1;
    }


}
