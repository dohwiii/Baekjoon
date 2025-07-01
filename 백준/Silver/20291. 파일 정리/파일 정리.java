
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int idx = str.indexOf('.');
            String arg = str.substring(idx + 1);
            map.put(arg, map.getOrDefault(arg, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for (String key : map.keySet()) {
            sb.append(key + " " + map.get(key)).append("\n");
        }
        System.out.println(sb);




    }
}