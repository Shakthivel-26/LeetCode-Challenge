import java.util.*;
class Solution {
    static class YEvent {
        double y;
        int type;
        double x1, x2;
        YEvent(double y, int type, double x1, double x2) {
            this.y = y;
            this.type = type;
            this.x1 = x1;
            this.x2 = x2;
        }
    }
    public double separateSquares(int[][] squares) {
        List<YEvent> events = new ArrayList<>();
        for (int[] s : squares) {
            double x1 = s[0];
            double x2 = s[0] + s[2];
            double y1 = s[1];
            double y2 = s[1] + s[2];
            events.add(new YEvent(y1, 1, x1, x2));
            events.add(new YEvent(y2, -1, x1, x2));
        }
        events.sort(Comparator.comparingDouble(e -> e.y));
        TreeMap<Double, Integer> xMap = new TreeMap<>();
        double prevY = events.get(0).y;
        double totalArea = 0;
        for (YEvent e : events) {
            double curY = e.y;
            double height = curY - prevY;
            if (height > 0 && !xMap.isEmpty()) {
                totalArea += height * coveredX(xMap);
            }
            xMap.put(e.x1, xMap.getOrDefault(e.x1, 0) + e.type);
            xMap.put(e.x2, xMap.getOrDefault(e.x2, 0) - e.type);
            if (xMap.get(e.x1) == 0) xMap.remove(e.x1);
            if (xMap.get(e.x2) == 0) xMap.remove(e.x2);
            prevY = curY;
        }
        double half = totalArea / 2.0;
        xMap.clear();
        prevY = events.get(0).y;
        double areaSoFar = 0;
        for (YEvent e : events) {
            double curY = e.y;
            double height = curY - prevY;
            if (height > 0 && !xMap.isEmpty()) {
                double stripArea = height * coveredX(xMap);
                if (areaSoFar + stripArea >= half) {
                    return prevY + (half - areaSoFar) / coveredX(xMap);
                }
                areaSoFar += stripArea;
            }
            xMap.put(e.x1, xMap.getOrDefault(e.x1, 0) + e.type);
            xMap.put(e.x2, xMap.getOrDefault(e.x2, 0) - e.type);
            if (xMap.get(e.x1) == 0) xMap.remove(e.x1);
            if (xMap.get(e.x2) == 0) xMap.remove(e.x2);
            prevY = curY;
        }
        return prevY;
    }
    private double coveredX(TreeMap<Double, Integer> map) {
        double total = 0;
        int count = 0;
        double prev = 0;
        for (Map.Entry<Double, Integer> e : map.entrySet()) {
            if (count > 0) {
                total += e.getKey() - prev;
            }
            count += e.getValue();
            prev = e.getKey();
        }
        return total;
    }
}
