package programers;

import java.util.ArrayList;

public class Country124 {
	public static void main(String[] args) {
//		for(int n = 1; n <= 30; n++) {
//			System.out.println(solution(n));
//		}
		
		System.out.println(solution(6));
	}
	
	// 예를 들어서 7이라는 숫자가 있다면 n = 7 이라면
	// n / 3 = 2,  n % 3 = 1
	//           21
	
	// 예를 들어 n = 6 이다.
	// n / 3 = 2, n % 3 = 0
	// 나머지가 0 일때는 무조건 2번지 값으로
	// 그리고 0 일때는 앞에있는 몫을 -1
	// n / 3 = 2 --> 1
	// n % 3 = 0 --> 2
	// 14
	
	public static String solution(int n) {
		String answer = "";
		int share = 0; // 몫
		String last = ""; // 마지막
		
		ArrayList<String> country124 = new ArrayList<String>();
		country124.add("1");
		country124.add("2");
		country124.add("4");
		
		// 몫이 3보다 작을 때까지 나눌 때 나오는 나머지를 담는 Array
		ArrayList<Integer> buff = new ArrayList<Integer>();
		
		// 몫이 0일 경우 즉, (1, 2) 일 경우
		if(n / 3 == 0){
			answer = country124.get(n % 3 - 1);
			return answer;
		} else { // 몫이 1 이상일 경우, 3 이상의 수
			// 나머지가 0 일경우
			if(n % 3 == 0) {
				last = country124.get(2);
				share = n / 3 - 1;
			} else { // 나머지가 0이 아닐 경우
				last = country124.get(n % 3 - 1);
				share = n / 3;
			}
			
			// 몫이 3보다 클 경우 3보다 작을 때까지 나누기
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
		
		// 몫이 0이 아닐경우에만
		if(share != 0) {
			answer = country124.get(share - 1);
		}
		
		// 몫이 3 이상일 때 담았던 나머지들
		for(int i = buff.size() - 1; i >= 0; i--) {
			answer += country124.get(buff.get(i) - 1);
		}
		
		// 최초 나눴을 때 나머지
		answer += last;
		
		return answer;
	}
}
