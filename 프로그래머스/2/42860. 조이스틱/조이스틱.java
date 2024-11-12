class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        
        //알파벳 변경 횟수
        for(int i=0; i<name.length(); i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }
        int minMove = length - 1;   //정방향으로 쭉 가기
        for(int i=0; i<length; i++) {
            int nextIndex = i + 1;
            
            while(nextIndex < length && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }
            minMove = Math.min(minMove, i + length - nextIndex + Math.min(i, (length - nextIndex)));
        }
        
        answer += minMove;
        return answer;
    }
}