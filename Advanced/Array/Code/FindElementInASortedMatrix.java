package Code;
import java.io.*;
import java.util.*;

public class FindElementInASortedMatrix {
    
    public static void main(String[] args){

    } 
    
    public static boolean findElement(int[][] mat , int k){
        int i = 0 , j = mat[0].length-1;
        while(i>=0 && i<mat.length && j>=0 && j<mat[0].length){
            if(k==mat[i][j]){
                return true;
            }else if(k>mat[i][j]){
                i++;//go down
            }else{
                j--;//go left
            }
        }
        return false;
    }
}
