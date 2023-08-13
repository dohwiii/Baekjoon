import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] isSelected;
    static int[] number;
    static int[] arr;
    static int ans;
    static List<List<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            isSelected = new boolean[4];
            number = new int[]{1, 2, 3};
            arr = new int[N];
            ans = 0;
            list = new ArrayList<>();

            combination(0, 0,  new ArrayList<>());
            System.out.println(ans);
        }




    }

    public static void combination(int depth, int sum, List<Integer> numList) {
        if (sum == N) {
//            System.out.println(numList);
            ans++;
            return;
        }
        if (depth == N) {
//            if (sum == N) {
//                ans++;
//            }
            return;
        }
        for (int i = 0; i < 3; i++) {
            numList.add(number[i]);
            combination(depth + 1, sum + number[i], numList);
            numList.remove(numList.size() - 1);
        }

    }

}