class Solution {
    static int count;
    public int solution(int[] numbers, int target) {
        count = 0;
        dfs(numbers, 0, 0, target);
        return count;
    }
    public void dfs(int[] numbers, int index, int sum, int target)
    {
        if(sum == target && index == numbers.length)
        {
            count++;
        }
        
        if(index < numbers.length)
        {
            int sum1 = numbers[index] + sum;
            dfs(numbers, index + 1, sum1, target);
            
            int sum2 = numbers[index]*-1 + sum;
            dfs(numbers, index + 1, sum2, target);
        }
    }
}