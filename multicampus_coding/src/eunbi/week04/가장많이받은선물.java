package eunbi.week04;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class 가장많이받은선물 {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int arr[][] = new int[friends.length][friends.length]; // 준 선물 저장

        Map<String, Integer> num = new HashMap<String, Integer>(); // 이름-번호
        int giftNum[] = new int[friends.length]; // 선물 지수 
        int next[] = new int[friends.length]; // 다음달에 받을 선물
        
        for(int i=0; i<friends.length; i++)
            num.put(friends[i], i);
        
        for(int i=0; i<gifts.length; i++){ // 주고받은 선물
            String[] temp = gifts[i].split(" ");
            // num.get(temp[0]); // 선물을 준 사람의 인덱스
            arr[num.get(temp[0])][num.get(temp[1])] += 1;
        }
        
        for(int i=0; i<friends.length; i++){
            for(int j=0; j<friends.length; j++){
                giftNum[i] += arr[i][j]; // 준 선물
            }
        }
        
        for(int i=0; i<friends.length; i++){
            for(int j=0; j<friends.length; j++){
                giftNum[i] -= arr[j][i]; // 받은 선물
            }
        } // 선물지수
        
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                
                if(arr[i][j] > arr[j][i])
                    next[i]++;
                else if(arr[i][j] < arr[j][i])
                    next[j]++;
                else{ // 주고 받은 선물이 같은 경우
                    if(giftNum[i] > giftNum[j])
                        next[i]++;
                    else if(giftNum[i] < giftNum[j])
                        next[j]++;
                }
            }
        } 
        
        Arrays.sort(next);
        
        return next[next.length-1];
    }
}

// 1. 서로 선물을 주고 받은 경우 - 주고받은 선물 수가 다를 때
//    - 더 많은 선물을 준 사람이 하나 받음
// 2. 1이 아닌 경우
//    - 선물 지수가 더 큰사람이 하나 받음
// 선물 지수 : 준 선물 - 받은 선물
// 3. 선물 지수까지 같은 경우 : 주고받지 않음
// 선물을 가장 많이 받을 친구의 선물의 수
// [선물을 준 친구, 선물을 받은 친구]