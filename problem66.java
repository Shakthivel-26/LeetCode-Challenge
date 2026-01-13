class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double low = Double.MAX_VALUE, high = Double.MIN_VALUE;
        for (int[] s : squares) {
            totalArea += (double) s[2] * s[2];
            low = Math.min(low, s[1]);
            high = Math.max(high, s[1] + s[2]);
        }
        double target = totalArea / 2.0;
        for (int i = 0; i < 60; i++) { 
            double mid = (low + high) / 2.0;
            double areaBelow = areaBelowLine(squares, mid);
            if (areaBelow < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }
    private double areaBelowLine(int[][] squares, double yLine) {
        double area = 0;
        for (int[] s : squares) {
            double y = s[1];
            double l = s[2];
            if (yLine >= y + l) {
                area += l * l;
            } else if (yLine > y) {
                area += (yLine - y) * l;
            }
        }
        return area;
    }
}
