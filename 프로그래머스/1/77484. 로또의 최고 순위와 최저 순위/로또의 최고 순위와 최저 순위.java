class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] number = new int[46];
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        int same = 0;
        
        for(int lotto : lottos) {
            number[lotto]++;
        }
        for(int win : win_nums) {
            if(number[win] > 0) {
                same++;
                number[win]--;
            }
        }
        answer[1] = rank[same];
        same += number[0];
        answer[0] = rank[same];
        
        
        return answer;
    }
}