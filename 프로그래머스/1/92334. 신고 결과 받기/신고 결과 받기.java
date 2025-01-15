import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Set<String> set = new HashSet<>();  //신고 레포트
        Map<String, Integer> map = new HashMap<>(); //신고 당한 횟수
        Map<String, Integer> idMap = new HashMap<>(); //유저 인덱스 저장
        List<String>[] list = new List[id_list.length];
        
        for(int i=0; i<id_list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<id_list.length; i++) {
            idMap.put(id_list[i], i);
        }
        for(String r : report) {
            String[] re = r.split(" ");
            String user = re[0];    //이용자 id
            String receive = re[1]; //신고한 id
            
            if(!set.contains(r)) {   //동일한 신고 기록인지 검사
                set.add(r); //신고 기록
                map.put(receive, map.getOrDefault(receive, 0) + 1); //신고 누적
                list[idMap.get(receive)].add(user);
            }   
        }
        for(String key : map.keySet()) {
            int cnt = map.get(key); //신고 당한 횟수
            int userId = idMap.get(key);    //유저 인덱스
            if(cnt >= k) {
                for(String user : list[userId]) {
                    int reporterIndex = idMap.get(user);
                    answer[reporterIndex]++;
                }
            }
        }
        
    
        
        return answer;
    }
}