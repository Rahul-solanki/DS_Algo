package SortingAlgo;


import java.util.Arrays;

// Quicksort is a divide and Conquer algorithm.
// It works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays.
// Avg time complexity - O(nlogn)
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {19, 16, 13, 12, 11, 15, 14, 31, 18};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array");
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int i, int j) {
//        arr[i] = arr[i] + arr[j];  // a = a+b
//        arr[j] = arr[i] - arr[j];  // b = a-b
//        arr[i] = arr[i] - arr[j];  // a = a-b

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }


    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

}
