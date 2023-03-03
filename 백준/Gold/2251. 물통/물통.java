import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] Sender = {0, 0, 1, 1, 2, 2};
    static int[] Receiver = {1, 2, 0, 2, 0, 1};
    static boolean[][] visited;
    static int[] water;
    static boolean[] answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        water = new int[3]; //물통
        visited = new boolean[201][201];
        answer = new boolean[201];

        water[0] = Integer.parseInt(st.nextToken());
        water[1] = Integer.parseInt(st.nextToken());
        water[2] = Integer.parseInt(st.nextToken());

        BFS();
        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) {
                System.out.print(i + " ");
            }
        }



    }

    public static void BFS()
    {
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0, 0));
        visited[0][0] = true;
        answer[water[2]] = true; //시간을 줄이기위해 0,0은 queue에 추가하지않고 10 바로 답에 저장

        while (!queue.isEmpty())
        {
            AB p = queue.poll();
            //물의 양
            int A = p.A;
            int B = p.B;
            int C = water[2] - A - B;

            for (int i = 0; i < 6; i++)
            {
                int[] next = {A, B, C};
                next[Receiver[i]] = next[Receiver[i]] + next[Sender[i]];
                next[Sender[i]] = 0;
                if (next[Receiver[i]] > water[Receiver[i]])
                {
                    next[Sender[i]] = next[Receiver[i]] - water[Receiver[i]];
                    next[Receiver[i]] = water[Receiver[i]];


                }
                if (!visited[next[0]][next[1]])
                {
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));
                    if (next[0] == 0) {
                        answer[next[2]] = true;
                    }

                }
            }


        }

    }

}
class AB
{
    int A;
    int B;

    public AB(int A, int B) {
        this.A = A;
        this.B = B;
    }
}