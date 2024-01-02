package DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

/*
Given a sorted array A of size n, find an element that occurs more than n/2 times.
Binary Search
*/
public class MajorityElementBS {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2, 2, 3, 3, 4};
        int[] arr1 = {2, 2, 2, 2, 2, 3, 3, 4};
        List<Object> list = new ArrayList<>();
        list.add(arr1);
        list.add(arr);
        list.add(new int[]{});
        list.forEach(x -> {
            findMajorityElementBS((int[]) x);
            isMajority((int[]) x);
        });
    }

    /*
     * Binary Search
     * first occurrence and last occurrence -- if majority then always present in mid in this case
     * number of occurrence ????
     * */
    static void findMajorityElementBS(int[] arr) {
        // {1, 2, 2, 2, |2|, 2, 3, 3, 4};

        // mid + 1 mid -1
        int mid = arr.length / 2;
        int left = 0;
        int right = arr.length - 1;
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[mid] != arr[left]) {
                left++;
            }
            if (arr[mid] != arr[right]) {
                right--;
            }
        }
        if (right - left + 1 > mid) {
            System.out.println("Majority element found " + arr[mid]);
        }
    }

    // we are testing a window, checking first element and last element;
    static int isMajority(int[] arr) {
        int size = arr.length;
        if (size == 0)
            return 0;
        int lastIndex = size % 2 == 0 ? (size / 2) - 1 : size / 2;
        int x = arr[lastIndex];
        for (int index = 0; index <= lastIndex; index++) {
            if (arr[index] == x && arr[index] == arr[index + size / 2]) {
                System.out.println(arr[index]);
                return 1;
            }
        }
        return 0;
    }
}
