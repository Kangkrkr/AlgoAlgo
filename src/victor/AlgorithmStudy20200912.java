package victor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AlgorithmStudy20200912 {

	public static void main(String[] args) {
		
		int problem = 42842;
		
		switch (problem) {
		//문자열 압축
		case 60057:
			String s = "aabbaccc";
			int answer60057 = solution(s);
			System.out.println(answer60057);
			break;
		//카펫
		case 42842:
			int brown = 24;
			int yellow = 24;
			int[] answer42842 = solution(brown, yellow);
			System.out.println(answer42842);
			break;
		//소수 찾기
		case 42839:
			String numbers = "17";
			int answer42839 = solution2(numbers);
			System.out.println(answer42839);
		default:
			break;
		}

	}

	private static int solution(String s) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int totalTile = brown + yellow;
        //12
        //(1,2,3,4,6,12)
        //가로의길이>=세로길이
        
        //i가 3인 이유 ? 노란색 타일이 최소 1개 기준일때 실제 타일의 가로길이는 3부터 시작하기 때문
        for(int i=3; i<=totalTile; i++){
            // ��� ��� ���ϱ�
            if(totalTile % i == 0){
                int row = totalTile / i;    // 가로
                int col = totalTile / row;  // 세로

                int yRow = row - 2;    // yellow 격자의 가로
                int yCol = col - 2;    // yellow 격자의 세로
                if(yRow * yCol == yellow && row >= col){
                    answer[0] = row;
                    answer[1] = col;
                    break;
                }
            }
        }
        
        return answer;
    }
	
	private static int solution2(String numbers) {
		// 리스트에 담아줌
		char[] list = numbers.toCharArray();
        int[] makeNumFrom = new int[list.length];
        for (int i = 0; i < list.length; i++) {
        	//숫자를 만들기 위한 요소들 넣기
            makeNumFrom[i] = Integer.parseInt(String.valueOf(list[i]));
        }
		
        //만들어지는 수들  중 중복제거용  set
        Set<Integer> makeNumTo = new HashSet<>();
		
        return makeNumTo.size();
	}
	
	private static boolean checkPrime(String s) {
		
		int num = Integer.parseInt(s);
		boolean isPrime = false;
		
		for (int i = 2; i < num; i++) {
			// 1과 num 자신 외에 나누어지는 수가 있는지 검사할 조건문
            if (num % i == 0) {
            	// 나누어지는 수가 있을 경우 isPrime의 값을 true로 바꾼다.
                isPrime = true;
                // 한 번이라도 이 조건문이 실행될 경우 num은 소수가 아니므로 반복문을 빠져나온다.
                break;
            }
        }

		return isPrime;
	}
}
