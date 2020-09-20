package woosung;

import java.util.Arrays;

public class Carpet {

	public static void main(String[] args) {
		int brown1 = 10;
		int yellow1 = 2;
		
		int brown2 = 8;
		int yellow2 = 1;
		
		int brown3 = 24;
		int yellow3 = 24;
		
		System.out.println(Arrays.toString(solution(brown1, yellow1)));
		System.out.println(Arrays.toString(solution(brown2, yellow2)));
		System.out.println(Arrays.toString(solution(brown3, yellow3)));
	}
	
	public static int[] solution(int brown, int yellow) {
		int[] answer = {};
		answer = new int[2];
		
		int area = brown + yellow; // 넓이
		
		for(int i = 3; i <= area; i++) {
			if(area % i == 0) {
				int brownTransverse = area / i; // 갈색 가로
				int brownLength = area / brownTransverse; // 갈색 세로
				
				int yellowTransverse = brownTransverse - 2; // 노랑 가로
				int yellowLength = brownLength - 2; // 노랑 세로
				
				if(yellowTransverse * yellowLength == yellow) {
					answer[0] = brownTransverse;
					answer[1] = brownLength;
					break;
				}
			}
		}
		
		return answer;
	}

}
