class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray()) {
            int skipCnt = 0;
            for(int i = 1; i <= index; i++) {
                char n = nextChar(c, i);
                if(skip.indexOf(n) != -1) { //skip에 해당되는 알파벳
                    skipCnt++;
                }
            }
            char next = nextChar(c, index);
            // System.out.println(next + " "+skipCnt);
            if(skipCnt > 0) {
                next = nextChar(next, 1);
            }
            while(skipCnt > 0) {
                if(skip.indexOf(next) == -1) { //skip에 포함되지 않을 때
                    skipCnt--;
                    if(skipCnt == 0) {
                        break;
                    }
                }
                next = nextChar(next, 1);

            }
            sb.append(next);
        }
        
        return sb.toString();
    }
    public char nextChar(char currentChar, int plus) {
        return (char) (((currentChar - 'a' + plus) % 26) + 'a');
    }
}