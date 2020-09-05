package kangkrkr;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// 124 나라의 숫자
// https://programmers.co.kr/learn/courses/30/lessons/12899?language=java

class Item {
	private int decreaseCnt;
	private String    value;
	
	public Item(int decreaseCnt, String value) {
		super();
		this.decreaseCnt = decreaseCnt;
		this.value = value;
	}
	
	public int getDecreaseCnt() {
		return decreaseCnt;
	}
	public void setDecreaseCnt(int decreaseCnt) {
		this.decreaseCnt = decreaseCnt;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}

public class Solution6 {
	public static void main(String[] args) {
		
		Solution6 solution = new Solution6();
		
		//int max =20;
		//for (int n=1; n<=max; n++) {
		//	System.out.println(n + "-> " + solution.solution(n));
		//}
		System.out.println(9 + "-> " + solution.solution(9));
	}

	public String solution(int n) {
		List<Item> itemList = new ArrayList<>();
		List<String> presentList = new LinkedList<>(Arrays.asList("0", "1", "2", "4"));
		
		
		if (n < 4) {
			return String.valueOf(n == 3 ? 4 : n);
		}
		
		//int temp = n;
		Stack<String> stack = new Stack<>();
		
		while (n >= 3) {
			int namuzi = n % 3;
			stack.push(String.valueOf(namuzi));
			n /= 3;
		}
		stack.push(String.valueOf(n));
		
		while (! stack.isEmpty()) {
			itemList.add(new Item(0, stack.pop()));
		}
		
		for (int i=itemList.size()-1; i>=0; i--) {
			Item   cur  = itemList.get(i);
			String item = cur.getValue();
			
			if ("0".equals(item) && i > 0) {
				cur.setDecreaseCnt(-1);
			}
		}

		//printStatus(itemList, temp);
		
		for (int i=itemList.size()-1; i >= 0; i--) {
			Item cur = itemList.get(i);
			
			if (cur.getDecreaseCnt() < 0) {
				int presentIdx = presentList.indexOf(cur.getValue());
				
				if (i > 0) {
					Item prev = itemList.get(i-1);
					
					if (presentIdx == 0) {
						prev.setDecreaseCnt(prev.getDecreaseCnt() - 1);
					}
				}
				
				presentIdx = (presentIdx == 0 ? 4 : presentIdx);
				presentIdx += cur.getDecreaseCnt();
				
				String item = presentList.get(presentIdx);
				if ("0".equals(item)) {
					if (i > 0) {
						presentIdx = 3;
						
						Item prev = itemList.get(i-1);
						prev.setDecreaseCnt(prev.getDecreaseCnt() - 1);
					}
				}
				
				cur.setValue(presentList.get(presentIdx));
			}
			
			//printStatus(itemList, temp);
		}
		
		return itemList.stream()
				.map(item -> {
					return item.getValue();
				})
				.filter(item -> {
					return !"0".equals(item);
				})
				.reduce((left, right) -> {
				    return left + right;
			    })
				.orElse("");
	}

	private void printStatus(List<Item> itemList, int temp) {
		String descStr = itemList.stream()
								 .map(item -> {
								 	return item.getValue() + "["+String.valueOf(item.getDecreaseCnt())+"],";
								 })
								 .reduce((left, right) -> {
								 	return left + right;
								 })
								 .orElse("")
								 ;
		
		System.out.println(temp + " -> " + descStr);
	}
}
