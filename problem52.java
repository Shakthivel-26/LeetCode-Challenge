import java.util.*;

class Solution {
    Map<String, List<Character>> map = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String s : allowed) {
            String key = s.substring(0, 2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s.charAt(2));
        }
        return dfs(bottom);
    }

    private boolean dfs(String bottom) {
        if (bottom.length() == 1) return true;

        List<String> nextLevels = new ArrayList<>();
        buildNext(bottom, 0, new StringBuilder(), nextLevels);

        for (String next : nextLevels) {
            if (dfs(next)) return true;
        }
        return false;
    }

    private void buildNext(String bottom, int index, StringBuilder sb, List<String> result) {
        if (index == bottom.length() - 1) {
            result.add(sb.toString());
            return;
        }

        String key = bottom.substring(index, index + 2);
        if (!map.containsKey(key)) return;

        for (char c : map.get(key)) {
            sb.append(c);
            buildNext(bottom, index + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
