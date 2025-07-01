import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String[] arr = str.split("[.]");
            map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
        }
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        StringBuilder sb = new StringBuilder();

        for (String key : keySet) {
            sb.append(key + " " + map.get(key)).append("\n");
        }
        System.out.println(sb);






    }
}