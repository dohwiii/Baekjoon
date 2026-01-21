import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
 
    	
    	// 2839. 설탕배달
    	// N <= 5,000
    	// while문과 for문을 중첩시킨다면 while문이 for문의 조건식 횟수를 n번 반복하기에 O(N*M)이 된다. 
    	BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

    	int N = Integer.parseInt(br.readLine());
    	
    	int count = 0;
    	
    	while( true ) {
    		
    		if(N%5==0) {
    			count += N/5;
    			System.out.println(count);
    			break;
    		}else{
    			N-=3;
    			count++;
    		}
    		
    		if(N<0) {
    			System.out.println(-1);
    			break;
    		}
    	}
    	
    	
    }}	
	
	