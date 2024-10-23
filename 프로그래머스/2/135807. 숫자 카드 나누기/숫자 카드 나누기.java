class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int a = 0;
        int b = 0;
        boolean isPossibleA = true;
        boolean isPossibleB = true;
        
        if(arrayA.length > 1) {
             a = gcd(arrayA[0], arrayA[1]);
             b = gcd(arrayB[0], arrayB[1]);
            if(a == 1) {
                isPossibleA = false;
            }
            if(b == 1) {
                isPossibleB = false;
            }
            if(isPossibleA) {   //a가 1이 아닌 경우
                for(int i=2; i<arrayA.length; i++) {
                    a = gcd(a, arrayA[i]);
                }
                for(int i=0; i<arrayB.length; i++) {
                    if(arrayB[i] % a == 0) {    //A의 최대공약수가 B에서도 나누어지면 안됨
                        isPossibleA = false;
                        break;
                    }
                }
            }
            if(isPossibleB) {
                for(int i=2; i<arrayB.length; i++) {
                    b = gcd(b, arrayB[i]);
                }
                for(int i=0; i<arrayA.length; i++) {
                    if(arrayA[i] % b == 0) {    //B의 최대공약수가 A에서 나누어지면 안됨
                        isPossibleB = false;
                        break;
                    }
                }
            }
        }
        else {
            a = arrayA[0];
            b = arrayB[0];
            if(a % b == 0) {
                isPossibleB = false;
            }
            if(b % a == 0) {
                isPossibleA = false;
            } 
        }
        // System.out.println(isPossibleA + " " +isPossibleB);
        
        if(isPossibleA && isPossibleB) {    //A와 B 배열 모두 답인 값이 있는 경우 -> 더 큰 값
            answer = Math.max(a, b);
        }
        if(isPossibleB && !isPossibleA) {
            answer = b;
        }
        if(isPossibleA && !isPossibleB) {
            answer = a;
        }
        
        return answer;
    }
    public static int gcd(int a, int b) {
        if(b==0) {
            return a;
        }
        return gcd(b, a % b);
            
    }
}