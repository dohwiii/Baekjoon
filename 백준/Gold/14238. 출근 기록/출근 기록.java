import java.util.*;

public class Main {
    static int[][][][][][] dp; // DP 테이블
    static char[] result; // 결과 저장
    static int[] count = new int[3]; // A, B, C의 출근 횟수
    static boolean found = false; // 결과를 찾았는지 여부

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        sc.close();

        // A, B, C의 출근 횟수 계산
        for (char c : S.toCharArray()) {
            count[c - 'A']++;
        }

        // DP 테이블 초기화
        int n = S.length();
        dp = new int[n + 1][count[0] + 1][count[1] + 1][count[2] + 1][4][4];
        result = new char[n];

        // 백트래킹 시작
        if (solve(0, count[0], count[1], count[2], 3, 3)) {
            System.out.println(new String(result));
        } else {
            System.out.println(-1);
        }
    }

    static boolean solve(int day, int a, int b, int c, int prev1, int prev2) {
        // 모든 날짜를 처리한 경우
        if (day == result.length) {
            return true;
        }

        // 이미 계산된 경우
        if (dp[day][a][b][c][prev1][prev2] != 0) {
            return dp[day][a][b][c][prev1][prev2] == 1;
        }

        // A를 출근시키는 경우
        if (a > 0) {
            result[day] = 'A';
            if (solve(day + 1, a - 1, b, c, 0, prev1)) {
                dp[day][a][b][c][prev1][prev2] = 1;
                return true;
            }
        }

        // B를 출근시키는 경우 (이전 날 B가 출근하지 않았어야 함)
        if (b > 0 && prev1 != 1) {
            result[day] = 'B';
            if (solve(day + 1, a, b - 1, c, 1, prev1)) {
                dp[day][a][b][c][prev1][prev2] = 1;
                return true;
            }
        }

        // C를 출근시키는 경우 (이전 이틀 동안 C가 출근하지 않았어야 함)
        if (c > 0 && prev1 != 2 && prev2 != 2) {
            result[day] = 'C';
            if (solve(day + 1, a, b, c - 1, 2, prev1)) {
                dp[day][a][b][c][prev1][prev2] = 1;
                return true;
            }
        }

        // 가능한 경우가 없는 경우
        dp[day][a][b][c][prev1][prev2] = -1;
        return false;
    }
}