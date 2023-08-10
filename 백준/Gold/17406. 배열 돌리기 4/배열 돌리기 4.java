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

                rotate(leftX, leftY, rightX, rightY, copyArr);
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
    public static void rotate(int lx, int ly, int rx, int ry, int[][] copy) {
        if(lx == rx && ly == ry) {
            return;
        }

        int[] temp = new int[3]; //방향별로 값을 옮기다 보면 지워질 수 있는 좌표값을 저장.
        temp[0] = copy[lx][ry];
        temp[1] = copy[rx][ry];
        temp[2] = copy[rx][ly];

        //오른쪽으로 회전
        for(int i = ry; i > ly; i--) {
            copy[lx][i] = copy[lx][i - 1];
        }
        //아래로 회전
        for(int i = rx; i > lx; i--) {
            if(i == lx + 1) copy[i][ry] = temp[0];
            else copy[i][ry] = copy[i - 1][ry];
        }
        //왼쪽으로 회전
        for(int i = ly; i < ry; i++) {
            if(i == ry - 1) copy[rx][i] = temp[1];
            else copy[rx][i] = copy[rx][i + 1];
        }
        //위로 회전
        for(int i = lx; i < rx; i++) {
            if(i == rx - 1) copy[i][ly] = temp[2];
            else copy[i][ly] = copy[i + 1][ly];
        }
        rotate(lx + 1, ly + 1, rx - 1, ry - 1, copy);
    }
}