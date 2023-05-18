import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Solution {
    public String[] solution(String[][] plans) throws ParseException{
        StringBuilder sb = new StringBuilder();
        
        PriorityQueue<Plan> queue = new PriorityQueue();        
        Stack<Plan> waitingStack = new Stack<>();

        for(int i=0; i<plans.length; i++)
        {
            String[] str = plans[i][1].split(":");
            int hour = Integer.parseInt(str[0]);
            int min = Integer.parseInt(str[1]);
            queue.add(new Plan(plans[i][0], hour*60+min, Integer.parseInt(plans[i][2])));
        }
        while (!queue.isEmpty()) {
            Plan now = queue.poll();
            int curTime = now.time;
            
            if (!queue.isEmpty()) {
                Plan next = queue.peek();

                if (now.time + now.leadTime < next.time) {
                    curTime += now.leadTime;
                    sb.append(now.subject + " ");
                    
                    while (!waitingStack.isEmpty()) {
                        Plan wait = waitingStack.pop();
                        if (curTime + wait.leadTime <= next.time) {
                            curTime += wait.leadTime;
                            sb.append(wait.subject + " ");
                            continue;
                        } 
                        else { //제시간에 못끝낸 경우
                            wait.leadTime = wait.leadTime - (next.time - curTime);
                            waitingStack.push(new Plan(wait.subject, wait.time, wait.leadTime));
                            break;
                        }
                    }
                } else if (now.time + now.leadTime == next.time) {
                    sb.append(now.subject + " ");
                    continue;
                } 
                else if (now.time + now.leadTime > next.time) {
                    now.leadTime = now.leadTime - (next.time - now.time);
                    waitingStack.add(new Plan(now.subject, now.time, now.leadTime));
                }
            }
            else //마지막 순번
            {
                sb.append(now.subject + " ");
            }
        }
        while (!waitingStack.isEmpty()) {
            Plan out = waitingStack.pop();
            sb.append(out.subject+" ");
        }
        String result = sb.toString();
        String[] answer = result.split(" ");
        return answer;
    }
}
class Plan implements Comparable<Plan>{
    String subject;
    int time;
    int leadTime;
    
    @Override
    public int compareTo(Plan o) {
        return this.time - o.time;
    }
    
    public Plan(String subject, int time, int leadTime) {
        this.subject = subject;
        this.time = time;
        this.leadTime = leadTime;
    }
}