import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        // LinkedHashMap으로 LRU 캐시 구현 (accessOrder = true)
        LinkedHashMap<String, Boolean> cache = new LinkedHashMap<>(cacheSize, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Boolean> eldest) {
                return size() > cacheSize;
            }
        };

        for (String city : cities) {
            city = city.toLowerCase(); // 대소문자 구분 제거
            if (cache.containsKey(city)) { // 캐시 히트
                answer += 1;
            } else { // 캐시 미스
                answer += 5;
            }
            cache.put(city, true); // 캐시에 추가 (이미 존재하면 위치 갱신)
        }

        return answer;
    }
}
