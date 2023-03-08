import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        count = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            count[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if (x == 0)
            {
                Union(y, z);

            }
            else
            {
                if (checkSame(y, z)) {
                    System.out.println("YES");

                } else {
                    System.out.println("NO");

                }
            }
        }

    }

    public static void Union(int x, int y)
    {
        int a = find(x);
        int b = find(y);

        if (a != b) {
            count[b] = a;
        }
    }

    public static int find(int x) {

        if (count[x] == x) {
            return x;
        }
        else
        {
            return count[x] = find(count[x]);
        }
    }

    public static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {

            return true;
        }
        return false;
    }

}