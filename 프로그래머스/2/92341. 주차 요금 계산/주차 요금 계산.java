import java.util.*;

class Solution {
    static Map<Integer, String> parking = new HashMap<>();
    static Map<Integer, Integer> fee = new HashMap<>();
    
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        fee = new TreeMap<>();
        
        for(int i=0; i<records.length; i++) {
            String[] record = records[i].split(" ");
            String time = record[0];    //시각
            int carNumber = Integer.parseInt(record[1]);   //차량번호
            String history = record[2]; //IN or OUT
            
            if(history.equals("IN")) {  //입차
                parking.put(carNumber, time);
            }
            else {  //출차
                String inTime = parking.get(carNumber); //입차 시간
                int result = calcFee(inTime, time);  //요금 계산
                fee.put(carNumber, fee.getOrDefault(carNumber, 0) + result);    //요금 더하기
                parking.remove(carNumber);  //출차함
            }
        }
        //23:59분에 출차한 차량
        for(int carNumber : parking.keySet()) {
            String inTime = parking.get(carNumber);
            int result = calcFee(inTime, "23:59");
            fee.put(carNumber, fee.getOrDefault(carNumber, 0) + result);    //요금 더하기
        }
        
        int basicMin = fees[0]; //기본 시간(분)
        int basicFee = fees[1]; //기본 요금
        int unitMin = fees[2];  //단위 시간(분)
        int unitFee = fees[3];  //단위 요금
        
        for(int carNumber : fee.keySet()) {
            int money = 0;
            int time = fee.get(carNumber);
            if(time > basicMin) {   //기본시간 초과
                int diff = time - basicMin; //초과 시간
                int overtime = (int) Math.ceil(diff / (double) unitMin);  //올림
                money += basicFee + (overtime * unitFee);  //기본시간 + 초과시간
            }
            else {  //기본시간 이하
                money += basicFee; //기본 요금
            }
            list.add(money);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
    public int calcFee(String inTime, String outTime) {
        String[] inTemp = inTime.split(":");
        int in = Integer.parseInt(inTemp[0]) * 60 + Integer.parseInt(inTemp[1]);
        
        String[] outTemp = outTime.split(":");
        int out = Integer.parseInt(outTemp[0]) * 60 + Integer.parseInt(outTemp[1]);
        
        int diff = out - in;    //시간차
        return diff;
    }
}