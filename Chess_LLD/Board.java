import enums.PieceColor;
import enums.PieceType;

public class Board {

                Cell[][] cells;
                public Board(){
                    cells = new Cell[8][8];
                    for(int i=0; i<8; i++){
                        for(int j=0; j<8; j++){
                            cells[i][j]= new Cell(new Position(i,j));
                        }
                    }
                    initialize();
                }

                public Cell getCell(Position position){
                    return cells[position.row][position.col];
                }

                public void initialize(){
                    // White Pieces
                    cells[0][0].piece = new Rook(PieceColor.WHITE);
                    cells[0][1].piece = new Knight(PieceColor.WHITE);
                    cells[0][2].piece = new Bishop(PieceColor.WHITE);
                    cells[0][3].piece = new Queen(PieceColor.WHITE);
                    cells[0][4].piece = new King(PieceColor.WHITE);
                    cells[0][5].piece = new Bishop(PieceColor.WHITE);
                    cells[0][6].piece = new Knight(PieceColor.WHITE);
                    cells[0][7].piece = new Rook(PieceColor.WHITE);

                    for(int i=0; i<8 ;i++){
                        cells[1][i].piece = new Pawn(PieceColor.WHITE);
                    }

                    // Black Pieces
                    cells[7][0].piece = new Rook(PieceColor.BLACK);
                    cells[7][1].piece = new Knight(PieceColor.BLACK);
                    cells[7][2].piece = new Bishop(PieceColor.BLACK);
                    cells[7][3].piece = new Queen(PieceColor.BLACK);
                    cells[7][4].piece = new King(PieceColor.BLACK);
                    cells[7][5].piece = new Bishop(PieceColor.BLACK);
                    cells[7][6].piece = new Knight(PieceColor.BLACK);
                    cells[7][7].piece = new Rook(PieceColor.BLACK);

                    for(int i=0;i<8;i++)
                        cells[6][i].piece = new Pawn(PieceColor.BLACK);
                }


}
