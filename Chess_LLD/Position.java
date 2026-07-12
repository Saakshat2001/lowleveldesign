public class Position {

          int row;
          int col;

          public Position(int row, int col){
              this.row = row;
              this.col = col;
          }

          public boolean isValid(){
              return row<8 && row>=0 && col<8 && col>=0;
          }

          @Override
            public String toString(){
              return "(" + row + "," + col + ")";
          }

}
