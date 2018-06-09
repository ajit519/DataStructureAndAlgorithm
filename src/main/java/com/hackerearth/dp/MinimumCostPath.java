package com.hackerearth.dp;

/**
 * Finding Minimum-Cost Path in a 2-D Matrix
 */
public class MinimumCostPath {

    public int findMinCostWhenMoveLeftAndBottom(int[][] grid){
        int column = grid[0].length;
        int row = grid.length;

        fillFirstRow(grid);
        fillFirstColumn(grid);
        fillRemainingRow(grid);


        return grid[row-1][column-1];
    }

    public int findMinCostWhenMoveLeftBottomAndDigonal(int[][] grid){
        int column = grid[0].length;
        int row = grid.length;

        fillFirstRow(grid);
        fillFirstColumn(grid);
        fillRowWithDigonal(grid);

        return grid[row-1][column-1];

    }

    private int[][] fillFirstRow(int[][] grid){
        for(int i =1; i< grid[0].length; i++){
            grid[0][i] = grid[0][i-1] + grid[0][i];
        }
        return grid;
    }

    private int[][] fillFirstColumn(int[][] grid){
        for(int i =1; i< grid.length; i++){
            grid[i][0] = grid[i-1][0] + grid[i][0];
        }
        return grid;
    }

    private int[][] fillRemainingRow(int[][] grid){
        for (int i = 1; i < grid.length; i++){
            for (int j = 1; j < grid[0].length; j++){
                grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1]) + grid[i][j];
            }
        }
        return grid;
    }

    private int[][] fillRowWithDigonal(int[][] grid){
        for (int i=1; i < grid.length; i++ ){
            for (int j = 1; j < grid[0].length; j++){
                grid[i][j] = Math.min(Math.min(grid[i-1][j],grid[i][j-1]), grid[i-1][j-1]) + grid[i][j];
            }
        }
        return grid;
    }
}
