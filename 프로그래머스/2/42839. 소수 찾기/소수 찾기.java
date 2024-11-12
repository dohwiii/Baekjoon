import java.util.*;

class Solution {
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        
        for(int i=1; i<=numbers.length(); i++) {
            solve(0, i, numbers);
        }
        return set.size();
    }
    public void solve(int depth, int length, String numbers) {
        if(depth == length) {
            int num = Integer.parseInt(sb.toString());
            if(num == 0 || num == 1) {
                return;
            }
            boolean isPrime = true;
            for(int i=2; i<=(int)Math.sqrt(num); i++) {
                if(num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {   //소수임
                set.add(num);
            }
            return;
        }
        
        for(int i=0; i<numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                sb.append(numbers.charAt(i));
                solve(depth + 1, length, numbers);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
} 