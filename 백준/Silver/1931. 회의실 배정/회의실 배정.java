import java.io.*;
import java.sql.Time;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());



        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] s, int[] e) {
                if (s[1] == e[1]) {
                    return s[0] - e[0];
                }
                else
                    return s[1] - e[1];

            }
        });
        int count = 0;
        int end = -1;

        for (int i = 0; i < N; i++)
        {
            if (arr[i][0] >= end)
            {
                end = arr[i][1];
                count++;
            }

        }
        System.out.println(count);


    }

}