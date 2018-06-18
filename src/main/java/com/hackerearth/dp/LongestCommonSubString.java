package com.hackerearth.dp;

public class LongestCommonSubString {

    public static void main(String[] args) {
        String source = args[0];
        String target = args[1];

        int[][] grid = new int[source.length() + 1][target.length() + 1];
        grid = fillTable(grid, source, target);
        String output = findLongestCommonSubString(grid, source, target);
        System.out.println(output);
    }

    private static int[][] fillTable(int[][] grid, String source, String target) {
        for (int i = 0; i <= target.length(); i++) {
            grid[0][i] = 0;
        }
        for (int j = 0; j <= source.length(); j++) {
            grid[j][0] = 0;
        }

        for (int i = 1; i <= source.length(); i++) {
            for (int j = 1; j <= target.length(); j++) {
                if (source.charAt(i - 1) == target.charAt(j - 1)) {
                    grid[i][j] = grid[i - 1][j - 1];
                }
            }
        }
        return grid;
    }

    private static String findLongestCommonSubString(int[][] grid, String source, String target) {
        int max = 0;
        int m = 0, n = 0;
        for (int i = 1; i <= source.length(); i++) {
            for (int j = 1; j <= target.length(); j++) {
                if (max < grid[i][j]) {
                    max = grid[i][j];
                    m = i;
                    n = j;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (m != 1 || n != 1) {
            sb.append(source.charAt(m-1));
            m--;
            n--;
        }
        return sb.reverse().toString();

    }
}
