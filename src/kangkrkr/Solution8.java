package kangkrkr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 타겟넘버
// https://programmers.co.kr/learn/courses/30/lessons/43165?language=java
public class Solution8 {

	public static void main(String[] args) {
		
		Solution8 solution = new Solution8();

		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		
		System.out.println(solution.solution(numbers, target));
	}

	public int solution(int[] numbers, int target) {
		// ROOT
		return recursive(numbers, new ArrayList<>(), target, numbers.length);
    }
	
	public int recursive(int[] numbers, List<Integer> tempList, int target, int size) {

		if ((size == tempList.size() && getTotalSumOfList(tempList) == target)) {
			System.out.println("Solution : " + tempList + " : " + getTotalSumOfList(tempList));
			return 1;
		}
		
		if (isEmptyArray(numbers)) {
			System.out.println(tempList);
			
			return 0;
		}
		
		// 왼쪽가지 생성
		List<Integer> leftList = new ArrayList<>(tempList);
		leftList.add(numbers[0]);
		int[] leftNumbers = Arrays.copyOfRange(numbers, 1, numbers.length);
		int leftCnt = recursive(leftNumbers, leftList, target, size);
		
		// 오른쪽가지 생성
		List<Integer> rightList = new ArrayList<>(tempList);
		rightList.add(numbers[0] * -1);
		int[] rightNumbers = Arrays.copyOfRange(numbers, 1, numbers.length);
		int rightCnt = recursive(rightNumbers, rightList, target, size);

		//                        [Root]
		//                       /      \
		//                      1		 -1
		//                    /   \     /  \
		//                   1    -1   1   -1
		//                 /   \  
		//                1    -1
		//              /   \
		//             1    -1
 		//           / \    / \        
		//          1  -1  1  -1
		//----------------------------------------------------
		//          5   3  3   1
		return leftCnt + rightCnt;
	}

	private Integer getTotalSumOfList(List<Integer> tempList) {
		return tempList.stream()
					   .reduce((left, right) -> {
						   return left + right;
					   })
					   .orElse(0);
	}

	private boolean isEmptyArray(int[] list) {
		return null == list || list.length == 0;
	};
}
