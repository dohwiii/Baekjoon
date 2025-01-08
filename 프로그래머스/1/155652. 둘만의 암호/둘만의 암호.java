class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray()) {
            int idx = 0;
            char temp = c;
            while(idx < index) {
                temp = temp == 'z' ? 'a' : (char) (temp + 1);
                if(!skip.contains(String.valueOf(temp))) {
                    idx++;
                }
            }
            sb.append(temp);
        }
        
        return sb.toString();
    }
}