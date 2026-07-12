import enums.PieceColor;
import enums.PieceType;


public abstract class Piece {

            PieceType type;
            PieceColor color;
        Piece(PieceColor color, PieceType type) {
            this.color = color;
            this.type = type;
        }

        public abstract boolean isValidMove(Board board, Position from, Position to);

        protected boolean canCapture(Cell target){
            return target.piece==null || target.piece.color != this.color;
        }

        public boolean isPathClear(Board board, Position from ,Position to){

            int rowStep = Integer.compare(to.row, from.row);
            int colStep = Integer.compare(to.col, from.col);

            int row = from.row+rowStep;
            int col = from.col+colStep;
            while(row != to.row || col != to.col){
                if (board.cells[row][col].piece != null)
                    return false;
                row += rowStep;
                col += colStep;
            }
            return true;
        }
    @Override
    public String toString() {
        return color + " " + type;
    }

}
