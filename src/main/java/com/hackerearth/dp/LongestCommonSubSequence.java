package com.hackerearth.dp;

public class LongestCommonSubSequence {

    public static void main(String[] args) {
        String source = args[0];
        String target = args[1];

        int[][] grid = new int[source.length()+1][target.length()+1];
        for (int i = 0; i <= target.length(); i++) {
            grid[0][i] = 0;
        }

        for (int j = 1; j <= source.length(); j++) {
            grid[j][0] = 0;
        }

        for (int i = 1; i <= source.length(); i++) {
            char s_i = source.charAt(i-1);
            for (int j = 1; j <= target.length(); j++) {
                char t_j = target.charAt(j-1);
                if(s_i != t_j){
                    grid[i][j] = Math.max(grid[i-1][j], grid[i][j-1]);
                }else {
                    grid[i][j] = grid[i-1][j-1] + 1;
                }
            }
        }

        System.out.println(grid[source.length()][target.length()]);
    }
}
