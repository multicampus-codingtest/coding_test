package eunbi.week02;

import java.util.*;

public class 골드바흐파티션 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = 1000000;
		boolean[] prime = new boolean[size+1];
		int t = sc.nextInt(); 
		
		prime[0] = true; // 소수가 아니면 true, 소수면 false
		prime[1] = true;

		// 에라토스테네스의 체
		for(int i=2; i*i<=size; i++){
            if(!prime[i]){           	
            	for(int j=i*i; j<=size; j+=i) 
            		prime[j] = true;                
            }
        }  
		

		for (int i = 0; i < t; i++) { // 테스트케이스
			int n = sc.nextInt();
			int answer = 0;
			for(int j=2; j<=n/2; j++) {
				if(!prime[j] && !prime[n-j]) { // 둘다 소수면
					answer++;
				}
			}
			System.out.println(answer);
		}
	}
}