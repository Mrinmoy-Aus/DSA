package Code;

import java.io.*;
import java.util.*;

public class FindSubArraySumForQQueries {
    // finding sub arrray sum for given q queries
    public static void main(String[] args) {

    }
    public static void calculateSubArraySumOfQQueries(List<List<Integer>> queries , int[][] mat){
        int[][] prefixSum = constructPrefixSumArray(mat);
        for(List<Integer> co : queries){
            int a1 = co.get(0);
            int b1 = co.get(1);
            int a2 = co.get(2);
            int b2 = co.get(3);
            System.out.println(findSubArraySum(a1, b1, a2, b2, prefixSum));
        }
    }
    //prefix sum(tl , br) =  prefixsum(a2 , b2) - prefixSum(a1-1 , b2) - prefixSum(a2,b1-1) + prefixSum(a1-1,b1-1)
    public static int findSubArraySum(int a1, int b1, int a2, int b2, int[][] prefixSum) {
        int sum = prefixSum[a2][b2];
        if (a1 > 0) {
            sum -= prefixSum[a1 - 1][b2];
        }
        if (b1 > 0) {
            sum -= prefixSum[a2][b1 - 1];
        }
        if (a1 > 0 && b1 > 0) {
            sum -= prefixSum[a1 - 1][b1 - 1];
        }
        return sum;
    }

    public static int[][] constructPrefixSumArray(int[][] mat) {
        int[][] prefixSumArr = new int[mat.length][mat[0].length];
        // row wise prefix sum
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                prefixSumArr[i][j] = (j > 0) ? prefixSumArr[i][j - 1] + mat[i][j] : mat[i][j];

            }
        }
        // column wise prefix sum
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                prefixSumArr[j][i] = (j > 0) ? prefixSumArr[j - 1][i] + mat[i][j] : mat[i][j];

            }
        }
        return prefixSumArr;
    }
}