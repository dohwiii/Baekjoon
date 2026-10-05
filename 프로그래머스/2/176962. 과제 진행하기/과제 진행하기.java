import java.util.*;

// 우선순위
// 1. 해당 시간에 시작해야하는 과제
// 2. 멈춘과제 (가장 최근에 멈춘 과제부터 시작)
// plans
class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = {};
        Stack<Subject> stack = new Stack<>();    // 멈춘 과제 저장용
        Subject[] plan = new Subject[plans.length];

        for(int i=0; i<plans.length; i++) {
            String[] t = plans[i][1].split(":");
            int time = Integer.parseInt(t[0])*60 + Integer.parseInt(t[1]);
            plan[i] = new Subject(plans[i][0], time, Integer.parseInt(plans[i][2]));
        }
        Arrays.sort(plan); // 시작시간 오름차순 정렬
        List<String> answerList = new ArrayList<>();
        
        for(int i=0; i<plan.length; i++) {
            String subject = plan[i].subject;
            int startTime = plan[i].time;
            int playTime = plan[i].playTime;    
            int endTime = startTime + playTime;
            
            if(i == plan.length - 1) {  // 마지막 과목
                answerList.add(subject);    // 마지막 과목은 다 끝낸 뒤 못끝낸 과목 시작
            }
            else {
                if(endTime > plan[i+1].time) { // 다음 과목의 시작시간을 넘어간다면
                    int leftTime = playTime - (plan[i+1].time - startTime); // 잔여시간
                    stack.push(new Subject(subject, leftTime, playTime));
                }
                else {  // 다음과목 시작시간 전까지 끝낼 수 있다면 -> 남은시간
                    answerList.add(subject);
                    int leftTime = plan[i+1].time - endTime; // 잔여시간
                    if(leftTime == 0) {
                        continue;
                    }
                    while(!stack.isEmpty()) {
                        if(leftTime < stack.peek().time) {  // 잔여시간이 남은시간보다 모자르다면
                            Subject s = stack.pop();
                            stack.push(new Subject(s.subject, s.time - leftTime, s.playTime));
                            break;
                        }
                        leftTime -= stack.peek().time;  // 잔여시간 빼기
                        answerList.add(stack.peek().subject);
                        stack.pop();
                    }
                }
            }
             
//             for(Subject a : stack) {
//                 System.out.println(a.subject+" "+a.time);
//             }
        }
        while(!stack.isEmpty()) {
            Subject s = stack.pop();
            answerList.add(s.subject);
        }
        answer = new String[answerList.size()];
        int i= 0;
        for(String s : answerList) {
            answer[i++] = s;
        }

        // 과제를 끝낸 순서대로 이름
        return answer;
    }
    static class Subject implements Comparable<Subject> {
        String subject;
        int time, playTime;
        
        public Subject(String subject, int time, int playTime) {
            this.subject=subject;
            this.time=time;
            this.playTime=playTime;
        }
        
        @Override
        public int compareTo(Subject s) {
            return this.time - s.time;
        }
    }
}