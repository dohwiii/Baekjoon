/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++)
        {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            char[][] board = new char[N][M];
            int[] start = new int[2];
            for (int j = 0; j < N; j++)
            {
                String str = br.readLine();
                for (int k = 0; k < M; k++)
                {
                    board[j][k] = str.charAt(k);
                }
            }
            if (dfs(N, M, board))
            {
                System.out.println("#" + (i + 1) + " " + "possible");
            }
            else
                System.out.println("#" + (i + 1) + " " + "impossible");
        }
    }
    public static boolean dfs(int N, int M, char[][] board)
    {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        for (int j = 0; j < N; j++)
        {
            for (int k = 0; k < M; k++)
            {
                if (board[j][k] != '?')
                {
                    queue.add(new int[]{j, k});
                    visited[j][k] = true;
                    break;
                }
            }
            break;
        }
        while (!queue.isEmpty())
        {
            int[] now = queue.poll();
            char nowColor = board[now[0]][now[1]];

            for (int i = 0; i < 4; i++)
            {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M)
                {
                    if (!visited[nx][ny])
                    {
                        if(nowColor =='#')
                        {
                            if (board[nx][ny] == '?')
                            {
                                board[nx][ny] = '.';
                                queue.add(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                            else if (board[nx][ny] == '.')
                            {
                                queue.add(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                            else if (board[nx][ny] == '#')
                            {
                                return false;
                            }
                        }
                        else if (nowColor == '.')
                        {
                            if (board[nx][ny] == '?')
                            {
                                board[nx][ny] = '#';
                                queue.add(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                            else if (board[nx][ny] == '#')
                            {
                                queue.add(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                            else if (board[nx][ny] == '.')
                            {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}