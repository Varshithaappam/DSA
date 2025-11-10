import java.util.*;
class Problem{
    public static void main(String[] args){
        Integer arr[]={4,5,6,7,6,8,6};
        ArrayList<Integer> arr1=new ArrayList<>(Arrays.asList(arr));
        System.out.println(arr1);
        arr1.remove(Integer.valueOf(6));
        System.out.println(arr1);
        Collections.sort(arr1,Collections.reverseOrder());
        System.out.println(arr1);
    }
}