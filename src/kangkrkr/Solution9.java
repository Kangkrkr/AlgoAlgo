package kangkrkr;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

// 문자열 압축
// https://programmers.co.kr/learn/courses/30/lessons/60057
public class Solution9 {

	public static final String DOT = Pattern.quote(".");
	
	public static void main(String[] args) {
		Solution9 solution = new Solution9();
		
		String testCase = "aabbaccc";
		System.out.println(solution.solution(testCase));
	}

	public int solution(String s) {
        
		// 모든 경우의 수 (자를 범위)에 대한 결과집합을 담을 리스트
		List<Integer> resultList = new ArrayList<>();
		
		for (int i=1; i<=s.length(); i++) {
			// 야매짓 시작..
			String[] temp = new String[2];
			temp[0] = "";
			temp[1] = s;
			resultList.add(recursive(temp, new ArrayList<>(), i));
		}
        return resultList.stream()
        				 .min(Integer::compare)
        				 .get();
    }
	
	// 각 cutSize 에 대해 list에 압축된 결과를 담는 재귀함수
	public int recursive(String[] s, List<String> list, int cutSize) {
		// 더이상 split 처리할 배열의 사이즈가 되지 않는다면, 종료처리
		if (s.length == 1) {
			System.out.println(list);
			String result = list.stream()
							    .map(item -> {
							    	return item;
							    })
							    .reduce((left, right) -> {
							    	return left + right;
							    })
							    .orElse("");
			return result.length();
		}
		
		StringBuffer sb = new StringBuffer(s[1]);
		String origin = sb.toString();
		
		// 문자를 max index가 넘지 않게 적절히 자를 범위를 지정한다.
		int startIndex = origin.length() >= cutSize ? cutSize : origin.length();
		String cur = origin.substring(0, startIndex);
		
		for (int i=startIndex; i<origin.length(); i+=startIndex) {
			// 문자를 max index가 넘지 않게 적절히 잘라 온다.
			String next = (i + startIndex) > origin.length() ? 
											 origin.substring(i) : 
											 origin.substring(i, i + startIndex);
			
            // 반복되지 않는 포인트에 마킹처리
			if (cur.equals(next) == false) {
				sb.insert(i, ".");
				break;
			}
		}
		int count = 0;
		
		// splited[0] -> 압축대상 문자열 , splited[1] -> 비가공된 문자열 
		String[] splited = sb.toString().split(DOT);
		String toZip = splited[0];
		
		// 몇번이나 압축가능한지 카운트를 계산한다.
		while (toZip.length() > 0) {
			toZip = toZip.replaceFirst(cur, "");
			count++;
		}
		
		// 압축 문자열의 unit 추출..
		toZip = splited[0].substring(0, startIndex);
		// count가 1인경우는 count를 붙이지 않도록 한다.
		if (count > 1) {
			toZip = String.valueOf(count).concat(toZip);
		}
		list.add(toZip);
		
		return recursive(splited, list, cutSize);
	}
}
