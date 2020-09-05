package kangkrkr;
import java.util.Stack;

// 인형뽑기
// https://programmers.co.kr/learn/courses/30/lessons/64061
public class Solution4 {

	private static final int ITEM_NONE = 0;
	
	public static void main(String[] args) {
		int[][] board = {
			{0,0,0,0,0},
			{0,0,1,0,3},
			{0,2,5,0,1},
			{4,2,4,4,2},
			{3,5,1,3,1}
		};
		
		int[] moves = {1,5,3,5,1,2,1,4};
		
		Solution4 s4 = new Solution4();
		int answer = s4.solution(board, moves);
		System.out.println(answer);
	}

	public static int solution(int[][] board, int[] moves) {
        Stack<Integer> basket = new Stack<Integer>();
		int answer = 0;
		
		// Hi?????????
		
        for (int move : moves) {
        	int item = getItem(board, 0, move - 1);
        	if (item != 0) {
        		if (basket.size() > 0) {
        			int prev = basket.peek();
        			if (prev != item) {
        				basket.add(item);
        			} else {
        				basket.pop();
        				answer += 2;
        			}
        		}else {
        			basket.add(item);
        		}
        	}
        }
        
        
        return answer;
    }
	
	public static int getItem(int[][] board, int curRow, int move) {
		int item = ITEM_NONE;
		
		if (curRow > board.length - 1) {
			return ITEM_NONE;
		}
		
		int temp = board[curRow][move];
		
		if (temp != ITEM_NONE) {
			item = temp;
			board[curRow][move] = ITEM_NONE;
			return item;
		}
		
		return getItem(board, curRow + 1, move);
	}
}
