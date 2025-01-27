class Solution {
    public int solution(int n) {
        int next = n + 1;
        int cnt = Integer.bitCount(n);
        
        while(true) {
            if(Integer.bitCount(next) == cnt) {
                return next;
            }
            next++;
        }
        
    }
}