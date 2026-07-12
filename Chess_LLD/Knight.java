import enums.PieceColor;
import enums.PieceType;

public class Knight extends Piece{
    Knight(PieceColor color) {
        super(color, PieceType.KNIGHT);
    }

    @Override
    public boolean isValidMove(Board board, Position from, Position to) {
        if (from.row == to.row && from.col == to.col)
            return false;

        Cell target = board.getCell(to);

        if (!canCapture(target))
            return false;

        int rowDiff = Math.abs(to.row - from.row);
        int colDiff = Math.abs(to.col - from.col);

        return (rowDiff == 2 && colDiff == 1) ||
                (rowDiff == 1 && colDiff == 2);
    }
}
