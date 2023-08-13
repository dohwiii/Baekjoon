import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] number;
    static int ans;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            number = new int[]{1, 2, 3};
            ans = 0;

            combination(0, 0, new ArrayList<>());
            System.out.println(ans);
        }
    }

    public static void combination(int depth, int sum, List<Integer> numList) {
        if (sum == N) {
            ans++;
            return;
        }
        if (depth == N) {
            return;
        }
        for (int i = 0; i < 3; i++) { //number 배열 인덱스 (1, 2, 3 값 집어넣기용)
            numList.add(number[i]);
            combination(depth + 1, sum + number[i], numList);
            numList.remove(numList.size() - 1); //마지막 넣은 원소 제거
        }

    }
}