package com.hackerearth.dp;

/**
 * Finding the number of ways to reach from a starting position to an ending position travelling in specified directions
 * only. Given  some of them are blocked.
 */

public class FindNumberOfPathWithBlockingElement {

    private String inputFilePath;
    private int[][] grid;

    public FindNumberOfPathWithBlockingElement(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public int totalPathAvailable(){
        grid = FileUtils.get2DGrid(inputFilePath);
        int column = grid[0].length;
        int row = grid.length;
        System.out.println("Row " + row + " Column " + column);
        grid[0][0] = 1;
        fillFirstRow();
        fillFirstColumn();
        fillRemainingColumn();

        return grid[row-1][column-1];
    }

    private void fillFirstRow(){
        for(int i = 1; i < grid[0].length; i++){
            if(grid[0][i-1] == -1 || grid[0][i] == -1){
                grid[0][i] = -1;
                continue;
            }
            grid[0][i] = 1;
        }
    }

    private void fillFirstColumn(){
        for(int i = 1; i < grid.length; i++){
            if(grid[i-1][0] == -1 || grid[i][0] == -1){
                grid[i][0] = -1;
                continue;
            }
            grid[i][0] = 1;
        }
    }

    private void fillRemainingColumn(){
        for(int i = 1; i < grid.length ; i++ ){
            for (int j = 1; j < grid[0].length; j++){
                if(grid[i][j] == -1){
                    continue;
                }else if (grid[i-1][j] == -1  && grid[i][j-1] == -1){
                    grid[i][j] = -1;
                }else if (grid[i-1][j] == -1  || grid[i][j-1] == -1){
                    grid[i][j] = (grid[i-1][j] + grid[i][j-1]) + 1;
                }else {
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }
            }
        }
    }

}
