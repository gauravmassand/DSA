package backtracking;

public class KnightTour {

    public static void main(String[] args) {
        int board[][] = new int[8][8];
        moveKnight(board,0,0,1);

    }

    private static boolean moveKnight(int[][] board, int currentRow, int currentColumn, int moves) {
        if(moves == 64) {
            for(int i=0;i<8;i++) {
                for(int j=0;j<8;j++) {
                    System.out.print(board[i][j] +" ");
                }
                System.out.println();
            }
            return true;
        }

        int[] rowValid = {-2,-1,1,2,2,1,-1,-2};
        int[] columnValid={1,2,2,1,-1,-2,-2,-1};

        for(int i=0;i<rowValid.length;i++) {
            int newRow = currentRow+rowValid[i];
            int newColumn = currentColumn+columnValid[i];
            if(canPlace(board,newRow,newColumn)) {
                moves++;
                board[newRow][newColumn]=moves;
                boolean isSuccess= moveKnight(board,newRow,newColumn,moves);
                if(isSuccess) {
                    return true;
                }
                else {
                    moves--;
                    board[newRow][newColumn]=0;
                }
            }
        }
        return false;

    }

    private static boolean canPlace(int[][] board, int currentRow, int currentColumn) {
        if(currentRow>=0 && currentRow<8 && currentColumn>=0 &&
                currentColumn<8 && board[currentRow][currentColumn]==0) {
            return true;
        }
        return false;
    }
}
