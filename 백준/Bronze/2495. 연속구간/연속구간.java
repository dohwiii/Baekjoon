
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            char[] arr = br.readLine().toCharArray();
            int cnt = 1;
            int max = 1;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j - 1] == arr[j]) {
                    cnt++;
                }
                else {  //다름

                    max = Math.max(max, cnt);
                    cnt = 1;
                }
            }
            max = Math.max(max, cnt);
            sb.append(max + "\n");
        }

        System.out.println(sb);






    }
}