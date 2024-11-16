import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedHashSet<String> cache = new LinkedHashSet<>();
        
        for (String city : cities) {
            city = city.toLowerCase(); // 대소문자 구분 제거
            if (cache.contains(city)) { // 캐시 히트
                answer += 1;
                cache.remove(city); // 기존 위치에서 제거
                cache.add(city); // 최신 위치로 이동
            } else { // 캐시 미스
                answer += 5;
                if (cache.size() >= cacheSize && cacheSize > 0) { // 캐시 용량 초과 시 제거
                    Iterator<String> it = cache.iterator();
                    if (it.hasNext()) {
                        it.next();
                        it.remove();
                    }
                }
                if (cacheSize > 0) {
                    cache.add(city); // 새로운 도시 추가
                }
            }
        }
        return answer;
    }
}
