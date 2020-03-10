package com.assesment.tests;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * TASK NAME: Clusters Of Adjacent Cells (Java implementation)
 *
 * Author: Alex Antukhov
 * Contacts: alex@devsburg.com
 *
 * Given a field represented as regular two-sized array filled with values 0 or 1
 *
 *  X 0 1 2 3 4
 * Y
 * 0  1 0 0 0 0
 * 1  1 1 0 0 0
 * 2  0 0 1 0 0
 * 3  1 0 0 0 1
 * 4  1 1 1 1 1
 *
 * Let's imagine that every 1s-cell is a separated house and all 0s-cells are trees.
 * Houses who have adjacent cells on X or Y axes are clusters. The diagonal joint between them doesn't work.
 *
 * In example above [X,Y]:
 * [0,0], [1,0], [1,1] - 1st cluster on the 1st and 2nd rows
 * [2,2] - 2nd cluster which doesn't have adjacent cells on X or Y axis with value 1
 * 3rd cluster placed on rows with index 3 and 4, it contains 7 houses
 *
 * Final target: to find amount clusters within the given field
 *
 **/
 
public class ClustersOfAdjacentCells {
    /* collector of processed cells/houses */
    private static List<Pair<Integer, Integer>> tempMemo = new ArrayList<>();
    private static int clusterCounter = 0;
    private static int recursionCallCounter = 0;

    /** Fill the field */
    public static void main(String[] args) {
        List<List<Integer>> cellMatrix = new ArrayList<>();
        cellMatrix.add(Arrays.asList(1,0,0,0,0));
        cellMatrix.add(Arrays.asList(1,1,0,0,0));
        cellMatrix.add(Arrays.asList(0,0,1,0,0));
        cellMatrix.add(Arrays.asList(1,0,0,0,1));
        cellMatrix.add(Arrays.asList(1,1,1,1,1));

        System.out.println("Amount of clusters in field: " + getClusterSum(cellMatrix));
    }

    /** Main processing function */
    private static int getClusterSum(List<List<Integer>> cells) {

        for (int r=0; r<cells.size(); r++) {
            for (int c=0; c<cells.get(r).size(); c++) {
                /* for each cell/item of matrix if we didn't process it yet */
                if(cells.get(r).get(c)==1 && !tempMemo.contains(new Pair<>(r,c))) {
                    searchForAdjustments(cells, r, c, true);
                }
            }
        }

        System.out.println("Houses in all clusters: " + tempMemo);
        System.out.println("Count of recursion execution: " + recursionCallCounter);
        return clusterCounter;
    }

    /** Recursion function */
    private static void searchForAdjustments(List<List<Integer>> cells, int row, int cell, boolean mainCall) {
        recursionCallCounter++;
        if(cells.get(row).get(cell)==1 && mainCall) {
            clusterCounter++;
        }
        tempMemo.add(new Pair<>(row,cell));
        /* checking the neighbor cell: right:  */
        if(!tempMemo.contains(new Pair<>(row,cell+1)) && cell < cells.get(row).size()-1 && cells.get(row).get(cell+1) != 0) {
            searchForAdjustments(cells, row, cell+1, false);
        }
        /* checking the neighbor cell: left */
        if(!tempMemo.contains(new Pair<>(row,cell-1)) && cell > 0 && cells.get(row).get(cell-1) != 0) {
            searchForAdjustments(cells, row, cell-1, false);
        }
        /* checking the neighbor cell: below */
        if(!tempMemo.contains(new Pair<>(row+1,cell)) && row < cells.size()-1 && cells.get(row+1).get(cell) != 0) {
            searchForAdjustments(cells, row+1, cell, false);
        }
        /* checking the neighbor cell: above */
        if(!tempMemo.contains(new Pair<>(row-1,cell)) && row > 0 && cells.get(row-1).get(cell) !=0 ) {
            searchForAdjustments(cells, row-1, cell, false);
        }
    }
}
