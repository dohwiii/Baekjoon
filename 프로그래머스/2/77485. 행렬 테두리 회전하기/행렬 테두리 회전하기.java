class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[] matrix = new int[rows * columns];

        // 1. 1차원 배열로 초기화
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i * columns + j] = i * columns + j + 1;
            }
        }

        // 2. 쿼리 처리
        for (int q = 0; q < queries.length; q++) {
            int x1 = queries[q][0] - 1;
            int y1 = queries[q][1] - 1;
            int x2 = queries[q][2] - 1;
            int y2 = queries[q][3] - 1;

            int prev = matrix[x1 * columns + y1];
            int minVal = prev;

            // 상단 행 이동
            for (int y = y1 + 1; y <= y2; y++) {
                int idx = x1 * columns + y;
                int temp = matrix[idx];
                matrix[idx] = prev;
                prev = temp;
                minVal = Math.min(minVal, prev);
            }

            // 오른쪽 열 이동
            for (int x = x1 + 1; x <= x2; x++) {
                int idx = x * columns + y2;
                int temp = matrix[idx];
                matrix[idx] = prev;
                prev = temp;
                minVal = Math.min(minVal, prev);
            }

            // 하단 행 이동
            for (int y = y2 - 1; y >= y1; y--) {
                int idx = x2 * columns + y;
                int temp = matrix[idx];
                matrix[idx] = prev;
                prev = temp;
                minVal = Math.min(minVal, prev);
            }

            // 왼쪽 열 이동
            for (int x = x2 - 1; x >= x1; x--) {
                int idx = x * columns + y1;
                int temp = matrix[idx];
                matrix[idx] = prev;
                prev = temp;
                minVal = Math.min(minVal, prev);
            }

            // 결과 저장
            answer[q] = minVal;
        }

        return answer;
    }
}
