import java.util.*;

class Solution {
    static int N, M;
    static int[] dp;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Map<Integer, Integer> islandSizes; // 섬 크기 캐싱
    static int islandId; // 섬 ID
    static int[][] landId; // 각 셀의 섬 ID 기록
    
    public int solution(int[][] land) {
        int answer = 0;
        N = land.length;
        M = land[0].length;
        dp = new int[M];
        visited = new boolean[N][M];
        landId = new int[N][M];
        islandSizes = new HashMap<>();
        islandId = 1;
        
        // 섬 크기 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int size = calculateIslandSize(i, j, land);
                    islandSizes.put(islandId++, size);
                }
            }
        }
        
        // 열 단위 석유 크기 누적
        for (int j = 0; j < M; j++) {
            Set<Integer> uniqueIslands = new HashSet<>();
            for (int i = 0; i < N; i++) {
                if (land[i][j] == 1) {
                    uniqueIslands.add(landId[i][j]); // 해당 열에서 섬 ID 추가
                }
            }
            for (int id : uniqueIslands) {
                dp[j] += islandSizes.get(id); // 해당 섬 크기 누적
            }
        }
        
        // 최대값 계산
        answer = Arrays.stream(dp).max().getAsInt();
        return answer;
    }
    
    private int calculateIslandSize(int x, int y, int[][] land) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        landId[x][y] = islandId;
        
        int size = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            size++;
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                
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