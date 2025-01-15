class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] visited = new boolean[10];
        
        for(int i=0; i<numbers.length; i++) {
            visited[numbers[i]] = true;
        }
        for(int i=0; i<10; i++) {
            if(!visited[i]) {
                answer += i;
            }
        }
        return answer;
    }
}