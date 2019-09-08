package GFGMust.graphs;
/*
2
3 4
1 0 0 0 1 1 0 1 0 1 1 1
2 3
3 4
1 1 1 1 0 0 0 1 0 0 0 1
0 3
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPathBinaryMaze {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t>0) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] mat = new int[rows][cols];
            for(int i=0;i<rows;i++) {
                for(int j=0;j<cols;j++) {
                    mat[i][j] = scanner.nextInt();
                }
            }
            int desRow = scanner.nextInt();
            int desCol = scanner.nextInt();

            System.out.println(calculateDistance(mat,rows,cols,0,0,desRow,desCol));
           t--;
        }
    }

    private static int calculateDistance(int[][] mat, int rows,
             int cols, int sourceRow, int sourceCol, int desRow, int desCol) {
        int minDistance = 0;
        boolean[][] visited = new boolean[rows][cols];

        Queue<MazeNode> queue = new LinkedList<>();
        queue.add(new MazeNode(0,0,0));
        visited[0][0]= true;

        int[] validRow = {-1,0,1,0};
        int[] validCol = {0,1,0,-1};

        while(!queue.isEmpty()) {
            MazeNode mazeNode = queue.poll();
            if(mazeNode.x==desRow && mazeNode.y==desCol) {
                return mazeNode.distance;
            }
            minDistance = mazeNode.distance;

            for(int i=0;i<validRow.length;i++) {
                if(canPlace(mat,visited,mazeNode.x+validRow[i],mazeNode.y+validCol[i],desRow,desCol)) {
                    queue.add(new MazeNode(mazeNode.x+validRow[i],mazeNode.y+validCol[i],mazeNode.distance+1));
                }
            }

        }
        return minDistance;


    }

    private static boolean canPlace(int[][] mat, boolean[][] visited, int currentRow, int currentCol, int desRow, int desCol) {
        if(currentRow<0 || currentCol<0 || currentRow>=mat.length ||
                currentCol >=mat[0].length || visited[currentRow][currentCol] || mat[currentRow][currentCol]==0) {
            return false;
        }
        return true;
    }


}

class MazeNode {
    int x;
    int y;
    int distance;

    public MazeNode(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}
