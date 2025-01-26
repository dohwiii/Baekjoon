class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin + 1)];
        int index = 0;
        for(long i = begin; i<=end; i++) {
            if(i == 1) {
                answer[index++] = 0;
                continue;
            }
            answer[index++] = solve(i);
        }
        return answer;
    }
    public int solve(long n) {
        int max = 1;
        int num = (int) Math.sqrt(n);
        if(num > 10_000_000) {
            num = 10_000_000;
        }
        for(int i = 2; i<=num; i++) {
            if(n % i == 0) {    //약수라면
                int quotient = (int) n/i;
                if(quotient > 10_000_000) {
                    max = Math.max(max, i);
                    continue;
                }
                max = Math.max(max, quotient);
            }
        }
        return max;
    }
}