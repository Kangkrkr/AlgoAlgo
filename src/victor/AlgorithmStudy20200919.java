package victor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AlgorithmStudy20200919 {

	public static void main(String[] args) {
		
		int problem = 12945;
		
		switch (problem) {
		///시저 암호
		case 60057:
			String s = "a B z";
			int n = 4;
			String answer12926 = solution(s,n);
			System.out.println(answer12926);
			break;
		//피보나치 수
		case 12945:
			int k = 1234567891;
			int answer12945 = solution(k);
			System.out.println(answer12945);
			break;
		//�Ҽ� ã��
		default:
			break;
		}
		
	}
	
	private static int solution(int n) {
		int answer = 0;
		
		ArrayList<Integer> fiboList = new ArrayList<>();
		fiboList.add(0);
		fiboList.add(1);
		
		for (int i = 2; i <= n; i++) {
			fiboList.add((fiboList.get(0)+fiboList.get(1)) % 1234567);
			
			fiboList.remove(0);
		}
		
		answer =  fiboList.get(1);
		
        return answer; 
	}

	public static String solution(String s, int n) {
        String answer = "";
        
        char[] arrChar = s.toCharArray();
        
        for (char c : arrChar) {
        	if (Character.isLowerCase(c)) {
				c = (char) ((c + n % 26 - 'a') % 26 + 'a');
			} else if (Character.isUpperCase(c)) {
				c = (char) ((c + n % 26 - 'A') % 26 + 'A');
			}
        	
        	answer += c;
		}
        
        return answer;
    }
	
}
