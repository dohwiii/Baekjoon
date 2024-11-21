class Solution {
    static int answer = 0;
    static boolean[] col, diag1, diag2;

    public int solution(int n) {
        answer = 0;
        col = new boolean[n];
        diag1 = new boolean[2 * n - 1]; // x + y
        diag2 = new boolean[2 * n - 1]; // x - y + (n - 1)
        solve(0, n);
        return answer;
    }

    public void solve(int row, int n) {
        if (row == n) { // 모든 퀸을 배치 완료
            answer++;
            return;
        }

        for (int c = 0; c < n; c++) {
            if (col[c] || diag1[row + c] || diag2[row - c + n - 1]) {
                continue; // 퀸을 놓을 수 없는 자리
            }

            // 상태 갱신
            col[c] = true;
            diag1[row + c] = true;
            diag2[row - c + n - 1] = true;

            solve(row + 1, n); // 다음 행으로 이동

            // 상태 복구 (백트래킹)
            col[c] = false;
            diag1[row + c] = false;
            diag2[row - c + n - 1] = false;
        }
    }
}
