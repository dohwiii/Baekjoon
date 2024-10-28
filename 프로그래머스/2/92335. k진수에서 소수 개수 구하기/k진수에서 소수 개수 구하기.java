class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] transform = Integer.toString(n, k).split("0"); //n을 k진수로 변환(String)
        
        for(String sen : transform) {
            if(sen.isEmpty()) {
                continue;
            }
            if(isPrime(sen)) {
                answer++;
            }
        }

        return answer;
    }
    public boolean isPrime(String n) {   //소수 판별
        long num = Long.parseLong(n);
        if(num == 1) {
            return false;
        }
        for(int i=2; i <= (int) Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}