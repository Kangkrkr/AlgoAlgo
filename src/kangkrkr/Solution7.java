package kangkrkr;
import java.util.Stack;

// 주식가격
// https://programmers.co.kr/learn/courses/30/lessons/42584
public class Solution7 {

	public static void main(String[] args) {
		
		// 5, 4, 1, 2, 1, 0
		int[] prices = {1, 2, 3, 2, 3, 3};
		Solution7 solution = new Solution7();

		int[] returns = solution.solution(prices);
		StringBuffer sb = new StringBuffer();
		for (int res : returns) {
			sb.append(res);
		}
		System.out.println(sb);
	}

	public int[] solution(int[] prices) {
        int[] answer = {};
        answer = new int[prices.length];
        
        // 스택/큐 문제라길래 스택을 쓰긴 씀 -_-..
        // 문제 입력데이터를 stack 구조로 init..
        Stack<Integer> pricesStack = new Stack<>();
        for (int i=prices.length-1; i>=0; i--) {
        	pricesStack.push(prices[i]);
        }
        
        // prices 배열 데이터 중 어느단계(index)를 진행중인지 알기 위한 변수
        int curStep = 0;
        
        // pop 에 의해 스택 내 아이템이 존재 하지 않을 때 까지 진행한다.
        while (! pricesStack.empty()) {
        	// 가격이 떨어지지 않은기간을 저장하기 위한 변수
        	int second = 0;
        	
        	// 스택에서 아이템을 하나 꺼내온다.
        	int item = pricesStack.pop();
        	
        	// 남은 스택 내 아이템을 차례대로 순회..
        	for (int curIdx=pricesStack.size()-1; curIdx>=0; curIdx--) {
        		// 초 증가
        		second++;
        		// 다음 아이템을 조회 해본다.
        		int nextItem = pricesStack.elementAt(curIdx);
        		
        		// 다음 아이템이 현재 아이템의 값보다 작다면 종료.
        		if (item > nextItem) {
        			break;
        		}
        	}
     
        	// 측정된 second를 결과 배열에 담는다.
        	answer[curStep++] = second;
        }
        
        return answer;
    }
}
