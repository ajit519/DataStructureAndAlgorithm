package com.hackerearth.dp;

public class TestAlgorithm {

    public static void main(String[] args) {
        /*int[][] grid = FileUtils.get2DGrid();
        MinimumCostPath minimumCostPath = new MinimumCostPath();
        //System.out.println(minimumCostPath.findMinCostWhenMoveLeftAndBottom(grid));

        System.out.println("With  Digonal " +  minimumCostPath.findMinCostWhenMoveLeftBottomAndDigonal(grid));*/

        FindNumberOfPath findNumberOfPath = new FindNumberOfPath(3, 3);
        System.out.println(findNumberOfPath.totalPath());

        String path = "C:\\Learning\\algorithm\\src\\main\\resources\\input1.txt";
        FindNumberOfPathWithBlockingElement findNumberOfPathWithBlockingElement =
                new FindNumberOfPathWithBlockingElement(path);

        System.out.println(findNumberOfPathWithBlockingElement.totalPathAvailable());


    }
}
