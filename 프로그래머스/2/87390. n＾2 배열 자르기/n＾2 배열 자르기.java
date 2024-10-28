class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        int index = 0;
        
        for(long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;
            long max = Math.max(row, col);
            answer[index++] = (int) max + 1; 
        }
        
        
        
        return answer;
    }
}