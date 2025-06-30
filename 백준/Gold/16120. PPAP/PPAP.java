import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int cntP = 0;
        boolean isPreA = false;

        for (char c : str.toCharArray()) {
            if (c == 'P') {
                cntP++;
                if (isPreA) {
                    cntP -= 2;
                    isPreA = false;
                }
            }
            else if (c == 'A') {
                if (cntP > 1 && !isPreA) {
                    isPreA = true;
                }
                else {
                    System.out.println("NP");
                    return;
                }
            }
        }
        System.out.println(cntP == 1 ? "PPAP" : "NP");


    }

}