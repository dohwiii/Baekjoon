class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int area = 0;
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && picture[i][j] != 0) {
                    numberOfArea++;
                    area = 0;
                    solve(i, j, m, n, picture[i][j], picture);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area);
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public void solve(int x, int y, int m, int n, int number, int[][] picture) {
        if(visited[x][y]) {
            return;
        }
        area++;
        visited[x][y] = true;
        
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >=m || ny < 0 || ny >= n || visited[nx][ny] || picture[nx][ny] != number) {
                continue;
            }
            solve(nx, ny, m, n, number, picture);
        }
    }
}