package GFGMust.graphs;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if(grid.length==0) {
            return 0;
        }
        int count =0;
        int rowCount = grid.length;
        int columnCount = grid[0].length;
        for(int i=0;i<rowCount;i++) {
            for(int j=0;j<columnCount;j++) {
                if(grid[i][j]=='1') {
                    dfs(grid,i,j,rowCount,columnCount);
                    count++;
                }
            }
        }
        return count;

    }

    public void dfs(char[][] grid,int i, int j, int rowCount, int columnCount) {
        if(i >=rowCount || j >= columnCount
                || i<0 || j<0 || grid[i][j]=='0' ) {
            return;
        }
        grid[i][j]='0';

        dfs(grid,i-1,j,rowCount,columnCount);
        dfs(grid,i+1,j,rowCount,columnCount);
        dfs(grid,i,j-1,rowCount,columnCount);
        dfs(grid,i,j+1,rowCount,columnCount);


    }
}
