import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());   //비밀번호 문자열 길이
        String input = br.readLine();
        char[] arr = input.toCharArray();
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int ans = 0;
        int[] cnt = new int[4]; //ACGT
        int len = input.length();

        for (int i = 0; i < P; i++) {
            cnt[toIndex(arr[i])]++;
        }
        if (cnt[0] >= A && cnt[1] >= C && cnt[2] >= G && cnt[3] >= T) {
            ans++;
        }
        for (int i = 1; i < S - P + 1; i++) {
            int end = i + P - 1;
            cnt[toIndex(arr[i - 1])]--;
            cnt[toIndex(arr[end])]++;
            if (cnt[0] >= A && cnt[1] >= C && cnt[2] >= G && cnt[3] >= T) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    private static int toIndex(char c) {
        switch (c) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
        }
        return -1;
    }
}
