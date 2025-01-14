class Solution {
    static int answer;
    public int solution(int[] number) {
        combi(0, 0, 0, number);
        return answer;
    }
    public void combi(int index, int depth, int sum, int[] number) {
        if(depth == 3) {    //3명
            if(sum == 0) {
                answer++;
            }
            return;
        }
        for(int i=index; i<number.length; i++) {
            combi(i + 1, depth + 1, sum + number[i], number);
        }
    }
}