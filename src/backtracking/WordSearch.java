package backtracking;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board={
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println((exist(board,
                "SEE")));
    }

        public static boolean exist(char[][] board, String word) {
            boolean [][] visited = new boolean[board.length][board[0].length];
            String emptyString="";
            for(int row=0;row<board.length;row++) {
                for(int col =0; col<board[0].length;col++) {
                    visited[row][col]=true;
                    boolean success = isWordExists(board,word,emptyString+board[row][col],visited,row,col);
                    if(success) {
                        return true;
                    }
                    else {
                        visited[row][col] = false;
                    }
                }

            }
            return false;

        }


        public static boolean isWordExists(char[][] board, String word, String currentWord,
                                           boolean[][] visited, int row, int column) {


            if(currentWord.equals(word)) {
                return true;
            }

            int [] rowValid = {-1,0,1,0};
            int [] columnValid ={0,1,0,-1};

            for(int i=0;i<rowValid.length;i++) {
                int newRow = row + rowValid[i];
                int newColumn = column + columnValid[i];
                if(canVisit(visited, newRow, newColumn)) {
                    visited[newRow][newColumn] = true;
                    boolean success =isWordExists(board,word,currentWord+board[newRow][newColumn],visited,newRow,newColumn);
                    if(success) {
                        return true;
                    }
                    else {
                        visited[newRow][newColumn] = false;
                    }

                }
            }
            return false;

        }

        public static boolean canVisit(boolean[][] visited, int newRow, int newColumn) {
            if(newRow>=0 && newRow<visited.length && newColumn>=0 && newColumn<visited[0].length && !visited[newRow][newColumn]) {
                return true;
            }
            else {
                return false;
            }
        }

}
