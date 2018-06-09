package com.hackerearth.dp;

/**
 * Finding the number of ways to reach from a starting position to an ending position travelling in specified directions
 * only.
 */
public class FindNumberOfPath {

    private int row;
    private int column;
    private int grid[][];

    public FindNumberOfPath(int row, int column) {
        this.row = row;
        this.column = column;
        this.grid = new int[row][column];
    }

    public int totalPath(){
        fillFirstRow();
        fillFirstColumn();
        fillRemainingRow();
        return grid[row-1][column-1];
    }

    private void fillFirstRow(){
        for (int i = 0; i < column; i++){
            grid[0][i] = 1;
        }
    }


    private void fillFirstColumn(){
        for (int j = 0; j < row; j++){
            grid[j][0] = 1;
        }
    }

    private void fillRemainingRow(){
        for (int i = 1; i < row; i++ ){
            for (int j = 1; j < column; j++ ){
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }
    }
}
