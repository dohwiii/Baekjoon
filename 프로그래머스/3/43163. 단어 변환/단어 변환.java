import java.util.*;

// words 단어와 이전 비교 단어가 하나만 다르다면 탐색 진행
class Solution {
    static int min = 11;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        dfs(0, begin, words, begin, target, new HashSet<>());
        
        if(min == 11) {
            min = 0;
        }
        // begin -> target 변환 불가능 0 출력
        return min;
    }
    private static void dfs(int depth, String word, String[] words, String begin, String target, Set<String> visited) {
        if(word.equals(target)) {
            min = Math.min(min, depth);
            return;
        }
        
        char[] nowStr = word.toCharArray();
        
        for(int i=0; i<words.length; i++) {
            if(!visited.contains(words[i])) {
                // 한 개의 알파벳만 바꿔서 되는지 검사
                int cnt = 0;
                char[] nextStr = words[i].toCharArray();
                for(int j=0; j<nowStr.length; j++) {    // 모든 단어의 길이는 같다고 주어짐
                    if(nowStr[j] != nextStr[j]) {
                        cnt++;
                    }
                }
                if(cnt == 1) {
                    visited.add(words[i]);  // 방문 체크
                    dfs(depth + 1, words[i], words, begin, target, visited);
                    visited.remove(words[i]);
                }
            }
        }
    }
}