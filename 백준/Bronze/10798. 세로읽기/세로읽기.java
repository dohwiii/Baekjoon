import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = new String[5];
        int maxCol = 0;
        for (int i = 0; i < 5; i++) {
            arr[i] = br.readLine();
            maxCol = Math.max(maxCol, arr[i].length());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxCol; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[j].length() <= i) {
                    continue;
                }
                sb.append(arr[j].charAt(i));
            }
        }
        System.out.println(sb);
    }
}