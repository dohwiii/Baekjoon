import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String S = st.nextToken();   //개강총회 시작
        String E = st.nextToken(); //개강총회 끝
        String Q = st.nextToken();  //스트리밍 끝
        String[] sa = S.split(":");
        String[] ea = E.split(":");
        String[] q = Q.split(":");
        long start = Integer.parseInt(sa[0]) * 60 + Integer.parseInt(sa[1]);
        long end = Integer.parseInt(ea[0]) * 60 + Integer.parseInt(ea[1]);
        long streamingEnd = Integer.parseInt(q[0]) * 60 + Integer.parseInt(q[1]);
        Set<String> enterSet = new HashSet<>();
        int cnt = 0;
        String line;

        while ((line = br.readLine()) != null) {
            if (line.isEmpty()) {
                break;
            }
            int h = (line.charAt(0) - '0') * 10 + (line.charAt(1) - '0');
            int m = (line.charAt(3) - '0') * 10 + (line.charAt(4) - '0');
            String nickname = line.substring(6);
            long time = h * 60 + m;

            if (time <= start) {    //시작시간까지 채팅을 쳤다면
                enterSet.add(nickname);
            }
            if (time >= end && time <= streamingEnd) {  //개총 끝나고 스티리밍 끝나기 전까지 채팅 친 사람
                if (enterSet.contains(nickname)) {  //입장 체크가 됐다면
                    cnt++;
                    enterSet.remove(nickname);
                }
            }
        }
        System.out.println(cnt);











    }
}