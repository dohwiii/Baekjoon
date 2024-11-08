class Solution {
    public int solution(String s) {
        int answer = 0;
        int minLen = s.length();
        
        for(int size = 1; size <= s.length() / 2; size++) {   //최대 압축 길이까지
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, size);
            int count = 1;
            
            for(int j = size; j < s.length(); j += size) {
                int end = Math.min(j + size, s.length());
                String current = s.substring(j, end);
                
                if(prev.equals(current)) {  //연속된 문자열
                    count++;
                }
                else {  //다르다면
                    if(count > 1) { //이전에 연속한적이 있다면
                        compressed.append(count).append(prev);
                    }
                    else {
                        compressed.append(prev);
                    }
                    prev = current;
                    count = 1;
                }
            }
            if(count > 1) {
                compressed.append(count).append(prev);
            }
            else {
                compressed.append(prev);
            }
            minLen = Math.min(minLen, compressed.length());
        }
        return minLen;
    }
}