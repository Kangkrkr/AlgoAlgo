package kangkrkr;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

// 다리를 지나는 트럭
// https://programmers.co.kr/learn/courses/30/lessons/42583?language=java
public class Solution5 {
	
	public static void main(String[] args) {
		
		int[] bridgeLengthArr = {2, 10, 100};
		int[] weightArr = {10, 10, 100};
		int[][] truckWeightArr = {
			{7, 4, 5, 6},
			{10},
			{10,10,10,10,10,10,10,10,10,10}
		};
		
		Solution5 solution = new Solution5();
		
		for (int step=0; step<bridgeLengthArr.length; step++) {
			long startTime = System.currentTimeMillis();
			
			int bridge_length = bridgeLengthArr[step];
			int weight = weightArr[step];
			int[] truck_weights = truckWeightArr[step];
			
			System.out.println("답 : " + solution.solution(bridge_length, weight, truck_weights));
			
			System.out.println("소요시간 : " + (System.currentTimeMillis() - startTime) / 1000 + "초");
		}
	}
	
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> truckQueue  = new LinkedList<Integer>();
        Queue<Integer> bridgeQueue = new LinkedList<Integer>();
        
        IntStream.range(0, truck_weights.length)
        		 .boxed()
        		 .forEach((index) -> {
        		 	truckQueue.offer(truck_weights[index]);
        		 });
        
        bridgeQueue.offer(0);
        int sumWightOnBridge = 0;
        
        do {
        	if (answer > 1) {
        		System.out.println(answer - 1 + "초에 다리는 건너는중인 트럭들 : " + bridgeQueue.toString());
        	}
        	answer++;
        	
        	//System.out.println("----------------------");
        	//System.out.println("현재 단계 : " + answer + "초");
        	//System.out.println("----------------------");

        	// 1. 현재 시점(초)이 다리에서 트럭을 내릴 단계인가 ?
        	if (answer >= bridge_length + 1) {
        		int truck = bridgeQueue.poll();
        		
        		sumWightOnBridge -= truck;
        		System.out.println(answer - 1 + "초에 " + truck + "이 내려갑니다.");
        	}
        	
        	// 2. 정상적으로 다리에 트럭을 적재할수 있는가?
        	if (!truckQueue.isEmpty()
        			&& (bridgeQueue.size() < bridge_length)
        			//&& (isEnableOfferTruckToBridge(bridgeQueue, truckQueue, weight))) {
        			&& (sumWightOnBridge + truckQueue.peek() <= weight)) {
        		int truck = truckQueue.poll();
        		System.out.println(answer - 1 + "초에 " + truck + "이 올라갑니다.");
        		
        		bridgeQueue.offer(truck);
        		
        		sumWightOnBridge += truck;
        	} 
        	// 3. 아닌 경우, 브릿지 큐에 데이터를 0으로 보강 시킨다.
        	else {
        		System.out.println(answer - 1 + "초에는 무게 제한으로 인해 트럭 "+truckQueue.peek()+"이 대기중입니다.");
        		if (bridgeQueue.size() < bridge_length) {
        			bridgeQueue.offer(0);
        		}
        	}
        } while(isEnd(bridgeQueue) == false);
        
        
        
        return answer - 1;
    }
	
	public boolean isEnableOfferTruckToBridge(Queue<Integer> bridgeQueue, Queue<Integer> truckQueue, int bridgeMaxWeight) {
		int currentBridgeTotalWeight = bridgeQueue.stream()
												  .reduce((left, right) -> {
													   return Integer.sum(left, right);
												  })
												  .orElse(0);
		int nextTruckWeight = truckQueue.peek();
		
		return (currentBridgeTotalWeight + nextTruckWeight) <= bridgeMaxWeight;
	}
	
	public boolean isEnd(Queue<Integer> bridgeQueue) {
		return bridgeQueue.stream()
		  .reduce((left, right) -> {
			   return Integer.sum(left, right);
		  })
		  .orElse(0) == 0;
	}

}
