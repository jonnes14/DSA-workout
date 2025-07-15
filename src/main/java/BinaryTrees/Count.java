import java.util.*;

class Count{

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("");
        int n=s.nextInt();
        int  arr[]=new int[n];

        System.out.println("");
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }

        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }
            else{
                map.put(arr[i],1);
            }
        }
        for(Map.Entry<Integer,Integer>i: map.entrySet()){
            System.out.println(i.getKey()+" "+i.getValue());
        }

    }
}