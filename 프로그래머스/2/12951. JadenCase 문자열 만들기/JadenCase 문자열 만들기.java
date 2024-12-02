class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        boolean isFirstChar = true;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if(c == ' ') {
                sb.append(" ");
                isFirstChar = true;
            }
            else {  //공백이 아니라면
                if(isFirstChar) {   //첫글자라면
                    sb.append(Character.toUpperCase(c));
                    isFirstChar = false;
                }
                else {  //첫글자 이후 글자
                    sb.append(Character.toLowerCase(c));
                }
            }
        }
        
        
        return sb.toString();
    }
}