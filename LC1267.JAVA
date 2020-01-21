//Problem Statement 
//https://leetcode.com/problems/count-servers-that-communicate/ 

class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] marked = new boolean[m][n];
        
        int result = 0;
        
        for(int i=0; i<m; i++){
            int count = 0;
            int idx = 0;
            for(int j = 0; j<n; j++){
                if(grid[i][j]==1){
                    idx = j;
                    count++;
                    marked[i][j]=true;
                }
            }
            if(count>1) result = result + count;
            else marked[i][idx] = false;
        }
        
        for(int j=0; j<n; j++){
            int count_sub = 0;
            int count = 0;
            for(int i = 0; i<m; i++){
                if(grid[i][j]==1) count++;
                if(marked[i][j]) count_sub++;
            }
            if(count>1) result = result + count - count_sub;
        }
        
        return result;
        
    }
}
