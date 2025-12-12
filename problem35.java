class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        List<List<String>> ev = new ArrayList<>(events);
        ev.sort((a, b) -> {
            int ta = Integer.parseInt(a.get(1));
            int tb = Integer.parseInt(b.get(1));
            if (ta != tb) return Integer.compare(ta, tb);
            String taType = a.get(0);
            String tbType = b.get(0);
            if (taType.equals(tbType)) return 0;
            if (taType.equals("OFFLINE")) return -1;
            return 1;
        });
        boolean[] online = new boolean[numberOfUsers];
        int[] backOnlineAt = new int[numberOfUsers];
        int[] mentions = new int[numberOfUsers];
        Arrays.fill(online, true);
        for (List<String> event : ev) {
            String type = event.get(0);
            int timestamp = Integer.parseInt(event.get(1));
            String data = event.get(2);
            for (int u = 0; u < numberOfUsers; u++) {
                if (!online[u] && backOnlineAt[u] <= timestamp) {
                    online[u] = true;
                }
            }
            if (type.equals("OFFLINE")) {
                int id = Integer.parseInt(data);
                online[id] = false;
                backOnlineAt[id] = timestamp + 60;
            } else { 
                if (data.equals("ALL")) {
                    for (int u = 0; u < numberOfUsers; u++) mentions[u]++;
                } else if (data.equals("HERE")) {
                    for (int u = 0; u < numberOfUsers; u++) if (online[u]) mentions[u]++;
                } else {
                    String[] tokens = data.split(" ");
                    for (String token : tokens) {
                        if (token.startsWith("id")) {
                            int id = Integer.parseInt(token.substring(2));
                            mentions[id]++;
                        }
                    }
                }
            }
        }
        return mentions;
    }
}
