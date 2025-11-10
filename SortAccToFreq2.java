import java.util.*;
class SortAccToFreq2{
    public static void main(String[] args){
        int arr[]={4,6,5,5,5,5,5,5,6,6,6,6,5,6,6,2,4,4,3,3,1,1,1,1};
        int n=arr.length;
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        for(int i=0;i<n;i++)
        map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        int max=0;
        for(int i:map.keySet()){
            if(map.get(i)>max)
            max=map.get(i);
        }
        List<Integer>[] buckets=new ArrayList[max+1];
        for(int i = 0; i <= max; i++)
            buckets[i] = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int key=entry.getKey();
            int value=entry.getValue();
            buckets[value].add(key);
        }
        int []res=new int[n];
        int k=0;
        for(int i=1;i<max+1;i++){
            for(int num:map.keySet()){
                if(i==map.get(num)){
                    for(int j=0;j<i;j++)
                    res[k++]=num;
                }
            }
        }
        System.out.println(Arrays.toString(res));
    }
}