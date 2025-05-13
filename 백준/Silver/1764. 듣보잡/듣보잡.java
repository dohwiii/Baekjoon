import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        int ans = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (set.contains(str)) {
                ans++;
                list.add(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(list); //사전순 정렬
        sb.append(ans + "\n");
        for (String s : list) {
            sb.append(s + "\n");
        }
        System.out.println(sb);





    }

}
