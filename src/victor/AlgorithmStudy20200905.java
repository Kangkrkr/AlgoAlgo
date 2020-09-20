package victor;

public class AlgorithmStudy20200905 {

	public static void main(String[] args) {

		//주식가격
		int[] prices = {1, 2, 3, 2, 3}; //[4, 3, 1, 1, 0]
		int[] answer42584 = solution(prices);
		System.out.println(answer42584);
	}
	
	public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for ( int i = 0; i < prices.length; i++ ) {
        	answer[i] = 0;
			for( int j = i+1; j < prices.length; j++ ) {
				answer[i]++;
				if( prices[i] > prices[j] ) {
					break;
				}
			}
		}
        
        return answer;
    }

}
