package victor;

import java.util.LinkedList;
import java.util.Stack;

public class AlgorithmStudy20200822 {

	public static void main(String[] args) {

		int test = 42583;
		
		switch (test) {
			case 64061:
				//ũ���� �����̱� ����
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
				//�ٸ��� ������ Ʈ��
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
        
        //peek �Ǿ� ��������
        //poll �Ǿ� �����
        //offer �ǵ� �ֱ�
        int totalWeight = 0;
        
        for (int trucks : truck_weights) {
        	while ( true ) {
				if( bridgeQueue.isEmpty() ) { //������� �ڿ� �ְ� ��ü����,�ҿ�ð� ����
	    			bridgeQueue.offer(trucks);
	    			totalWeight += trucks;
	    			answer++;
	    			break;
	    		}else if(bridgeQueue.size() == bridge_length) {//�Ǿ��� Ʈ���� �� �ǳͻ���, ��ü���� ����
	    			totalWeight -= bridgeQueue.poll();
	    		}else {
	    			if(totalWeight + trucks > weight) { //�ٸ����Ը� �ʰ��ϸ� 0���� ä��
	    				bridgeQueue.offer(0);
	    				answer++;
	    			}else { //�ʰ����������� �ڿ��� Ʈ�� �ø��� ����,�ð� ����
	    				bridgeQueue.offer(trucks);
	    				totalWeight += trucks;
	    				answer++;
	    				break;
	    			}
	    		}
        	}
		}
      
        return answer + bridge_length; //������Ʈ���� �ö󰣻��·� �ݺ����� Ż���ϹǷ� �ٸ� ���̸� �����ð��� ���Ѵ�
    }
}
