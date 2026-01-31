import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (isGroupWord(str)) {
                ans++;
            }
        }
        System.out.println(ans);


    }

    private static boolean isGroupWord(String str) {
        boolean[] alpVisited = new boolean[26];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int idx = c - 'a';
            if (alpVisited[idx] && c != str.charAt(i - 1)) {
                return false;
            }
            alpVisited[idx] = true;
        }

        return true;
    }

}
