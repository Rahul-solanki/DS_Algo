package MrSt;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 Q 1
You are given an array of events where events[i] = [startDayi, endDayi, valuei]. The ith event starts at startDayi and ends at endDayi, and if you attend this event, you will receive a value of valuei. You are also given an integer k which represents the maximum number of events you can attend.
You can only attend one event at a time. If you choose to attend an event, you must attend the entire event. Note that the end day is inclusive: that is, you cannot attend two events where one of them starts and the other ends on the same day.
Return the maximum sum of values that you can receive by attending events.

Input: events = [[1,2,4],[3,4,3],[2,3,1]], k = 2
Output: 7
Explanation: Choose the green events, 0 and 1 (0-indexed) for a total value of 4 + 3 = 7.

Input: events = [[1,2,4],[3,4,3],[2,3,10]], k = 2
Output: 10
Explanation: Choose event 2 for a total value of 10.
Notice that you cannot attend any other event as they overlap, and that you do not have to attend k events.

Input: events = [[1,1,1],[2,2,2],[3,3,3],[4,4,4]], k = 3
Output: 9

Explanation: Although the events do not overlap, you can only attend 3 events. Pick the highest valued three.
* */
public class EventValueBadApproach {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 4}, {3, 4, 3}, {2, 3, 1}};
        System.out.println(maxSumOfValues(arr, 2));

        int[][] arr2 = {{1, 2, 4}, {3, 4, 3}, {2, 3, 10}};
        System.out.println(maxSumOfValues(arr2, 2));

        int[][] arr3 = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4}};
        System.out.println(maxSumOfValues(arr3, 3));

    }

    static int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        // DP approach
        return 0;
    }

    static int maxSumOfValues(int[][] arr, int n) {
        int max = 0;
        for (int[] ints : arr) {
            if (max < ints[2]) {
                max = ints[2];
            }
        }
        if (n == 1) {
            return max;
        }
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                int startDayi = arr[i][0];
                int endDayi = arr[i][1];
                int startDay2 = arr[j][0];
                int endDay2 = arr[j][1];
                List<Integer> list = List.of(startDayi, endDayi, startDay2, endDay2);
                Set<Integer> set = new HashSet<>(list);
                if (set.size() == list.size()) {
                    int sum = (arr[i][2] + arr[j][2]);
                    if (max < sum) {
                        max = sum;
                    }
                }
            }
        }
        if (n == 2) {
            return max;
        }
        for (int i = 0; i <= arr.length - 3; i++) {
            for (int j = i + 1; j <= arr.length - 2; j++) {
                for (int k = j + 1; k <= arr.length - 1; k++) {
                    System.out.println("Length of array " + arr.length);
                    System.out.println(i + " " + j + " " + k);
                    int startDayi = arr[i][0];
                    int endDayi = arr[i][1];
                    int startDay2 = arr[j][0];
                    int endDay2 = arr[j][1];
                    int startDay3 = arr[k][0];
                    int endDay3 = arr[k][1];

                    List<Integer> list = new java.util.ArrayList<>(List.of(startDayi, endDayi, startDay2, endDay2, startDay3, endDay3));
                    if (startDayi == endDayi) {
                        list.remove(Integer.valueOf(startDayi));
                    }
                    if (startDay2 == endDay2) {
                        list.remove(Integer.valueOf(startDay2));
                    }
                    if (startDay3 == endDay3) {
                        list.remove(Integer.valueOf(startDay3));
                    }
                    System.out.println("List" + list);
                    Set<Integer> set = new HashSet<>(list);
                    System.out.println(list + "\n" + set);
                    if (set.size() == list.size()) {
                        int sum = (arr[i][2] + arr[j][2] + arr[k][2]);
                        System.out.println("sum : " + sum);
                        if (max < sum) {
                            max = sum;
                        }
                    }
                }
            }
        }
        return max;
    }
}
