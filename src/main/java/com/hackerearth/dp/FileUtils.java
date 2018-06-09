package com.hackerearth.dp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {

    private static String path = "C:\\Learning\\algorithm\\src\\main\\resources\\input.txt";

    public static int[][] get2DGrid() {
        int row = -1;
        int[][] grid = null;
        String input = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while ((input = reader.readLine()) != null) {
                if (row == -1) {
                    grid = createArray(input);
                } else {
                    fillGrid(grid, row, input);
                }
                row++;
            }
        } catch (IOException e) {
            System.out.println("e = " + e);
        }
        return grid;
    }

    public static int[][] get2DGrid(String path){
        int row = -1;
        int[][] grid = null;
        String input;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while ((input = reader.readLine()) != null) {
                if (row == -1) {
                    grid = createArray(input);
                } else {
                    fillGrid(grid, row, input);
                }
                row++;
            }
        } catch (IOException e) {
            System.out.println("e = " + e);
        }
        return grid;
    }

    private static int[][] createArray(String input) {
        String[] rowsAndColumn = input.split(" ");
        return new int[Integer.parseInt(rowsAndColumn[0])][Integer.parseInt(rowsAndColumn[1])];

    }

    private static int[][] fillGrid(int[][] grid, int row, String input) {
        String[] values = input.split(" ");
        for (int i = 0; i < values.length; i++) {
            grid[row][i] = Integer.parseInt(values[i]);
        }
        return grid;

    }
}
