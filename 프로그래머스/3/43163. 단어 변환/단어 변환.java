import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Set<String> set = new HashSet<>();
        for(String w : words) {
            set.add(w);
        }
        
        return bfs(begin, target, words, set);
    }
    private static int bfs(String begin, String target, String[] words, Set<String> set) {
        Queue<Word> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new Word(begin, 0));
        visited.add(begin); // 방문체크
        
        while(!queue.isEmpty()) {
            Word now = queue.poll();
            if(now.str.equals(target)) {
                return now.depth;
            }
            
            for(String w : words) {
                if(visited.contains(w)) {
                    continue;
                }
                
                if(diffByOne(now.str, w)) {
                    queue.offer(new Word(w, now.depth + 1));
                    visited.add(w);
                }
            }
            
        }
        return 0;
    } 
    private static boolean diffByOne(String change, String word) {
        // 하나만 바뀐게 맞는지 검사
        int cnt = 0;
        for(int i=0; i<word.length(); i++) {
            if(word.charAt(i) != change.charAt(i)) {
                cnt++;
            }
            if(cnt > 1) {
                return false;
            }
        }
        return true;
    }
    static class Word {
        String str;
        int depth;
        
        public Word(String str, int depth) {
            this.str=str;
            this.depth=depth;
        }
    }
}