package MrSt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumEventsValue {
    public static int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]); // Sort events based on end day

        int n = events.length;
        int[] dp = new int[n];
        if(events.length > k){
            int[][] array = events;
            int min = array[0][2];
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 1; i < array.length; i++) {
                if (array[i][2] < min) {
                    min = array[i][2];
                }
            }
            System.out.println("Min value in array "+min);
            for (int[] row : events) {
                if(row[2] == min){
                    continue;
                }
                List<Integer> rowList = new ArrayList<>();
                for (int value : row) {
                    rowList.add(value);
                }
                result.add(rowList);
            }
            int rows = result.size();
            int cols = result.get(0).size();
            int[][] finalArray = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                List<Integer> rowList = result.get(i);
                for (int j = 0; j < cols; j++) {
                    finalArray[i][j] = rowList.get(j);
                }
            }
            System.out.println("Final ArrayList "+result);
            System.out.println("Final Array " + Arrays.deepToString(finalArray));
            events= finalArray;
        }
        for (int i = 0; i < events.length; i++) {
            dp[i] = events[i][2]; // Initialize dp array with event values
            for (int j = i - 1; j >= 0; j--) {
                if (events[j][1] < events[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + events[i][2]);
                    break; // Break because we can only attend one event at a time
                }
            }
        }

        int maxSum = 0;
        for (int value : dp) {
            maxSum = Math.max(maxSum, value);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[][] events = {{1, 2, 4}, {3, 4, 3}, {2, 3, 1}};
        int k = 2;

        System.out.println(maxValue(events, k));

        events = new int[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4}};
        System.out.println("Output: " +maxValue(events,3));

        events = new int[][]{{1, 2, 4},{4,4,4}, {3, 4, 3}, {2, 3, 10}};
        System.out.println("Output: " +maxValue(events,2));
    }
}
