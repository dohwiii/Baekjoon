class Solution {
    static int cnt;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(0, 0, numbers, target);
        return cnt;
    }
    private static void dfs(int depth, int sum, int[] numbers, int target) {
        if(depth == numbers.length) {
            if(sum == target) {
                cnt++;
            }
            return;
        }
        dfs(depth + 1, sum + numbers[depth], numbers, target);
        dfs(depth + 1, sum - numbers[depth], numbers, target);
    }
}