public class Board{
    private Piece[][] board = new Piece[3][3];
    


    public boolean place(boolean team, byte x, byte y){
        // Refuse to place if spot is already populated
        if (isPopulated(x,y)) return false;
        // [y][x] because it's row-column
        board[y][x] = new Piece(team);
        return true;
    }
    public boolean place(boolean team, int x, int y){
        System.out.println("You're using integers, you don't deserve to place data.");
        return false;
    }

    public boolean isPopulated(byte x, byte y){
        return board[y][x] != null;
    }

    public Piece[][] getBoard(){
        return board;
    }

    public Piece piece(byte x, byte y){
        return board[y][x];
    }

    public boolean hasWin() {
        for(byte i = 0; i < 3; i++){
            // Check Rows
            if(isArraySame(new Piece[]{board[i][0], board[i][1], board[i][2]})) return true;

            // Check Columns
            if(isArraySame(new Piece[]{board[0][i], board[1][i], board[2][i]})) return true;
        
        }
        // Check diagonals
        if(isArraySame(new Piece[]{board[0][0], board[1][1], board[2][2]})) return true;
        
        if(isArraySame(new Piece[]{board[2][0], board[1][1], board[0][2]})) return true;
        
        return false;
    }

    private boolean isArraySame(Piece[] a){
        for(Piece p : a){
            if(p == null) return false;
        }
        return (a[0].team == a[1].team) && (a[1].team == a[2].team);
    }

    @Override
    public String toString(){
        // I should really use StringBuilder here but importing is less memory efficient
        // God this is completely unreadable, at least the end result looks nice
        String str = new String();
        for(Piece[] row : board){
            for(Piece p : row){
                str = str + "| ";
                if(p == null){
                    str = str + "  ";
                    continue;
                }
                str = str + p + " ";
            }
            str = str + "|\n";
        }
        return str;
    }
}
