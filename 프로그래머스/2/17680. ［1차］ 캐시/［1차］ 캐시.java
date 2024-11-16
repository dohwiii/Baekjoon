import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new ArrayDeque<>();
        
        for(String city : cities) {
            boolean isFind = false;
            if(!queue.isEmpty()) {
                for(String s : queue) {
                    if(city.equalsIgnoreCase(s)) {
                        answer += 1;
                        isFind = true;
                        queue.remove(s);
                        queue.offer(city);
                        break;
                    }
                }
                if(!isFind) {   //같은 도시가 캐시에 없다면
                    if(queue.size() >= cacheSize) { //캐시 용량이 이미 찼다면
                        queue.poll();
                    }
                    queue.offer(city);
                    answer += 5;
                }
            }
            else {  //큐에 아무것도 없어서 넣어야함
                if(cacheSize > 0) {
                    queue.offer(city);
                    answer += 5;
                }
                else {  //큐 사이즈 0일 때
                    answer += 5;
                }
            }
        }
        return answer;
    }
}