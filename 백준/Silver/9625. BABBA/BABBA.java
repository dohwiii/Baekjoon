import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0, 0});
        list.add(new int[]{0, 1});
        list.add(new int[]{1, 1});

        for (int i = 3; i <= N; i++) {
            int[] p1 = list.get(i - 1);
            int[] p2 = list.get(i - 2);
            list.add(new int[]{p1[0] + p2[0], p1[1] + p2[1]});
        }
        System.out.println(list.get(N)[0] + " " + list.get(N)[1]);
    }
}
