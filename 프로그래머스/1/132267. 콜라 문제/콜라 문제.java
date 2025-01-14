class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int full = n;
        
        while(full >= a) {
            int empty = full % a;
            int p = full / a;
            
            full = (full / a) * b;
            answer += full;
            full += empty;
            // System.out.println("후 "+full + " " + empty +" "+answer);
            // System.out.println();
        }
        
        return answer;
    }
}