import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//DFS
public class Main {
	static int N;
	static int[][] map;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}

		ans = 1;
		for (int m = max - 1; m >= min; m--) {
			ans = Math.max(ans, dfs(0, m));
		}

		System.out.println(ans);
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int dfs(int idx, int m) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > m) {
					map[i][j] = m;
					setMap(i, j, m);
					idx++;
				}
			}
		}
		return idx;
	}

	static void setMap(int r, int c, int m) {
		for (int k = 0; k < 4; k++) {
			int nx = r + dx[k];
			int ny = c + dy[k];
			if (nx >= N || ny >= N || nx < 0 || ny < 0)
				continue;
			if (map[nx][ny] > m) {
				map[nx][ny] = m;
				setMap(nx, ny, m);
			}
		}
	}
}
