class Solution {
    private static final int[] WEIGHTS = {781, 156, 31, 6, 1};
    private static final char[] VOWELS = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        int answer = 0;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            answer += caculate(c, i); // 문자와 문자 위치
            answer += 1;    //현재 자기 자신
        }
        return answer;
    }
    public int caculate(char alp, int location) {
        for(int i=0; i<5; i++) {
            if(VOWELS[i] == alp) {
                return WEIGHTS[location] * i;
            }
        }
        return 0;
    }
}