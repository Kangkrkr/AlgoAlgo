package woosung;

import java.util.ArrayList;

public class Country124 {
	public static void main(String[] args) {
//		for(int n = 1; n <= 30; n++) {
//			System.out.println(solution(n));
//		}
		
		System.out.println(solution(6));
	}
	
	// �삁瑜� �뱾�뼱�꽌 7�씠�씪�뒗 �닽�옄媛� �엳�떎硫� n = 7 �씠�씪硫�
	// n / 3 = 2,  n % 3 = 1
	//           21
	
	// �삁瑜� �뱾�뼱 n = 6 �씠�떎.
	// n / 3 = 2, n % 3 = 0
	// �굹癒몄�媛� 0 �씪�븣�뒗 臾댁“嫄� 2踰덉� 媛믪쑝濡�
	// 洹몃━怨� 0 �씪�븣�뒗 �븵�뿉�엳�뒗 紐レ쓣 -1
	// n / 3 = 2 --> 1
	// n % 3 = 0 --> 2
	// 14
	
	public static String solution(int n) {
		String answer = "";
		int share = 0; // 紐�
		String last = ""; // 留덉�留�
		
		ArrayList<String> country124 = new ArrayList<String>();
		country124.add("1");
		country124.add("2");
		country124.add("4");
		
		// 紐レ씠 3蹂대떎 �옉�쓣 �븣源뚯� �굹�닃 �븣 �굹�삤�뒗 �굹癒몄�瑜� �떞�뒗 Array
		ArrayList<Integer> buff = new ArrayList<Integer>();
		
		// 紐レ씠 0�씪 寃쎌슦 利�, (1, 2) �씪 寃쎌슦
		if(n / 3 == 0){
			answer = country124.get(n % 3 - 1);
			return answer;
		} else { // 紐レ씠 1 �씠�긽�씪 寃쎌슦, 3 �씠�긽�쓽 �닔
			// �굹癒몄�媛� 0 �씪寃쎌슦
			if(n % 3 == 0) {
				last = country124.get(2);
				share = n / 3 - 1;
			} else { // �굹癒몄�媛� 0�씠 �븘�땺 寃쎌슦
				last = country124.get(n % 3 - 1);
				share = n / 3;
			}
			
			// 紐レ씠 3蹂대떎 �겢 寃쎌슦 3蹂대떎 �옉�쓣 �븣源뚯� �굹�늻湲�
			while(share > 3) {
				if(share % 3 == 0) {
					share = share / 3 - 1;
					buff.add(3);
				} else {
					buff.add(share % 3);
					share = share / 3;
				}
			}
		}
		
		// 紐レ씠 0�씠 �븘�땺寃쎌슦�뿉留�
		if(share != 0) {
			answer = country124.get(share - 1);
		}
		
		// 紐レ씠 3 �씠�긽�씪 �븣 �떞�븯�뜕 �굹癒몄��뱾
		for(int i = buff.size() - 1; i >= 0; i--) {
			answer += country124.get(buff.get(i) - 1);
		}
		
		// 理쒖큹 �굹�댋�쓣 �븣 �굹癒몄�
		answer += last;
		
		return answer;
	}
}
