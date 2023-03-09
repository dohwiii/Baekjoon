class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int diff = 0;
        int div = 0;
        int length = common.length - 1;
        
        for(int i=length; i>0; i--)
        {
            if(common[i]!=0 && common[i-1]!=0)
            {
                diff = common[i] - common[i-1];
                div = common[i] / common[i-1];
                
            }
        }
        if(common[length] - common[length-1] == diff)
        {
            answer = common[length] + diff;
        }
        else if(common[length] / common[length-1] == div)
        {
            answer = common[length] * div;
        }
        return answer;
    }
}