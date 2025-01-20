import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M;
    static boolean[][] visited;
    static int[][] landId;
    static Map<Integer, Integer> oilSizes;

    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        visited = new boolean[N][M];
        landId = new int[N][M];
        oilSizes = new HashMap<>();
        int islandId = 1;

        // 모든 석유 덩어리를 탐색하여 크기 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    int size = calculateOilSize(i, j, land, islandId);
                    oilSizes.put(islandId, size);
                    islandId++;
                }
            }
        }

        // 열 단위로 석유량 계산
        int maxOil = 0;
        for (int j = 0; j < M; j++) {
            Set<Integer> uniqueIslands = new HashSet<>();
            int totalOil = 0;

            for (int i = 0; i < N; i++) {
                if (land[i][j] == 1) {
                    int id = landId[i][j];
                    if (!uniqueIslands.contains(id)) {
                        uniqueIslands.add(id);
                        totalOil += oilSizes.get(id);
                    }
                }
            }
            maxOil = Math.max(maxOil, totalOil);
        }

        return maxOil;
    }

    private int calculateOilSize(int x, int y, int[][] land, int islandId) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        landId[x][y] = islandId;

        int size = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            size++;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && land[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    landId[nx][ny] = islandId;
                    queue.add(new int[] {nx, ny});
                }
            }
        }

        return size;
    }
}