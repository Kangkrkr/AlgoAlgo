package victor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class AlgorithmStudy20200808 {

	public static void main(String[] args) throws ParseException {
		
		int test = 42840;
		
		switch (test) {
			case 42748:
				//K번째 수
				int[] array = {1, 5, 2, 6, 3, 7, 4};
				int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
				int[] answer42748 = solution(array, commands);
				System.out.println(answer42748);
				break;
				
			case 12901:
				//2016년
				int a = 5;
				int b = 24;
				String answer12901 = solution(a,b);
				System.out.println(answer12901);
				break;
				
			case 42840:
				// 모의고사
				//int[] answers = {1,2,3,4,5};
				//int[] answers = {1,3,2,4,2};
				int[] answers = {1, 4, 3, 1, 2, 5};
				int[] answer42840 = solution(answers);
				System.out.println(answer42840);
				break;
			default:
				break;
		}
		
	}
	
	
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
                
        for (int i = 0; i < commands.length; i++) {
        	// dest = commands의 i번째 배열
            // dest[0] = from, dest[1] = to, dest[2] = findIndex
            // makeAnswer = array복사 후 command에 따라 범위 복사 후 정렬
            int[] dest = commands[i];
            int[] makeAnswer = new int[dest[1]-dest[0]+1];
            makeAnswer = Arrays.copyOfRange(array, dest[0]-1, dest[1]);
            Arrays.sort(makeAnswer);
            answer[i] = makeAnswer[dest[2]-1];
        }
        
        return answer;
    }
	
	public static String solution(int a, int b) throws ParseException {
		
		String[] week = {"SUN","MON","TUE","WED","THU","FRI","SAT" };
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		
		String sA = String.valueOf(a);
		String sB = String.valueOf(b);
		
		if(a < 10) {
			sA = "0"+sA;
		}
		
		if(b < 10) {
			sB = "0"+sB;
		}
		
		Date date = format.parse("2016"+sA+sB);
		
        Calendar cal = Calendar.getInstance() ;
        cal.setTime(date);
        
        int dayNum = cal.get(Calendar.DAY_OF_WEEK) ;
        
        return week[dayNum-1];
	}
	
	public static int[] solution(int[] answers) {
        int[] answer = {};
        
		//1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, ... (n%5)+1 
		//2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, ... 짝수인덱스는 2 홀수인덱스는 2,10,18->1 / 4,12,20->3 / 6,14,22->4 / 8,16,24->5  (inx%8) 1,3,4,5
		//3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...   n%10 = 1,2 -> 3 /  n%10 = 3,4 -> 1 / n%10 = 5,6 -> 2 / n%10 = 7,8 -> 4 / n%10 9,0 -> 5
		//
		//가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
		//
		//answers	return
		//[1,2,3,4,5]	[1]
		//[1,3,2,4,2]	[1,2,3]
        
		int aCnt = 0, bCnt = 0, cCnt = 0;
		int[] no2Case = {1,3,4,5};
		int[] no3Case = {3,1,2,4,5};
		
        for (int n = 0; n < answers.length; n++) {
        	//1�����
			if((n%5) + 1 == answers[n]) {
				aCnt++;
			}
			//2�����
			if((n % 2 == 0 ? 2 : no2Case[(n / 2) % no2Case.length]) == answers[n]) {
				bCnt++;
			}
			//3�����
			if((no3Case[((n / 2) % no3Case.length)]) == answers[n]) {
				cCnt++;
			}
		}
        
        List<Integer> scoreList = new ArrayList<Integer>();
        scoreList.add(aCnt);
        scoreList.add(bCnt);
        scoreList.add(cCnt);
        
        int max = Collections.max(scoreList);
        int idx = 0;
        
        List<Integer> filteredList = scoreList.stream().filter(t->t.intValue() == max).collect(Collectors.toList());
        
        answer = new int[filteredList.size()];
        
        for (int j = 0; j < 3; j++) {
			if(max == scoreList.get(j)) {
				answer[idx] = j+1;
				idx++;
			}
		}
        
        Arrays.sort(answer);
        
        return answer;
    }


}
