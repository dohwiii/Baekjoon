import java.util.*;

class Solution {
    static int[] percent = {10, 20, 30, 40};
    static List<Result> resultList;
    static PriorityQueue<Result> pq = new PriorityQueue<>();
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        resultList = new ArrayList<>();
        int[] selected = new int[emoticons.length];  // 선택된 할인율을 저장할 배열

        combi(0, selected, users, emoticons);
        
        if (!pq.isEmpty()) {  // 큐가 비어있는지 확인
            Result r = pq.poll();
            answer = new int[]{r.subscribers, r.totalSales};
        } else {
            answer = new int[]{0, 0}; // 예외 처리 (큐가 비어있는 경우)
        }
        return answer;
    }
    public static void combi(int depth, int[] selected, int[][] users, int[] emoticons) {
        if(depth == selected.length) {  //모든 이모티콘 할인율 뽑았다면
            Sale[] discountedPrice = calculatePrice(selected, emoticons);    //할인율에 대해 계산
            buyEmoticons(discountedPrice, users);
            return;
        }
        for(int i=0; i<4; i++) {
            selected[depth] = percent[i];
            combi(depth + 1, selected, users, emoticons);
        }
    }
    public static Sale[] calculatePrice(int[] discount, int[] emoticons) {
        Sale[] price = new Sale[emoticons.length];
        
        for(int i=0; i<emoticons.length; i++) {
            price[i] = new Sale(discount[i], (int) (emoticons[i] * (100 - discount[i]) / 100.0));
        }
        return price;
    }
    public static void buyEmoticons(Sale[] price, int[][] users) {
        int subscribers = 0;
        int totalSales = 0;
        
        for(int[] user : users) {
            int discountRate = user[0];
            int standard = user[1];
            int totalPrice = 0;
            
            for(Sale p : price) {
                if(discountRate <= p.percent) { 
                    totalPrice += p.price;  //이모티콘 구매
                }
            }

            if(totalPrice >= standard) {    //기준 이상 -> 이모티콘 플러스 구매자
                subscribers++;  //가입자
            }
            else {  //이모티콘 플러스 구매액보다 적을 때 -> 매출액
                totalSales += totalPrice;
            }
        }

        pq.offer(new Result(subscribers, totalSales));
    }
    
    static class Sale {
        int percent, price;
        public Sale(int percent, int price) {
            this.percent=percent;
            this.price=price;
        }
    }
    static class Result implements Comparable<Result> {
        int subscribers, totalSales;   //가입자수, 매출액
        public Result(int subscribers, int totalSales) {
            this.subscribers = subscribers;
            this.totalSales = totalSales;
        }
        @Override
        public int compareTo(Result r) {
            if(this.subscribers == r.subscribers) {
                return r.totalSales - this.totalSales;
            }
            return r.subscribers - this.subscribers;
        }
    }
}