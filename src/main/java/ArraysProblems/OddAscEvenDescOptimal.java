package ArraysProblems;

import java.util.*;

public class OddAscEvenDescOptimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] even = new int[n];
        int[] odd = new int[n];
        int evenCount = 0, oddCount = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] % 2 == 0) {
                even[evenCount++] = arr[i];
            } else {
                odd[oddCount++] = arr[i];
            }
        }


        for (int i = 0; i < evenCount; i++) {
            for (int j = i + 1; j < evenCount; j++) {
                if (even[i] < even[j]) {
                    int temp = even[i];
                    even[i] = even[j];
                    even[j] = temp;
                }
            }
        }

        for (int i = 0; i < oddCount; i++) {
            for (int j = i + 1; j < oddCount; j++) {
                if (odd[i] > odd[j]) {
                    int temp = odd[i];
                    odd[i] = odd[j];
                    odd[j] = temp;
                }
            }
        }

        for (int i = 0; i < evenCount; i++) {
            System.out.print(even[i] + " ");
        }

        for (int i = 0; i < oddCount; i++) {
            System.out.print(odd[i] + " ");
        }
    }
}
