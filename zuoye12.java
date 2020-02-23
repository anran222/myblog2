package zuoye;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author:xiang
 * @Date:2020/2/22 22:51
 */
public class zuoye12 {
    public static void main(String[] args) {
        int[] nums={2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarray(nums));
        String[] tokens={"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }
    public static int findUnsortedSubarray(int[] nums) {
        int[] a = nums.clone();
        Arrays.sort(a);
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (a[i] != nums[i]) {
                num1 = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (a[i] != nums[i]) {
                num2 = i;
                break;
            }
        }
        if (num1 == 0 && num2 == 0) {
            return 0;
        } else {
            return num2 - num1 + 1;
        }
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<Integer>();
        for (String s:tokens) {
            switch (s){
                case "+":
                    stack.push(stack.pop()+stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop()+stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop()*stack.pop());
                    break;
                case "/":
                    int num1=stack.pop();
                    stack.push(stack.pop()/num1);
                    break;
                    default:stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
