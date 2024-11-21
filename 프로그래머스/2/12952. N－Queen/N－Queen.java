class Solution {
    static int answer;

    public int solution(int n) {
        int[] board = new int[n]; // 각 행의 퀸이 위치한 열 정보를 저장
        placeQueen(board, 0, n);
        return answer;
    }

    private void placeQueen(int[] board, int row, int n) {
        if (row == n) {
            answer++; // 모든 퀸을 배치한 경우
            return;
        }

        for (int col = 0; col < n; col++) {
            board[row] = col; // 현재 행(row)의 퀸을 col에 배치
            if (isSafe(board, row)) {
                placeQueen(board, row + 1, n); // 다음 행으로 진행
            }
        }
    }

    private boolean isSafe(int[] board, int row) {
        for (int i = 0; i < row; i++) {
            // 같은 열에 퀸이 있는 경우 또는 대각선에 퀸이 있는 경우
            if (board[i] == board[row] || Math.abs(board[row] - board[i]) == Math.abs(row - i)) {
                return false;
            }
        }
        return true;
    }
}
