import java.util.*;

// 기본시간 이하 -> 기본시간
// 단위시간 올림
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        Map<String, Integer> inMap = new HashMap<>(); // <차량번호, 입차시간>
        Map<String, Integer> payout = new HashMap<>(); // <차량번호, 머문시간> 
        
        for(String r : records) {
            String[] s = r.split(" ");
            String[] t = s[0].split(":");
            int hour = Integer.parseInt(t[0]);
            int min = Integer.parseInt(t[1]);
            int time = hour * 60 + min;
            String car = s[1];
            String history = s[2];  // IN or OUT
            
            // 입차 -> inMap 넣기
            if(history.equals("IN")) {
                inMap.put(car, time);
                
            }
            else {  // 출차 -> 계산
                int inTime = inMap.get(car);    // 입차시간
                int retention = time - inTime;
                
                if(payout.containsKey(car)) {   // 재출입
                    int original = payout.get(car);
                    payout.put(car, original + retention);
                }
                else {
                    payout.put(car, retention);
                }
                inMap.remove(car);
            }
            
            
        }
        // 아직 출차 못한 차들
        for(String car : inMap.keySet()) {
            int outTime = 23 * 60 + 59;
            int inTime = inMap.get(car);
            int retention = outTime - inTime;

            if(payout.containsKey(car)) {   // 재출입
                int original = payout.get(car);
                payout.put(car, original + retention);
            }
            else {
                payout.put(car, retention);
            }
                
        }
        String[] cars = new String[payout.size()];
        answer = new int[payout.size()];
        int index = 0;
        for(String car : payout.keySet()) {
            cars[index++] = car;
        }
        Arrays.sort(cars);   // 차량번호 오름차순

        for(int i=0; i<cars.length; i++) {
            String car = cars[i];
            int retention = payout.get(car);
            int money = 0;
            money += fees[1];   // 기본시간

            if(retention > fees[0]) {  // 기본시간 초과
                retention -= fees[0];   // 기본시간 제외
                int overTime = (int) Math.ceil((double) retention / fees[2]);
                money += overTime * fees[3];
            }
            answer[i] = money;
   
        }

        // 차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열에 담아서 return 
        return answer;
    }
}