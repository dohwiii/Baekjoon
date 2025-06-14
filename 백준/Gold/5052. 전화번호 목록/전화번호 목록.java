import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Set<String> set = new HashSet<>();
            String[] numbers = new String[N];
            boolean isPossible = true;
            for (int i = 0; i < N; i++) {
                numbers[i] = br.readLine();
            }
            Arrays.sort(numbers);
            for (int i = 1; i < N; i++) {
                if (numbers[i].startsWith(numbers[i - 1])) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }


        }
        System.out.println(sb);

    }
}