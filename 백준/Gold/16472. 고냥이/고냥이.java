import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();
        int L = s.length();

        int[] freq = new int[26];
        int distinct = 0, maxLen = 0;
        int left = 0;

        for (int right = 0; right < L; right++) {
            int c = s.charAt(right) - 'a';
            if (freq[c] == 0) {
                distinct++;
            }
            freq[c]++;

            // distinct가 N을 초과하면 left를 움직여 줄인다
            while (distinct > N) {
                int d = s.charAt(left) - 'a';
                freq[d]--;
                if (freq[d] == 0) {
                    distinct--;
                }
                left++;
            }

            // 현재 [left..right] 구간의 길이 갱신
            maxLen = Math.max(maxLen, right - left + 1);
        }

        System.out.println(maxLen);
    }
}
