/* 
Stack is a DS followuing LIFO P rinciple
In java in the apckage java.util.*  
Stack class in java
Push adds an element at the top
Pop removes the elements at top and returns element
Peek  returns elementat top position
*/
import java.util.*;
public class StackAPIExample{
    public static void main(String[] args){
        Stack<Integer> stack=new Stack<Integer>();
        System.out.println("stack size: "+stack.size());
        System.out.println("stack data: "+stack);
        stack.push(7);
        stack.push(4);
        stack.push(9);
        System.out.println("stack data: "+stack);
        System.out.println("removed element : "+stack.pop());
        System.out.println("stack data: "+stack);
        System.out.println("topmost element : "+stack.peek());
        System.out.println("stack data: "+stack);
        System.out.println("stack empty? true or false: "+stack.isEmpty());
    }
} 