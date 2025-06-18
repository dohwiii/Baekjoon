import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        // 포인터와 뒤집힘 플래그
        int left = 0, right = T.length() - 1;
        boolean reversed = false;

        // T 길이가 S 길이보다 클 동안
        while (right - left + 1 > S.length()) {
            if (!reversed) {
                // 정상 방향일 때 끝 문자는 T.charAt(right)
                if (T.charAt(right) == 'A') {
                    right--;
                } else {
                    // B: 제거 후 뒤집힘 토글
                    right--;
                    reversed = !reversed;
                }
            } else {
                // 뒤집힌 상태일 때 "끝" 문자는 사실 T.charAt(left)
                if (T.charAt(left) == 'A') {
                    left++;
                } else {
                    left++;
                    reversed = !reversed;
                }
            }
        }

        // 길이가 같아졌으면 남은 구간과 S 비교
        boolean ok = true;
        for (int i = 0; i < S.length(); i++) {
            char c = reversed
                   ? T.charAt(right - i)  // 뒤집힌 상태면 오른쪽부터
                   : T.charAt(left + i);  // 정상 상태면 왼쪽부터
            if (c != S.charAt(i)) {
                ok = false;
                break;
            }
        }

        System.out.println(ok ? 1 : 0);
    }
}