import java.util.*;

class Solution {
    static Map<Integer, Integer> parking = new HashMap<>();
    static Map<Integer, Integer> fee = new HashMap<>();
    
    public int[] solution(int[] fees, String[] records) {
        List<Integer> list = new ArrayList<>();
        fee = new TreeMap<>();
        
        for(int i=0; i<records.length; i++) {
            String[] record = records[i].split(" ");
            int time = toMinutes(record[0]);    //시각
            int carNumber = Integer.parseInt(record[1]);   //차량번호
            String history = record[2]; //IN or OUT
            
            if(history.equals("IN")) {  //입차
                parking.put(carNumber, time);
            }
            else {  //출차
                int inTime = parking.get(carNumber); //입차 시간
                int totalTime = time - inTime;
                fee.put(carNumber, fee.getOrDefault(carNumber, 0) + totalTime);    //요금 더하기
                parking.remove(carNumber);  //출차함
            }
        }
        //23:59분에 출차한 차량
        for(int carNumber : parking.keySet()) {
            int inTime = parking.get(carNumber);
            int result = 1439 - inTime;
            fee.put(carNumber, fee.getOrDefault(carNumber, 0) + result);    //요금 더하기
        }
        
        int basicMin = fees[0]; //기본 시간(분)
        int basicFee = fees[1]; //기본 요금
        int unitMin = fees[2];  //단위 시간(분)
        int unitFee = fees[3];  //단위 요금
        int[] answer = new int[fee.size()];
        int index = 0;
        
        for(int carNumber : fee.keySet()) {
            int totalTime = fee.get(carNumber);
            answer[index++] = calculateFee(totalTime, basicMin, basicFee, unitMin, unitFee);
        }
        
        return answer;
    }
    public int calculateFee(int totalTime, int basicMin, int basicFee, int unitMin, int unitFee) {
        if(totalTime > basicMin) {
            return basicFee + (int) Math.ceil((totalTime - basicMin) / (double) unitMin) * unitFee;
        }
        return basicFee;
    }
    public int toMinutes(String time) {
        String[] splitTime = time.split(":");
        return Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
    }
}