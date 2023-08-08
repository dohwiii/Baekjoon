import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int F, S, G, U, D;
    static int[] arr = new int[1000001];
    static boolean isPossible;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken()); //총 층의 개수
        S = Integer.parseInt(st.nextToken()); //현재 위치
        G = Integer.parseInt(st.nextToken()); //스타트링크 위치
        U = Integer.parseInt(st.nextToken()); //위로 U층
        D = Integer.parseInt(st.nextToken()); //아래로 D층

        int[] dx = {U, -D};
        Arrays.fill(arr, -1);
        building(S, G, dx);

        if (isPossible) {
            System.out.println(arr[G]);
        }
        else {
            System.out.println("use the stairs");
        }

    }

    public static void building(int start, int end, int[] dx) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        arr[start] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == end) {
                isPossible = true;
                return;
            }

            for (int i = 0; i < 2; i++)
            {
                int nx = now + dx[i]; //3,-1
                if (nx < 1 || nx > F) {
                    continue;
                }
                //건물의 층수에 해당한다면
                if (nx >= 1 && nx <= F) {
                    if (arr[nx] == -1) {  //한번도 방문하지 않았다면
                        arr[nx] = arr[now] + 1;
                        queue.add(nx);
                    }
                }
            }
        }
    }
}
