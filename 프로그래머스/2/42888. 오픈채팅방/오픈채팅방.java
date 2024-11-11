import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String> recordList = new ArrayList<>();
        
        for(String re : record) {
            String[] splitArr = re.split(" ");
            String type = splitArr[0];
            String userId = splitArr[1];
            
            //들어오고 나가는 기록 저장
            if(type.equals("Leave")) {
                recordList.add("2"+userId);
                continue;
            } 
            else {  //Enter, Change
                if(type.equals("Enter")) {
                    recordList.add("1"+userId);
                }
                String nickname = splitArr[2];
                map.put(userId, nickname);
            }
            
        }
        String[] answer = new String[recordList.size()];
        int index = 0;
        
        for(String userId : recordList) {
            char type = userId.charAt(0);
            String nickname = map.get(userId.substring(1, userId.length()));

            if(type == '1') {
                answer[index++] = nickname+"님이 들어왔습니다.";
            }
            else {
                answer[index++] = nickname+"님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}