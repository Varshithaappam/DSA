/*
 A monotonic stack is a specialized stack where the elements are maintained in either a strictly increasing or strictly decreasing order. 
It is a programming technique used to solve problems in a single pass with linear time complexity, typically related to finding the "next greater" or "next smaller" element for each element in an array
*/
import java.util.*;
import java.util.Stack;
class MonotonicStack{
    public static void main(String[] args){
        int arr[]={2,1,5,6,3,9};
        int n=arr.length;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            stack.push(arr[i]);
        }
        Stack<Integer> monotonicStack=new Stack<>();
        for(int i=0;i<n;i++){
            while(!monotonicStack.isEmpty() && arr[i]<=monotonicStack.peek()){
                monotonicStack.pop();
            }
            monotonicStack.push(arr[i]);
        }
        System.out.println("stack data: "+monotonicStack);
    }
}