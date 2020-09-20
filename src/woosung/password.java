package woosung;

public class password {

	public static void main(String[] args) {
		String s = "AB";

		System.out.println(solution(s, 1));
	}
	
	public static String solution(String s, int n) {
		String answer= "";
		
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (Character.isLowerCase(ch)) {
				ch = (char) ((ch + n % 26 - 'a') % 26 + 'a');
			} else if (Character.isUpperCase(ch)) {
				ch = (char) ((ch + n % 26 - 'A') % 26 + 'A');
			}

			answer += ch;
		}
		
		return answer;
	}

}
