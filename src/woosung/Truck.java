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
		
		int bridge_length4 = 2;
		int weight4 = 10;
		int[] truck_weights4 = {1, 4, 5, 6};
		
		
		// -------------------------------------------------
		// 				1,		4								湲몄씠媛� 2�씠湲� �븣臾몄뿉 �삎�� 李⑥꽑�씠 1媛� �씠寃� 留욎쓬
		// -------------------------------------------------
		
		System.out.println(solution(bridge_length1, weight1, truck_weights1));
//		System.out.println(solution(bridge_length2, weight2, truck_weights2));
//		System.out.println(solution(bridge_length3, weight3, truck_weights3));
//		System.out.println(solution(bridge_length4, weight4, truck_weights4));
	}
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		
		ArrayList<Integer> time = new ArrayList<Integer>(); //�듃�윮�씠 �떎由ъ뿉 �삱�씪�삤怨� �굹�꽌 吏��궃 �떆媛� 愿�由� Array
		ArrayList<Integer> passTruck = new ArrayList<Integer>(); //�옄�굹怨� �엳�뒗 �듃�윮 愿�由� Array
		
		// �듃�윮 �닔 留뚰겮 諛섎났
		for(int i = 0; i < truck_weights.length; i++) {
			answer += 1; // 1珥� 遺��꽣 �떆�옉
			
			// �떆媛꾧��젴 Array媛� 鍮꾩뼱 �엳吏� �븡�쑝硫� 1珥덉뵫 利앷�
			if(time.size() != 0) {
				for(int j = 0; j < time.size(); j++) {
					time.set(j, time.get(j) + 1);
				}
			}
			
			// �듃�윮�쓣 異쒕컻�꽑�긽�뿉 �삱由�
			time.add(0);
			passTruck.add(truck_weights[i]);
			
			// �듃�윮�씠 �걹源뚯� 媛붾떎硫� �떆媛� Array�� �넻怨쇱쨷�씤 �듃�윮 Array �뿉�꽌 �젣嫄�
			if(time.get(0) == bridge_length) {
				time.remove(0);
				passTruck.remove(0);
			}
			
			// sum 硫붿냼�뱶瑜� �씠�슜�빐 �떎由� �넻怨쇱쨷�씤 �듃�윮�쓽 珥앸Т寃뚮�� 寃��궗�빐 �꽆�쑝硫� 留덉�留� 異붽��맂 �듃�윮 �젣嫄�
			if(sum(passTruck) > weight) {
				passTruck.remove(passTruck.size() - 1);
				time.remove(time.size() - 1);
				i--;
			}
			
			// 留덉�留� �듃�윮�� �빐�떦 �떎由� 湲몄씠留뚰겮 珥덈�� 異붽�
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
