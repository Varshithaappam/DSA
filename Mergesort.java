import java.util.*;
class Mergesort{
    public static void main(String[] args) {
        int arr[]=new int[]{3,1,3,7,2,9,2,0,4,6,5,8};
        mergesort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void mergesort(int arr[],int l,int r){
            if(l==r) return;
            int m=(l+r)/2;
            mergesort(arr,l,m);
            mergesort(arr,m+1,r);
            merge(arr,l,m,r);
    }
    static void merge(int arr[],int l,int m,int r){
        int n1=m-l+1;
        int n2=r-m;
        int left[]=new int[n1];
        int right[]=new int[n2];
        for(int i=0;i<n1;i++){
            left[i]=arr[l+i];
        }
        for(int j=0;j<n2;j++){
            right[j]=arr[m+1+j];
        }
        int i=0,j=0;
        int k=l;
        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                arr[k]=left[i];
                i++;
            }else{
                arr[k]=right[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k]=left[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=right[j];
            j++;
            k++;
        }
    }
}