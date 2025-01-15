class Solution {
    public int solution(int n) {
        int answer = 0;
        int min = 1_000_001;
        
        for(int i=1; i<n; i++) {
            if(n % i == 1) {
                min = i;
                break;
            }
        }
        return min;
    }
}