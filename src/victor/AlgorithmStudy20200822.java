package victor;

import java.util.LinkedList;
import java.util.Stack;

public class AlgorithmStudy20200822 {

	public static void main(String[] args) {

		int test = 42583;
		
		switch (test) {
			case 64061:
				//크레인 인형뽑기 게임
				int[][] board = {
						{0,0,0,0,0},
						{0,0,1,0,3},
						{0,2,5,0,1},
						{4,2,4,4,2},
						{3,5,1,3,1}
				};
				int[] moves = {1,5,3,5,1,2,1,4};
				int answer64061 = solution(board, moves);
				System.out.println(answer64061);
				break;
				
			case 42583:
				//다리를 지나는 트럭
				int bridge_length = 2;
				int weight = 10;
				int[] truck_weights = {7,4,5,6};
				int answer42583 = solution(bridge_length, weight, truck_weights);
				System.out.println(answer42583);
				break;
			default:
				break;
		}

	}
	
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> itemStack = new Stack<Integer>();
        
        for (Integer move : moves) {
        	int findItem = getItem(board, 0, move - 1);
        	if( findItem != 0 ) {
        		if(itemStack.size() > 0 ) {
        			int beforeItem = itemStack.peek();
        			if(beforeItem == findItem) {
        				itemStack.pop();
        				answer += 2;
        			}else {
        				itemStack.add(findItem);
        			}
        		}else {
        			itemStack.add(findItem);
        		}
        	}
		}
        
        return answer;
    }

	private static Integer getItem(int[][] board, int findRow, int findCol) {
		int item = 0;
	      
		if (findRow > board.length - 1) {
			return 0;
		}
	      
		int nowItem = board[findRow][findCol];
	      
		if (nowItem != 0) {
			item = nowItem;
			board[findRow][findCol] = 0;
			return item;
		}
	      
		return getItem(board, findRow + 1, findCol);
	}


	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
        
        LinkedList<Integer> bridgeQueue = new LinkedList<Integer>();
        
        //peek 맨앞 가져오기
        //poll 맨앞 지우기
        //offer 맨뒤 넣기
        int totalWeight = 0;
        
        for (int trucks : truck_weights) {
        	while ( true ) {
				if( bridgeQueue.isEmpty() ) { //비었을때 뒤에 넣고 전체무게,소요시간 증가
	    			bridgeQueue.offer(trucks);
	    			totalWeight += trucks;
	    			answer++;
	    			break;
	    		}else if(bridgeQueue.size() == bridge_length) {//맨앞의 트럭이 다 건넌상태, 전체무게 감소
	    			totalWeight -= bridgeQueue.poll();
	    		}else {
	    			if(totalWeight + trucks > weight) { //다리무게를 초과하면 0으로 채움
	    				bridgeQueue.offer(0);
	    				answer++;
	    			}else { //초과하지않으면 뒤에다 트럭 올리고 무게,시간 증가
	    				bridgeQueue.offer(trucks);
	    				totalWeight += trucks;
	    				answer++;
	    				break;
	    			}
	    		}
        	}
		}
      
        return answer + bridge_length; //마지막트럭은 올라간상태로 반복문을 탈출하므로 다리 길이를 최종시간에 합한다
    }
}
