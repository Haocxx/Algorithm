package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class P51 {
    public static void main(String[] args) {
        new P51().solveNQueens(4);
    }

    public List<List<String>> solveNQueens(int n) {
        int[][] map = new int[n][n];
        List<List<String>> result = new ArrayList<>();
        dfs(map, n, result, 0, 0, new Queue[n]);
        return result;
    }

    private void dfs(int[][] map, int n, List<List<String>> result, int curNum, int position, Queue[] queues) {
        if (curNum == n) {
            addResult(map, n, result);
            return;
        }
        if (position == n * n) {
            return;
        }
        int x = position / n;
        int y = position % n;
        boolean invalid = false;
        for (int i = 0; i < curNum; i++) {
            if (queues[i].x == x || queues[i].y == y || queues[i].xy == x + y || queues[i].x_y == x - y) {
                invalid = true;
                break;
            }
        }
        if (!invalid) {
            map[x][y] = 1;
            queues[curNum] = new Queue(x, y);
            dfs(map, n, result, ++curNum, ++position, queues);
            map[x][y] = 0;
            curNum--;
            position--;
            queues[curNum] = null;
        }

        dfs(map, n, result, curNum, ++position, queues);
    }

    public static class Queue {
        public Queue(int x, int y) {
            this.x = x;
            this.y = y;
            this.xy = x + y;
            this.x_y = x - y;
        }
        public int x;
        public int y;
        public int xy;
        public int x_y;
    }

    private void addResult(int[][] map, int n, List<List<String>> result) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0;j < n; j++) {
                if (map[i][j] > 0) {
                    stringBuilder.append("Q");
                } else {
                    stringBuilder.append(".");
                }
            }
            list.add(stringBuilder.toString());
        }
        result.add(list);
    }
}
