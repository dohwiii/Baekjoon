import java.util.*;

class Solution {
    static Set<Integer> uniqueNumbers = new HashSet<>();
    static Set<Integer> primes = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        generatePermutation("", numbers);
        
        return primes.size();
    }
    public void generatePermutation(String prefix, String remaining) {
        if(!prefix.isEmpty()) {
            int num = Integer.parseInt(prefix);
            if(isPrime(num)) {
                primes.add(num);
            }
        }
        
        for(int i=0; i<remaining.length(); i++) {
            generatePermutation(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i+1));
        }
    }
    //소수 판별
    public boolean isPrime(int num) {
        if(num < 2) {
            return false;
        }
        if(primes.contains(num)) {  //이미 판별된 소수
            return true;
        }
        for(int i=2; i<=(int)Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}  