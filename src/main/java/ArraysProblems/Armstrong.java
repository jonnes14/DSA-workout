package ArraysProblems;

import java.util.*;

public class Armstrong{
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String input=s.substring(1,s.length()-1);
        String []part=input.split(",");
        int arr[]=new int [part.length];
        for(int i=0;i<part.length;i++){
            arr[i]=Integer.parseInt(part[i].trim());
        }
        for(int i=0;i<arr.length;i++){
            int num=arr[i];
            int sum=0;
            int orginal=num;
            while(num>0){
                int last=num%10;
                int pow=last*last*last;
                sum+=pow;
                num=num/10;
            }
            if(orginal==sum){
                System.out.println(orginal);
            }
        }

    }
}
