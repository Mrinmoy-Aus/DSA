package Code;

import java.io.*;
import java.util.*;

public class findSumOfAllSubarryInAGivenMatrix {
    public static void main(String[] args) {

    }

    // the brute force approach is to go to every point of the matrix and take that
    // as a top left corner of the matrix
    // and find the bottom right corner which will range from (tl,tr) -> (n,m) and
    // find the sum of every sub matrix and add them
    // time complexity is o(n^2Xm^2)

    // optimized approach
    // calcualte the cntribution of each point in all the possible submatrix
    // basically it will be sum of matrixes in which that point will
    // be in top left region + the point will be in the bottom right region

    public static int calculateSumOfAllSubmatrix(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                sum += (i + 1) * (j + 1) * (mat.length - i) * (mat[0].length - j);
            }
        }
        return sum;
    }
}
