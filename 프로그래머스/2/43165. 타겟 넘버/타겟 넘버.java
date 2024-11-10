class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        
        dfs(numbers[0], target, 1, numbers);
        dfs(-numbers[0], target, 1, numbers);
        
        return answer;
    }
    public void dfs(int num, int target, int depth, int[] numbers) {
        if(depth == numbers.length) {  //탐색 끝
            if(num == target) {
                answer++;
            }
            return;
        }
        dfs(num + numbers[depth], target, depth + 1, numbers);
        dfs(num - numbers[depth], target, depth + 1, numbers);
        
    }
}