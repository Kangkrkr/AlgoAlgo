package programers;

import java.util.ArrayList;

public class Truck {

	public static void main(String[] args) {
		int bridge_length1 = 2;
		int weight1 = 10;
		int[] truck_weights1 = {7, 4, 5, 6};
//		
//		int bridge_length2 = 100;
//		int weight2 = 100;
//		int[] truck_weights2 = {10};
//		
//		int bridge_length3 = 100;
//		int weight3 = 100;
//		int[] truck_weights3 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
		
		int bridge_length4 = 2;
		int weight4 = 10;
		int[] truck_weights4 = {1, 4, 5, 6};
		
		
		// -------------------------------------------------
		// 				1,		4								길이가 2이기 때문에 형은 차선이 1개 이게 맞음
		// -------------------------------------------------
		
		System.out.println(solution(bridge_length1, weight1, truck_weights1));
//		System.out.println(solution(bridge_length2, weight2, truck_weights2));
//		System.out.println(solution(bridge_length3, weight3, truck_weights3));
//		System.out.println(solution(bridge_length4, weight4, truck_weights4));
	}
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		
		ArrayList<Integer> time = new ArrayList<Integer>(); //트럭이 다리에 올라오고 나서 지난 시간 관리 Array
		ArrayList<Integer> passTruck = new ArrayList<Integer>(); //자나고 있는 트럭 관리 Array
		
		// 트럭 수 만큼 반복
		for(int i = 0; i < truck_weights.length; i++) {
			answer += 1; // 1초 부터 시작
			
			// 시간관련 Array가 비어 있지 않으면 1초씩 증가
			if(time.size() != 0) {
				for(int j = 0; j < time.size(); j++) {
					time.set(j, time.get(j) + 1);
				}
			}
			
			// 트럭을 출발선상에 올림
			time.add(0);
			passTruck.add(truck_weights[i]);
			
			// 트럭이 끝까지 갔다면 시간 Array와 통과중인 트럭 Array 에서 제거
			if(time.get(0) == bridge_length) {
				time.remove(0);
				passTruck.remove(0);
			}
			
			// sum 메소드를 이용해 다리 통과중인 트럭의 총무게를 검사해 넘으면 마지막 추가된 트럭 제거
			if(sum(passTruck) > weight) {
				passTruck.remove(passTruck.size() - 1);
				time.remove(time.size() - 1);
				i--;
			}
			
			// 마지막 트럭은 해당 다리 길이만큼 초를 추가
			if(i == truck_weights.length - 1) {
				answer += bridge_length;
				break;
			}
			
		}
		
		return answer;
	}
	
	public static int sum(ArrayList<Integer> passTruck) {
		int sum = 0;
		
		for(int i = 0; i < passTruck.size(); i++) {
			sum += passTruck.get(i);
		}
		
		return sum;
	}
	
}
