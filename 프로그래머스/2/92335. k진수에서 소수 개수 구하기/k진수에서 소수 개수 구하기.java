class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String transform = Integer.toString(n, k); //n을 k진수로 변환(String)
        String sentence = "";
        
        for(int i=0; i<transform.length(); i++) {
            char c = transform.charAt(i);
            if(c == '0') {
                if(sentence.length() > 0) {
                    if(isPrime(sentence)) {
                        answer++;
                    }
                }
                sentence = "";
            }
            else {
                sentence += c;
            }
        }
        if(sentence.length() > 0) {
            if(isPrime(sentence)) {
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