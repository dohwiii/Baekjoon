import java.util.*;

// 최소한의 객실 사용
// 한번 사용한 객실은 퇴실 시간 기준 10분간 청소 후 사용가능
// 끝나는 시간 기준으로 오름차순 정렬

class Solution {
    static Customer[] customers;
    static int roomCnt = 0;
    
    public int solution(String[][] book_time) {
        int answer = 0;
        
        customers = new Customer[book_time.length];
        for(int i=0; i<book_time.length; i++) {
            String[] in = book_time[i][0].split(":");
            String[] out = book_time[i][1].split(":");
            int inTime = Integer.parseInt(in[0])*60 + Integer.parseInt(in[1]);
            int outTime = Integer.parseInt(out[0])*60 + Integer.parseInt(out[1]);
            customers[i] = new Customer(inTime, outTime);
        }
        Arrays.sort(customers);
        Hotel(book_time);

        // 최소 객실의 수
        return roomCnt;
    }
    private static void Hotel(String[][] book_time) {
        PriorityQueue<Room> pq = new PriorityQueue<>();

        for(int i=0; i<customers.length; i++) {
            Customer now = customers[i];
            
            if(!pq.isEmpty()) {
                Room r = pq.peek();
                if(r.time <= now.inTime) {  // 기존 방
                    pq.poll();
                    pq.offer(new Room(r.num, now.outTime + 10));
                }
                else {  // 새로운 방
                    roomCnt++;
                    pq.offer(new Room(roomCnt, now.outTime + 10));
                }
            }
            else {  // 최초 방
                roomCnt++;
                pq.offer(new Room(roomCnt, now.outTime + 10));
            }
        }
    }
    
    static class Room implements Comparable<Room> {
        int num, time;  // 호텔 객실

        public Room(int num, int time) {
            this.num=num;
            this.time=time;
        }
        
        @Override
        public int compareTo(Room r) {
            return this.time - r.time;
        }
    }
    static class Customer implements Comparable<Customer> {
        int inTime, outTime;
        
        public Customer(int inTime, int outTime) {
            this.inTime=inTime;
            this.outTime=outTime;
        }
        @Override
        public int compareTo(Customer c) {
            return this.inTime - c.inTime;
        }
    }
}