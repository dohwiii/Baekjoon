import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M;

    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;

        int[][] landId = new int[N][M]; // 각 칸의 석유 덩어리 ID
        int[] oilSizes = new int[N * M + 1]; // 각 석유 덩어리의 크기
        int islandId = 1; // 석유 덩어리 ID 시작값

        // 1. 석유 덩어리 크기 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (land[i][j] == 1 && landId[i][j] == 0) {
                    oilSizes[islandId] = calculateOilSize(i, j, land, landId, islandId);
                    islandId++;
                }
            }
        }

        // 2. 열 단위로 최대 석유량 계산
        int maxOil = 0;
        for (int j = 0; j < M; j++) {
            Set<Integer> uniqueIslands = new HashSet<>();
            int totalOil = 0;

            for (int i = 0; i < N; i++) {
                int id = landId[i][j];
                if (id > 0 && uniqueIslands.add(id)) {
                    totalOil += oilSizes[id];
                }
            }
            maxOil = Math.max(maxOil, totalOil);
        }

        return maxOil;
    }

    private int calculateOilSize(int x, int y, int[][] land, int[][] landId, int islandId) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {x, y});
        landId[x][y] = islandId;

        int size = 0;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int cx = current[0];
            int cy = current[1];
            size++;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && land[nx][ny] == 1 && landId[nx][ny] == 0) {
                    landId[nx][ny] = islandId;
                    stack.push(new int[] {nx, ny});
                }
            }
        }

        return size;
    }
}