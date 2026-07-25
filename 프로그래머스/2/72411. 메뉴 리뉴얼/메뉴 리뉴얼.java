import java.util.*;
// 1. orders의 주문한 메뉴를 가지고 course 크기만큼 조합구하기
// 2. 조합 메뉴가 orders에 몇번 주문됐는지 카운트
// 3. 주문한게 2번 이상이라면 추가
class Solution {
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        List[] ansList = new List[course.length];
        for(int i=0; i<course.length; i++) {
            ansList[i] = new ArrayList<>();
        }
        
        for(int i=0; i<course.length; i++) {
            int menuSize = course[i];
            Map<String, Integer> orderMap = new HashMap<>();
            
            for(int j=0; j<orders.length; j++) {
                char[] order = orders[j].toCharArray();
                Arrays.sort(order); // 알파벳 오름차순
                combi(0, 0, new char[menuSize], menuSize, order, orderMap);
            }
            int max = 0;
            // 최대 주문 메뉴 추리기
            for(String key : orderMap.keySet()) {
                int orderCnt = orderMap.get(key);   // 주문 횟수
                if(orderCnt < 2) {
                    continue;
                }
                if(orderCnt > max) {  // 새 최댓값
                    max = orderCnt;
                    ansList[i] = new ArrayList<>();
                    ansList[i].add(key);
                }
                else if(orderCnt == max){
                    ansList[i].add(key);
                }
            }
        }
        List<String> ans = new ArrayList<>();
        
        for(int i=0; i<course.length; i++) {
            ans.addAll(ansList[i]);
        }
        Collections.sort(ans);
        answer = new String[ans.size()];
        for(int i=0; i<ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
    private static void combi(int depth, int index, char[] result, int menuSize, char[] order, Map<String, Integer> orderMap) {
        if(depth == menuSize) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<menuSize; i++) {
                sb.append(result[i]);
            }
            String str = sb.toString();
            orderMap.put(str, orderMap.getOrDefault(str, 0) + 1);
            return;
        }
        for(int i=index; i<order.length; i++) {
            result[depth] = order[i];
            combi(depth + 1, i + 1, result, menuSize, order, orderMap);
        }
    }
}