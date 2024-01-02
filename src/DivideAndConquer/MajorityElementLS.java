package DivideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a sorted array A of size n, find an element that occurs more than n/2 times.
Linear Search
*/
public class MajorityElementLS {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2, 2, 3, 3, 4};
        int[] arr1 = {1, 2, 2, 2, 2, 3, 3, 4};
        List<Object> list = new ArrayList<>();
        list.add(arr1);
        list.add(arr);
        list.add(new int[] {});
        list.forEach(x->{
            findMajorityElement((int[]) x);
            findMajorityElementByIndex((int[]) x);
        });

    }
// arr[i] == arr[i+n/2]
// Time complexity = O(n/2) == O(n)
// Space complexity = O(1)
    static void findMajorityElementByIndex(int[] arr) {
        boolean found = false;
        System.out.println(Arrays.toString(arr));
        for(int i =0 ;i<arr.length/2; i++){
            if(arr[i] == arr[i+ (arr.length/2)]){
                found = true;
                System.out.println("Majority element: "+ arr[i]);
                break;
            }
        }
        if(!found){
            System.out.println("No majority element found in the given sorted array");
        }
    }
// common approach -- counting the current element
    static void findMajorityElement(int[] arr){
        System.out.println(Arrays.toString(arr));
        int length = arr.length;
        int count = 0;
        boolean found = false;
        // Linear search approach
        for (int i = 0; i < length-1; i++) {
            if (arr[i] == arr[i + 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count > arr.length / 2) {
                found = true;
                System.out.println("Majority Element: " + arr[i] + " count:" + count);
            }
        }
        if(!found){
            System.out.println("No majority element found in the given sorted array");
        }
    }
}