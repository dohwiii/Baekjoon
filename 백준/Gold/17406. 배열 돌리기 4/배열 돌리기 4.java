import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    static int N, M, K;
    static int[][] map;
    static int[][] rotation;
    static int[] dx = {1, 0, -1, 0}; //아래, 오른쪽, 위, 왼쪽
    static int[] dy = {0, 1, 0, -1};
    static int[] result; //순열 순서 배열
    static boolean[] visited;
    static int min = Integer.MAX_VALUE; //결과값

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); //연산 횟수
        map = new int[N][M];
        result = new int[K];
        visited = new boolean[K];
        rotation = new int[K][3];

        for (int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++)
        {
            st = new StringTokenizer(br.readLine());
            rotation[i][0] = Integer.parseInt(st.nextToken());
            rotation[i][1] = Integer.parseInt(st.nextToken());
            rotation[i][2] = Integer.parseInt(st.nextToken());
        }
        permutation(0);
        System.out.println(min);

    }

    public static void calcMin(int[][] temp)
    {
        for (int i = 0; i < N; i++)
        {
            int sum = 0;
            for (int j = 0; j < M; j++)
            {
                sum += temp[i][j];
            }
            min = Math.min(min, sum);
        }
    }


    public static void permutation(int idx)
    {
        if (idx == K)
        {
            int[][] copyArr = new int[N][M];
            for (int i = 0; i < N; i++)
            {
                copyArr[i] = map[i].clone();
            }
            //result 배열 : 순열 결과
            for (int i = 0; i < result.length; i++)
            {
                int leftX = rotation[result[i]][0] - rotation[result[i]][2] - 1;
                int leftY = rotation[result[i]][1] - rotation[result[i]][2] - 1;
                int rightX = rotation[result[i]][0] + rotation[result[i]][2] - 1;
                int rightY = rotation[result[i]][1] + rotation[result[i]][2] - 1;

                rotate(new Pos(leftX, leftY), new Pos(rightX, rightY), copyArr);
            }
            calcMin(copyArr);
            return;
        }
        for (int i = 0; i < K; i++)
        {
            if (!visited[i])
            {
                visited[i] = true;
                result[idx] = i;
                permutation(idx + 1);
                visited[i] = false;
            }
        }
    }

    public static void rotate(Pos start, Pos end, int[][] copy)
    {
        int row = end.x - start.x + 1; //가로
        int col = end.y - start.y + 1; //세로

        for (int i = 0; i < Math.min(row, col) / 2; i++) //0,1
        {
            int x = start.x + i;
            int y = start.y + i;
            int temp = copy[x][y];
            int index = 0;

            while (index < 4)
            {
                int nx = x + dx[index];
                int ny = y + dy[index];

                if (nx >= (start.x + i) && nx <= (end.x - i) && ny >= (start.y + i) && ny <= (end.y - i))
                {
                    copy[x][y] = copy[nx][ny];
                    x = nx;
                    y = ny;

                } else
                {
                    index++;
                }
            }
            copy[start.x + i][start.y + i + 1] = temp;
        }
    }
}

class Pos
{
    int x, y;

    public Pos(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}