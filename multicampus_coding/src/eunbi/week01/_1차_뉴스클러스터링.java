package eunbi.week01;

import java.util.*;

class Solution2 {
    public int solution(String str1, String str2) {
        double answer = 0;
        double same = 0;
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        list1 = split(str1, list1);
        list2 = split(str2, list2);
        
        if(list1.size()==0 && list2.size()==0)
            return 65536;
        
        for(int i=0; i<list1.size(); i++){
            if(list2.contains(list1.get(i))){
                list2.remove(list1.get(i));
                same++;
            }
        }
        
        answer = same / (list1.size()+list2.size());

        return (int)(answer*65536);
    }
    
    public ArrayList split(String s, ArrayList list){
        for(int i=0; i<s.length()-1; i++){
            if(isAlphabet(s.charAt(i))&&isAlphabet(s.charAt(i+1))){ // 둘 다 문자면
                list.add(s.substring(i, i+2));
            }
        }
        
        return list;
    }
    
    public boolean isAlphabet(char c){
        if(c >= 'A' && c <='Z')
            return true;
        else
            return false;
    }
}

// uppercase로 대소문자 통일
// str1, str2 두글자씩 쪼개기, 문자포함인 경우 버리기
// 같은 원소 개수 찾기
// 공집합인 경우
