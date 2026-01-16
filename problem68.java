import java.util.*;
class Solution {
    static final long MOD = 1_000_000_007L;
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int[] H = new int[hFences.length + 2];
        int[] V = new int[vFences.length + 2];
        H[0] = 1;
        H[H.length - 1] = m;
        for (int i = 0; i < hFences.length; i++) {
            H[i + 1] = hFences[i];
        }
        V[0] = 1;
        V[V.length - 1] = n;
        for (int i = 0; i < vFences.length; i++) {
            V[i + 1] = vFences[i];
        }
        Arrays.sort(H);
        Arrays.sort(V);
        Set<Long> horizontalDiffs = new HashSet<>();
        for (int i = 0; i < H.length; i++) {
            for (int j = i + 1; j < H.length; j++) {
                horizontalDiffs.add((long) H[j] - H[i]);
            }
        }
        long maxSide = -1;
        for (int i = 0; i < V.length; i++) {
            for (int j = i + 1; j < V.length; j++) {
                long diff = (long) V[j] - V[i];
                if (horizontalDiffs.contains(diff)) {
                    maxSide = Math.max(maxSide, diff);
                }
            }
        }
        if (maxSide == -1) return -1;
        return (int) ((maxSide * maxSide) % MOD);
    }
}
