import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> userMap = new HashMap<>();
        List<String[]> messageList = new ArrayList<>();
        
        // 유저 정보 업데이트와 메시지 기록 저장
        for (String re : record) {
            String[] splitArr = re.split(" ");
            String action = splitArr[0];
            String userId = splitArr[1];
            
            if (action.equals("Enter")) {
                userMap.put(userId, splitArr[2]);
                messageList.add(new String[] { userId, "님이 들어왔습니다." });
            } else if (action.equals("Leave")) {
                messageList.add(new String[] { userId, "님이 나갔습니다." });
            } else if (action.equals("Change")) {
                userMap.put(userId, splitArr[2]);
            }
        }
        
        // 최종 메시지 생성
        String[] answer = new String[messageList.size()];
        int index = 0;
        for (String[] msg : messageList) {
            String userId = msg[0];
            String message = userMap.get(userId) + msg[1];
            answer[index++] = message;
        }
        
        return answer;
    }
}