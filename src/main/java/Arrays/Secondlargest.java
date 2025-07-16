package Arrays;

import java.util.*;

class Secondlargest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        String[] arr = a.split(",");

        int max = Integer.parseInt(arr[0].trim());
        int second = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            int num = Integer.parseInt(arr[i].trim());

            if (num > max) {
                second = max;
                max = num;
            } else if (num < max && num > second) {
                second = num;
            }
        }

        System.out.println(second);
    }
}

