package victor;

import java.util.Arrays;

public class AlgorithmStudy20200815 {

	public static void main(String[] args) {
		
		int test = 12915;
		
		switch (test) {
			case 12948:
				//핸드폰 번호 가리기
				//String phone_number = "01033334444";
				String phone_number = "027778888";
				String answer12948 = solution(phone_number);
				System.out.println(answer12948);
				break;
				
			case 12915:
				//문자열 내 마음대로 정렬하기
				String[] strings = {"sun", "bed", "car"};
				int n = 1;
				String[] answer12915 = solution(strings, n);
				System.out.println(answer12915);
				break;
			default:
				break;
		}

	}

	private static String solution(String phone_number) {
		String answer = "";
		
		int len = phone_number.length();
		String tmpStr = "";
		
		for (int i = 0; i < len-4; i++) {
			tmpStr += "*";
		}
		answer = tmpStr.concat(phone_number.substring(len-4, len));
		
        return answer;
	}
	
	private static String[] solution(String[] strings, int n) {
		String[] answer = {};
		
		String[] newStrings = new String[strings.length];
		
		int i = 0;
		for (String string : strings) {
			newStrings[i] = String.valueOf(string.charAt(n)).concat(string);
			i++;
		}
		
		Arrays.sort(newStrings);
		
		int j = 0;
		answer = new String[strings.length];
		for (String string : newStrings) {
			answer[j] = string.substring(1);
			j++;
		}
		
        return answer;
	}

}
