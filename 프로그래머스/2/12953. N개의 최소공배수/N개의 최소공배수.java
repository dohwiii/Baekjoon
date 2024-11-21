class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int total = 1;
        int result = lcm(arr[0], arr[1]);
        
        for(int i=2; i<arr.length; i++) {
            result = lcm(result, arr[i]);
        }
        return result;
    }
    public int lcm(int a, int b) {
        int gcd = gcd(a, b);
        return (a * b) / gcd;
    }
    public int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}