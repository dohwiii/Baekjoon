import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Set<String> set = new HashSet<>();
        for(String w : words) {
            set.add(w);
        }
        
        
        return bfs(begin, target, set);
    }
    private static int bfs(String begin, String target, Set<String> set) {
        Queue<Sentence> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new Sentence(begin, 0));
        visited.add(begin); // 방문체크
        StringBuilder sb = new StringBuilder();
        
        while(!queue.isEmpty()) {
            Sentence now = queue.poll();
            if(now.str.equals(target)) {
                return now.depth;
            }
            
            for(int i=0; i<now.str.length(); i++) {
                sb = new StringBuilder(now.str);
                
                for(char c='a'; c<='z'; c++) {
                    sb.setCharAt(i, c);
                    if(set.contains(sb.toString()) && !visited.contains(sb.toString()) ) {   // words에 포함이 되어있다면
                        visited.add(sb.toString());
                        queue.offer(new Sentence(sb.toString(), now.depth + 1));
                    }

                }
            }
            
        }
        return 0;
    } 
    static class Sentence {
        String str;
        int depth;
        
        public Sentence(String str, int depth) {
            this.str=str;
            this.depth=depth;
        }
    }
}