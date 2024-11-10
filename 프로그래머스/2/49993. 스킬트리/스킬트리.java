import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i=0; i<skill_trees.length; i++) {
            String skillTree = skill_trees[i];
            boolean isPossible = true;
            
            //스킬 큐에 넣기
            Queue<Character> queue = new ArrayDeque<>();
            for(int j=0; j<skill.length(); j++) {
                queue.offer(skill.charAt(j));
            }
            
            for(int j=0; j<skillTree.length(); j++) {
                if(!queue.isEmpty()) {
                    char c = queue.peek();
                    if(skillTree.charAt(j) == c) {  //순서를 지킨 경우
                        queue.poll();
                    }
                    else if(queue.contains(skillTree.charAt(j))) {  //다음 순서가 아닌데 먼저 있는 경우
                        isPossible = false;
                        break;
                    }
                }               
            }
            if(isPossible) {
                answer++;
            }
            
        }
                    
        return answer;
    }
}