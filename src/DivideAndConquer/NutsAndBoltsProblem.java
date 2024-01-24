package DivideAndConquer;

import java.util.Arrays;

// n nuts and n bolts T O
// 1 to 1 mapping with nuts and bolts. Find out which bolt is for which nut
// quick sort --- O(n^2)
public class NutsAndBoltsProblem {

    public static void main(String[] args) {
        char[] nuts = {'!', '#', '@', '&', '*', '+'};
        char[] bolts = {'&', '*', '!', '#', '@', '+'};

        matchNutsAndBolts(nuts, bolts, 0, nuts.length - 1);
        System.out.println("Nuts : " + Arrays.toString(nuts));
        System.out.println("Bolts: " + Arrays.toString(bolts));

    }

    public static void matchNutsAndBolts(char[] nuts, char[] bolts, int start, int end) {
        if (start < end) {
            int pivot = partition(nuts, start, end, bolts[end]);
            partition(bolts, start, end, nuts[pivot]);
            matchNutsAndBolts(nuts, bolts, start, pivot - 1);
            matchNutsAndBolts(nuts, bolts, pivot + 1, end);
        }
    }

    static int partition(char[] arr, int start, int end, char pivot) {
        int i = start;

        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                swap(arr, j, i++);
            } else if (arr[j] == pivot) {
                swap(arr, j--, end);
            }
        }
        swap(arr, i, end);
        return i;


    }

    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

}
