class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = getGCD(arrayA);
        int gcdB = getGCD(arrayB);
        
        int candidateA = (gcdA > 1) ? checkCondition(gcdA, arrayB) : 0;
        int candidateB = (gcdB > 1) ? checkCondition(gcdB, arrayA) : 0;
        
        return Math.max(candidateA, candidateB);
    }
    public int checkCondition(int gcdValue, int[] otherArray) {
        for(int num : otherArray) {
            if(num % gcdValue == 0) {
                return 0;   //조건 만족 안함(나누어짐)
            }
        }
        return gcdValue;
    }
    public int getGCD(int[] array) {
        int gcdValue = array[0];    //첫 배열값
        
        for(int i=1; i<array.length; i++) {
            gcdValue = gcd(gcdValue, array[i]);
            if(gcdValue == 1) {
                return 1;
            }
        }
        return gcdValue;
    }
    public int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
            
    }
}