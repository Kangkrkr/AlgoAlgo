package kangkrkr;

// 시저암호
// https://programmers.co.kr/learn/courses/30/lessons/12926
public class Solution11 {

	public static void main(String[] args) {
		Solution11 solution = new Solution11();
		
		String s = "y X Z";
		int n = 4;
		System.out.println(solution.solution(s, n));
		
		// A~Z : 65~90
		// a~z : 97~122
	}

	public String solution(String s, int n) {
        StringBuffer buffer = new StringBuffer();
        for (int i=0; i<s.length(); i++) {
        	if (' ' == s.charAt(i)) {
        		buffer.append(' ');
        		continue;
        	}

        	int charNum = s.charAt(i);
        	if (this.isUpperCase(charNum)) {
        		charNum += n;
        		if (charNum > 'Z') {
        			charNum -= 26;
        		}
        	} else if (this.isLowerCase(charNum)) {
        		charNum += n;
        		if (charNum > 'z') {
        			charNum -= 26;
        		}
        	}
        	
        	char c = (char)(charNum);
        	buffer.append(c);
        }
        
        return buffer.toString();
    }

	private boolean isLowerCase(int charNum) {
		return charNum >= 'a' && charNum <= 'z';
	}

	private boolean isUpperCase(int charNum) {
		return charNum >= 'A' && charNum <= 'Z';
	}
}
