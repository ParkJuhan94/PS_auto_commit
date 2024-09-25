class Solution {
    public int solution(int k, int[][] dungeons) {
        int len = dungeons.length;
        boolean[] visited = new boolean[len];
        return dfs(k, dungeons, visited, 0);
    }

    public int dfs(int hp, int[][] dungeons, boolean[] visited, int count) {
        int maxDungeons = count;

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && hp >= dungeons[i][0]) {
                visited[i] = true;
                maxDungeons = Math.max(maxDungeons, dfs(hp - dungeons[i][1], dungeons, visited, count + 1));
                visited[i] = false;
            }
        }

        return maxDungeons;
    }
}