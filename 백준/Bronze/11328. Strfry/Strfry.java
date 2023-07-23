import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Main {
    static int N, K, result;

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            String output = st.nextToken();
            int[] visited = new int[27];
            boolean isPossible = true;

            for (int j = 0; j < input.length(); j++) {
                visited[input.charAt(j) - 97]++;

            }
            for (int j = 0; j < output.length(); j++) {
                visited[output.charAt(j) - 97]--;
            }
            for (int j = 0; j < 26; j++) {
                if (visited[j] != 0) {
                    isPossible = false;
                }
            }

            if (isPossible) {
                System.out.println("Possible");
            } else
                System.out.println("Impossible");

        }

    }
}