import java.util.*;

class Solution {
    static boolean[] visited;
    static int max;
    static String maxMenu = "";
    static Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        List<String> list = new ArrayList<>();
        
        for(int j=0; j<orders.length; j++) {
            char[] charArr = orders[j].toCharArray(); // String to Char Array
            Arrays.sort(charArr); // Char Array 알파벳 순 정렬
            String order = new String(charArr); // 또는 String.valueOf(charArr);  
            
            for(int i=0; i<course.length; i++) {
                int length = course[i]; //코스요리에 해당하는 길이(요리 개수)
                if(length > order.length()) {
                    continue;
                }
                max = 0;    //같은 조합을 시킨 사람의 수
                maxMenu = " ";
                visited = new boolean[order.length()];
                combi(0, length, order, 0, orders);
            }
            
        } 

        for(int i=0; i<course.length; i++) {
            int length = course[i];
            int max = 0;
            
            for(String s : map.keySet()) {
                if(s.length() == length) {
                    if(max < map.get(s)) {
                        max = map.get(s);
                    }
                }
            }
            for(String s : map.keySet()) {
                if(s.length() == length) {
                    if(map.get(s) == max) {
                        list.add(s);
                    }
                }
                
            }
        }
        Collections.sort(list);
        
        return list.toArray(new String[list.size()]);
    }
    public void combi(int depth, int length, String menu, int index, String[] orders) {
        if(depth == length) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<menu.length(); i++) {
                if(visited[i]) {
                    sb.append(menu.charAt(i));
                }
            }
            //원하는 길이의 문자열 조합 만들어짐
            //다른 메뉴들과 비교 -> 어떤 조합이 제일 인기가 많은지
            int result = countSameMenu(sb.toString(), orders);
            if(result < 2) {
                return;
            }
            if(max <= result) {
                max = result;
                maxMenu = sb.toString();
                map.put(maxMenu, result);
            }
            return;
        }
        for(int i=index; i<menu.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                combi(depth + 1, length, menu, index + 1, orders);
                visited[i] = false;
            }
        }
        
    }
    public int countSameMenu(String str, String[] orders) {
        int cnt = 0;
        
        for(int i=0; i<orders.length; i++) {
            boolean isPossible = true;
            for(int j=0; j<str.length(); j++) {
                char c = str.charAt(j);
                if(!orders[i].contains(Character.toString(c))) {
                    isPossible = false;
                }
            }
            if(isPossible) {
                cnt++;
            }
        }
        return cnt;
    }
}