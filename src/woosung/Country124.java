package woosung;

import java.util.ArrayList;

public class Country124 {
	public static void main(String[] args) {
//		for(int n = 1; n <= 30; n++) {
//			System.out.println(solution(n));
//		}
		
		System.out.println(solution(6));
	}
	
	public static String solution(int n) {
		String answer = "";
		int share = 0;
		String last = "";
		
		ArrayList<String> country124 = new ArrayList<String>();
		country124.add("1");
		country124.add("2");
		country124.add("4");
		
		ArrayList<Integer> buff = new ArrayList<Integer>();
		
		if(n / 3 == 0){
			answer = country124.get(n % 3 - 1);
			return answer;
		} else {
			if(n % 3 == 0) {
				last = country124.get(2);
				share = n / 3 - 1;
			} else {
				last = country124.get(n % 3 - 1);
				share = n / 3;
			}
			
			while(share > 3) {
				if(share % 3 == 0) {
					share = share / 3 - 1;
					buff.add(3);
				} else {
					buff.add(share % 3);
					share = share / 3;
				}
			}
		}
		
		if(share != 0) {
			answer = country124.get(share - 1);
		}
		
		for(int i = buff.size() - 1; i >= 0; i--) {
			answer += country124.get(buff.get(i) - 1);
		}
		
		answer += last;
		
		return answer;
	}
}
