package woosung;

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
		
//		int bridge_length4 = 2;
//		int weight4 = 10;
//		int[] truck_weights4 = {1, 4, 5, 6};
		
		
		System.out.println(solution(bridge_length1, weight1, truck_weights1));
//		System.out.println(solution(bridge_length2, weight2, truck_weights2));
//		System.out.println(solution(bridge_length3, weight3, truck_weights3));
//		System.out.println(solution(bridge_length4, weight4, truck_weights4));
	}
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		
		ArrayList<Integer> time = new ArrayList<Integer>();
		ArrayList<Integer> passTruck = new ArrayList<Integer>();
		
		for(int i = 0; i < truck_weights.length; i++) {
			answer += 1;
			
			if(time.size() != 0) {
				for(int j = 0; j < time.size(); j++) {
					time.set(j, time.get(j) + 1);
				}
			}
			
			time.add(0);
			passTruck.add(truck_weights[i]);
			
			if(time.get(0) == bridge_length) {
				time.remove(0);
				passTruck.remove(0);
			}
			
			if(sum(passTruck) > weight) {
				passTruck.remove(passTruck.size() - 1);
				time.remove(time.size() - 1);
				i--;
			}
			
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
