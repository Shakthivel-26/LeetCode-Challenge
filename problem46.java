import java.util.*;
class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = events[n - 1][2];
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], events[i][2]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, events[i][2]);
            int next = binarySearch(events, events[i][1] + 1);
            if (next < n) {
                ans = Math.max(ans, events[i][2] + suffixMax[next]);
            }
        }
        return ans;
    }
    private int binarySearch(int[][] events, int target) {
        int l = 0, r = events.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (events[mid][0] >= target) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }
}
