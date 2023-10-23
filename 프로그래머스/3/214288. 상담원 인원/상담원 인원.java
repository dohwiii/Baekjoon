import java.util.*;

class Solution {
    public int solution(int k, int n, int[][] reqs) {
        int answer = 0;
        int[] counselorsCnt = new int[k+1];
        List<Time>[] list = new List[k+1];
        int[][] waitTimePerType = new int[k+1][n+1]; //타입별로 기다려야하는 시간
        
        for(int i=0; i<=k; i++)
        {
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<reqs.length; i++)
        {
            int[] arr = reqs[i];
            list[arr[2]].add(new Time((i+1), arr[0], arr[0] + arr[1]));
        }
        for(int type=1; type<=k; type++)
        {
            if(list[type].size() == 0)
                continue;
            
            for(int counselors = 1; counselors <= n-k+1; counselors++)
            {
                int waitTime = calcTime(list[type], counselors);
                waitTimePerType[type][counselors] = waitTime;
            }
        }
        
        for(int type=1; type<=k; type++)
        {
            counselorsCnt[type] = 1;
        }
        
        int remainCounselor = n - k; //남은 멘토의 수(각 유형에 한명씩 배정)
        
        while(remainCounselor-- > 0)
        {
            int maxReduceTime = 0; //가장 많이 줄어드는 시간
            int maxReduceType = 0; //가장 많이 줄어드는 시간의 타입
            
            for(int type = 1; type <= k; type++)
            {
                int currentCounselorCnt = counselorsCnt[type]; //현재 상담원 수
                //현재 상담원 수의 대기시간
                int waitTimeOfCurrentCountselor = waitTimePerType[type][currentCounselorCnt];
                //상담원이 한명 더 늘었을 때의 대기시간
                int next = waitTimePerType[type][currentCounselorCnt+1];
                //인원 추가 됐을 때 줄어드는 시간
                int reduceWaitTime = Math.abs(next - waitTimeOfCurrentCountselor);
                
                if(reduceWaitTime >= maxReduceTime)
                {
                    maxReduceTime = reduceWaitTime;
                    maxReduceType = type;
                }
            }
            if(maxReduceTime == 0)
            {
                break;
            }
            counselorsCnt[maxReduceType]++;
        }
        for(int type = 1; type <= k; type++)
        {
            if(list[type].size() == 0)
                continue;
            int counselors = counselorsCnt[type];
            answer += waitTimePerType[type][counselors];
        }
        return answer;
    }
    
    public int calcTime(List<Time> typeTime, int counselor)
    {
        int waitTime = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //끝나는 시간
        
        for(Time t : typeTime)
        {
            //상담원 수가 남아있을 때
            if(pq.isEmpty() || pq.size() < counselor)
            {
                pq.add(t.end);
            }
            else {
                int earlyEndTime = pq.poll(); //제일 빨리 끝나는 상담 시간
                
                if(t.start < earlyEndTime) //대기시간 있는 경우
                {
                    waitTime += (earlyEndTime - t.start); //대기시간
                    pq.add(earlyEndTime + (t.end - t.start));
                }
                else { //대기시간 없는 경우
                    pq.add(t.end);
                }
            }
        }
        
        return waitTime;
    }
}
class Time{
    int num, start, end;
    
    public Time(int num, int start, int end)
    {
        this.num = num;
        this.start = start;
        this.end = end;
    }
}