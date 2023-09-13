import java.util.*;
import java.lang.Math;
import java.util.Arrays;

public class bag{
    public static void main(String[] args) {
        int []weight={1,3,4};
        int []value={15,20,30};
        int bagSize=4;
        bagProblem(weight,value,bagSize);
    }
    // public static void bagProblem(int []weight,int []value,int bagSize){
    //     int [][]dp=new int[weight.length][bagSize+1];
    //     for(int j=weight[0];j<=bagSize;j++){
    //         dp[0][j]=value[0];
    //     }
    //     for(int i=1;i<weight.length;i++){
    //         for(int j=0;j<=bagSize;j++){
    //             if(j<weight[i]){
    //                 dp[i][j]=dp[i-1][j];
    //             }else{
    //                 dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
    //             }
    //         }
    //     }
    //     for(int[] arr : dp){
    //         System.out.println(Arrays.toString(arr));
    //     }
    // }
    public static void bagProblem(int []weight,int []value,int bagSize){
        int []dp=new int[bagSize+1];
        for(int i=0;i<weight.length;i++){
            for(int j=bagSize;j>=weight[i];j--){
                dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i] );
            }
        }
        for (int j = 0; j <= bagSize; j++){
            System.out.print(dp[j] + " ");
        }
    }
}