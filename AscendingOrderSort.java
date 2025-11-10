class AscendingOrderSort{
    public static void main(String[] args) {
        int arr[]={2,3,9,5,6,7};
        int n= arr.length;
        boolean ans=true;
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                ans=false;
                break;
            }
        }
        System.out.println(ans);
        }
    }

