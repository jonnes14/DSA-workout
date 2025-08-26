package ArraysProblems.SlidingWindow;


class Subarray{
    public int seperate(int arr[], int k){
        int windowsize=0;
        for(int i=0;i<k;i++){
           windowsize+=arr[i];
        }
       int maxwindowsize=windowsize;
        for(int i=k;i<arr.length;i++){
            windowsize+=arr[i]-arr[i-k];
            maxwindowsize=Math.max(maxwindowsize,windowsize);
        }
        return maxwindowsize;
    }
}
public class MaximumSubarray {
    public static void main(String [] args){
    Subarray a=new Subarray();
    int arr[]={2,1,5,1,3,2};
    int size=3;
    int result=a.seperate(arr,size);
    System.out.println(result);

}}
