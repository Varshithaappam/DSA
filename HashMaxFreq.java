import java.util.*;
class HashMaxFreq{
    public static void main(String args[]){
        int arr[]={1,3,2,3,4,1,5,1,2,3,4,5,3,2,1,3,4,5,3};
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        int m=0,element=0;
        for(int i:map.keySet()){
            if(m<map.get(i)){
                m=map.get(i);
                element = i;
            }
        }
        System.err.println(element);
    }
}

