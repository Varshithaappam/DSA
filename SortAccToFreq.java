import java.util.*;
class SortAccToFreq{
    public static void main(String[] args){
        int arr[]={4,5,5,5,5,5,5,5,6,6,6,6,6,6,2,4,4,3,3,1,1,1,1};
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        int max=0;
        for(int i:map.keySet()){
            if(map.get(i)>max)
            max=map.get(i);
        }
        // int[] list = new int[max+1];
        // Arrays.fill(list,-1);
        // for (int i = 0; i <= max; i++) { 
        //     for(int key:map.keySet())
        //     if(map.get(key)==i)
        //     list[i]=key;
        // }
        // int brr[]=new int[n];
        // int k=0;
        // for(int i=0;i<list.length;i++){
        //     if(list[i]!=-1){
        //     for(int j=0;j<i;j++){
        //         brr[k++]=list[i];
        //     }
        //     }
        // }
        // System.out.println(Arrays.toString(brr));
        List<List<Integer>> list = new ArrayList<>(Collections.nCopies(max + 1, null));
        for (int i = 0; i <= max; i++) {
            List<Integer> row = new ArrayList<>();
            for (int key : map.keySet())
                if (map.get(key) == i)
                    row.add(key);
            list.set(i, row); 
        }
        
        int brr[] = new int[n];
        int k = 0;
        for (int i = 0; i < list.size(); i++) {
            List<Integer> inner = list.get(i);
            if (inner != null) {
                for (int j = 0; j < inner.size(); j++) {
                    for (int repeat = 0; repeat < i; repeat++) { 
                        brr[k++] = inner.get(j);
                    }
                }
            }
        }
        
        System.out.println(Arrays.toString(brr));
    }
}