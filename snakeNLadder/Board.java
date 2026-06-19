import java.util.concurrent.ThreadLocalRandom;

public class Board {


            Cell[][] cells;
            int boardSize;
            int numberOfSnakes;
            int numberOfLadders;

            public Board(int boardSize, int numberOfSnakes, int numberOfLadders){
               this.boardSize = boardSize;
               this.numberOfLadders = numberOfLadders;
               this.numberOfSnakes = numberOfSnakes;
            }
            public void initializeBoard(){
                cells = new Cell[boardSize][boardSize];
                for (int i = 0; i < boardSize; i++) {
                    for (int j = 0; j < boardSize; j++) {
                        Cell cellObj = new Cell();
                        cells[i][j] = cellObj;
                    }
                }
                addSnakesAndLadders();
            }

            public void addSnakesAndLadders() {

                while( numberOfSnakes < 0){
                    int snakeHead= ThreadLocalRandom.current().nextInt(1,boardSize*boardSize-1);
                    int snakeTail= ThreadLocalRandom.current().nextInt(1,boardSize*boardSize-1);
                    if(snakeHead<snakeTail) continue;
                    else{
                        Jump snakeObj = new Jump();
                        snakeObj.start = snakeHead;
                        snakeObj.end= snakeTail;
                        Cell cell = getCell(snakeHead);
                        cell.jump=snakeObj;
                    }
                    numberOfSnakes--;
                }

                while (numberOfLadders > 0) {
                    int ladderStart = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
                    int ladderEnd = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
                    if (ladderStart >= ladderEnd) {
                        continue;
                    }

                    Jump ladderObj = new Jump();
                    ladderObj.start = ladderStart;
                    ladderObj.end = ladderEnd;

                    Cell cell = getCell(ladderStart);
                    cell.jump = ladderObj;

                    numberOfLadders--;
                }
             }

             public Cell getCell(int snakeHead){

                int row = snakeHead/boardSize;
                int column = snakeHead%boardSize;
                return cells[row][column];

             }


}
