package Code;

import java.io.*;
import java.util.*;

public class FindMaxSubMatrixOfASortedRowColumn {

    public static void main(String[] args) {

    }
    //in the max sub array it is bound that the last element in the matrix will be there as it is sorted in row wise and column wise
    public static int findMaxSubMatrixOfASortedRowColumn(int[][] mat) {
        int[][] prefixSum = constructPrefixSumArray(mat);
        int maxSubArraySum = Integer.MIN_VALUE;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int subArraySum = findSubArraySum(i, j, mat.length - 1, mat[0].length - 1, prefixSum);
                maxSubArraySum = Math.max(maxSubArraySum, subArraySum);
            }
        }
        return maxSubArraySum;
    }

    // prefix sum(tl , br) = prefixsum(a2 , b2) - prefixSum(a1-1 , b2) -
    // prefixSum(a2,b1-1) + prefixSum(a1-1,b1-1)
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
