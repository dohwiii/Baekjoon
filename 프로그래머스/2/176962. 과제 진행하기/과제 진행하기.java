import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        PriorityQueue<Subject> pq = new PriorityQueue<>();
        Stack<Subject> stack = new Stack();
        
        for(String[] plan : plans) {
            String[] t = plan[1].split(":");
            int hour = Integer.parseInt(t[0]);
            int min = Integer.parseInt(t[1]);
            int time = hour * 60 + min;
            pq.offer(new Subject(plan[0], time, Integer.parseInt(plan[2])));
        }
        int index = 0;
        
        while(!pq.isEmpty()) {
            Subject now = pq.poll();
            
            if(!pq.isEmpty()) {
                Subject next = pq.peek();
                int restTime = next.start - now.start;    //다음 과목 시작하기까지 남은 시간
                
                if(now.playtime > restTime) {   //현재 과목을 끝내는 시간이 다음 과목 시작시간 초과
                    stack.push(new Subject(now.name, now.start, now.playtime - restTime));
                }
                else {
                    answer[index++] = now.name; //공부 끝
                    int finish = restTime - now.playtime;   //현재 과목 공부 끝나고 남은시간
                    
                    if(finish > 0) {    //남은 시간이 있다면
                        while(!stack.isEmpty()) {
                            if(finish <= 0) {
                                break;
                            }
                            Subject stop = stack.pop();

                            if(finish >= stop.playtime) {    //남은 시간이 멈춰둔 과목 소요시간보다 길 때
                                answer[index++] = stop.name;
                                finish -= stop.playtime;
                            }
                            else {  //남은 시간에 멈춘 과목 못 끝낼 때
                                stack.push(new Subject(stop.name, stop.start, stop.playtime - finish));
                                break;  //새로운 과목 공부해야함
                            }
                        } 
                    }
                    
                }
            }
            else {
                answer[index++] = now.name;
            }
        }
        while(!stack.isEmpty()) {
            Subject s = stack.pop();
            answer[index++] = s.name;
        }
        
        return answer;
    }
    static class Subject implements Comparable<Subject> {
        String name;
        int start, playtime;
        
        public Subject(String n, int s, int p) {
            this.name=n;
            this.start=s;
            this.playtime=p;
        }
        @Override
        public int compareTo(Subject s) {   //시간 오름차순
            return this.start - s.start;
        }
    }
}