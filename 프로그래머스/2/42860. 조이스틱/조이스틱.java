class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        
        //알파벳 변경 횟수 계산
        for(int i=0; i<length; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }
        
        int minMove = length - 1;
        for(int i=0; i<length; i++) {
            int next = i + 1;
            
            while(next < length && name.charAt(next) == 'A') {
                next++;
            }
            minMove = Math.min(minMove, i+length-next+Math.min(i, length - next));
        }
        answer += minMove;
        
        return answer;
    }
}