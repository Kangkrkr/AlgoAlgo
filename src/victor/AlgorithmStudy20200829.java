package victor;

public class AlgorithmStudy20200829 {

	public static void main(String[] args) {

		//124 나라의 숫자
		int dest = 39;
		for(int i=1; i<=dest; i++) {
			String answer12899Check = solution(i,true);
			String answer12899NoCheck = solution(i,false);
			System.out.print(i + " : " + answer12899Check + "\t\t");
			System.out.print(i + " : " + answer12899NoCheck);
			System.out.println();
		}
	}
	
	public static String solution(int n, boolean b) {
        String answer = "";
        
        int mod = 0;
        
        while(n > 0){
            mod = n % 3;
            n = n / 3;
            
            switch(mod){
                case 1: //1,4,7,10...
                case 2: //2,5,6,11...
                    answer = String.valueOf(mod).concat(answer);
                    break;
                case 0 : //3,6,9,12...
                	if(b) {
                		n -= 1; //자리수조절을 위해 1감소
                	}
                    answer = String.valueOf(4).concat(answer);
                    break;
                default : 
                    break;
            }
            
        }
        
        return answer;
    }

}
