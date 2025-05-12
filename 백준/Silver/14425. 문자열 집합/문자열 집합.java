import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] standard = new String[N];
        Set<String> set = new HashSet<>();
        String[] compare = new String[M];

        for (int i = 0; i < N; i++) {
            standard[i] = br.readLine();
            set.add(standard[i]);
        }
        int ans = 0;
        for (int i = 0; i < M; i++) {
            compare[i] = br.readLine();
            if (set.contains(compare[i])) {
                ans++;
            }
        }

        System.out.println(ans);



    }
}