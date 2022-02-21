package DP;

import java.util.Arrays;
import java.util.Comparator;

class Job{
    int id,profit,deadline;
    Job(int x,int y,int z){
        this.id=x;
        this.profit=y;
        this.deadline=z;
    }
}
public class JobSequencingWithDeadline {
    int[] JobScheduling(Job arr[], int n)
    {
        int[] Result=new int[2];
        int profit=0;
        int num=0;
        int[] time=new int[n];
        Arrays.sort(arr, new  Comparator<Job>(){
            public int compare(Job a, Job b){
                return b.profit-a.profit;
            }
        });

        for(int i=0;i<n;i++){
            for(int j=Math.min(n - 1, arr[i].deadline - 1);j>=0;j--){

                if(time[j]==0){
                    time[j]=arr[i].id;
                    profit+=arr[i].profit;

                    num+=1;
                    break;
                }
            }
        }
        Result[0]=num;
        Result[1]=profit;
        return Result;

    }
}
