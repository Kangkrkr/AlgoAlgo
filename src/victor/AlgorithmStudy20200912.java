package victor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AlgorithmStudy20200912 {

	public static void main(String[] args) {
		
		int problem = 42842;
		
		switch (problem) {
		//���ڿ� ����
		case 60057:
			String s = "aabbaccc";
			int answer60057 = solution(s);
			System.out.println(answer60057);
			break;
		//ī��
		case 42842:
			int brown = 24;
			int yellow = 24;
			int[] answer42842 = solution(brown, yellow);
			System.out.println(answer42842);
			break;
		//�Ҽ� ã��
		case 42839:
			String numbers = "17";
			int answer42839 = solution2(numbers);
			System.out.println(answer42839);
		default:
			break;
		}

	}

	private static int solution(String s) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int totalTile = brown + yellow;
        //12
        //(1,2,3,4,6,12)
        //�����Ǳ���>=���α���
        
        //i�� 3�� ���� ? ����� Ÿ���� �ּ� 1�� �����϶� ���� Ÿ���� ���α��̴� 3���� �����ϱ� ����
        for(int i=3; i<=totalTile; i++){
            // ��� ��� ���ϱ�
            if(totalTile % i == 0){
                int row = totalTile / i;    // ����
                int col = totalTile / row;  // ����

                int yRow = row - 2;    // yellow ������ ����
                int yCol = col - 2;    // yellow ������ ����
                if(yRow * yCol == yellow && row >= col){
                    answer[0] = row;
                    answer[1] = col;
                    break;
                }
            }
        }
        
        return answer;
    }
	
	private static int solution2(String numbers) {
		// ����Ʈ�� �����
		char[] list = numbers.toCharArray();
        int[] makeNumFrom = new int[list.length];
        for (int i = 0; i < list.length; i++) {
        	//���ڸ� ����� ���� ��ҵ� �ֱ�
            makeNumFrom[i] = Integer.parseInt(String.valueOf(list[i]));
        }
		
		//��������� ����  �� �ߺ����ſ�  set
        Set<Integer> makeNumTo = new HashSet<>();
		
		
        return makeNumTo.size();
	}
	
	private static boolean checkPrime(String s) {
		
		int num = Integer.parseInt(s);
		boolean isPrime = false;
		
		for (int i = 2; i < num; i++) {
            // 1�� num �ڽ� �ܿ� ���������� ���� �ִ��� �˻��� ���ǹ�
            if (num % i == 0) {
                // ���������� ���� ���� ��� isPrime�� ���� true�� �ٲ۴�.
                isPrime = true;
                // �� ���̶� �� ���ǹ��� ����� ��� num�� �Ҽ��� �ƴϹǷ� �ݺ����� �������´�.
                break;
            }
        }

		return isPrime;
	}
}
