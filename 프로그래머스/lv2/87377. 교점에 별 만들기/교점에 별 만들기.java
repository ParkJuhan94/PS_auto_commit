import java.util.*;

class Solution {

    private static class Point {

        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    List<Point> pointOfIntersection = new ArrayList<>();
    Long minX = Long.MAX_VALUE;
    Long minY = Long.MAX_VALUE;
    Long maxX = Long.MIN_VALUE;
    Long maxY = Long.MIN_VALUE;


    public String[] solution(int[][] line) {
        String[] answer = {};

        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                getPointOfIntersection(line[i], line[j]);
            }
        }

        getMinPointAndMaxPoint();

        long height = maxY - minY + 1;
        long width = maxX - minX + 1;

        answer = new String[(int) height];
        boolean[][] board = new boolean[(int) height][(int) width];

        for (Point point : pointOfIntersection) {
            int x = (int) (point.x - minX);
            int y = (int) (maxY - point.y);

            board[y][x] = true;
        }
        int i = 0;
        for (boolean[] booleans : board) {
            StringBuilder sb = new StringBuilder();
            for (boolean b : booleans) {
                if (b) {
                    sb.append("*");
                } else {
                    sb.append(".");
                }
            }
            answer[i++] = sb.toString();
        }

        return answer;
    }

    private void getMinPointAndMaxPoint() {
        for (Point point : pointOfIntersection) {
            minX = Math.min(minX, point.x);
            minY = Math.min(minY, point.y);
            maxX = Math.max(maxX, point.x);
            maxY = Math.max(maxY, point.y);
        }
    }

    private void getPointOfIntersection(int[] A, int[] B) {
        long a = A[0];
        long b = A[1];
        long c = B[0];
        long d = B[1];
        long e = A[2];
        long f = B[2];

        long denominator = a * d - b * c;
        if (denominator == 0) {
            return;
        }

        long xNumerator = b * f - e * d;
        long yNumerator = e * c - a * f;

        if (xNumerator % denominator != 0 || yNumerator % denominator != 0) {
            return;
        }

        long x = xNumerator / denominator;
        long y = yNumerator / denominator;

        pointOfIntersection.add(new Point(x, y));
    }
}