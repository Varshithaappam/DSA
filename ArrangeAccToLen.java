import java.util.*;
class ArrangeAccToLen{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String str[]=s.split(" ");
        for (int i = 0; i < str.length - 1; i++) {
        int maxIdx = i;
        for (int j = i + 1; j < str.length; j++) {
            if (str[j].length() > str[maxIdx].length()) {
                maxIdx = j;
            }
        }
        String temp = str[i];
        str[i] = str[maxIdx];
        str[maxIdx] = temp;
    }
    System.out.println(Arrays.toString(str));
    }
}