import org.w3c.dom.Node;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int N, M, T;
    static int[] truth;
    static ArrayList<Integer>[] party;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //사람 수
        M = Integer.parseInt(st.nextToken()); //파티 수
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        party = new ArrayList[M + 1];
        for (int i = 1; i <= M; i++) {
            party[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        truth = new int[T + 1];

        for (int i = 1; i <= T; i++) {
            truth[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int partyPeople = Integer.parseInt(st.nextToken()); //파티 사람 수
            for (int j = 1; j <= partyPeople; j++)
            {
                party[i].add(Integer.parseInt(st.nextToken()));

            }

        }
        for (int i = 1; i <= M; i++) {
            for (int j = 0; j < party[i].size() - 1; j++) {
                union(party[i].get(j), party[i].get(j + 1));
            }
        }

        int count = 0;
        for (int i = 1; i <= M; i++)
        {
            int index = find(party[i].get(0));
            if (T > 0)
            {
                for (int j = 1; j <= T; j++)
                {
                    if (index == find(truth[j]))
                    {
                        count = count - (j - 1);
                        break;
                    }
                    else
                    {
                        count++;
                    }
                }
            }
            else
            {
                count++;
            }

        }
        if (T > 0) {
            System.out.println((int) count / T);
        }
        else
            System.out.println(count);



    }
    public static int find(int x)
    {
        if (x == parent[x]) {
            return x;
        }
        else
        {
            return parent[x] = find(parent[x]);
        }

    }
    public static void union(int x, int y)
    {
        int a = find(x);
        int b = find(y);

        if (a != b) {
            parent[b] = a;
        }


    }

}