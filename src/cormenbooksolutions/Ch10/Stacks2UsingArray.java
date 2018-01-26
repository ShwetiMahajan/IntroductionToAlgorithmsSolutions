package cormenbooksolutions.Ch10;

/**
 * Created by shwetimahajan on 12/9/17.
 */
public class Stacks2UsingArray {
    public static class Stacks{
        int A[];
        int top1;
        int top2;
        public Stacks(int sizeOfArray) {
            A = new int[sizeOfArray];
            top1 = -1;
            top2 = sizeOfArray;
        }
        public void push1(int data) {
            if(top2-top1 != 1) {
                top1 += 1;
                A[top1] = data;
            }
            else{
                new Exception("Stack 1 Overflow").printStackTrace();
            }
        }
        public void push2(int data) {
            if(top2-top1 != 1) {
                top2 -= 1;
                A[top2] = data;
            }
            else {
                new Exception("Stack 2 Overflow").printStackTrace();
            }
        }
        public void pop1() {
            if(top1 < 0) {
                new Exception("Stack 1 is empty").printStackTrace();
            }
            else {
                top1 -= 1;
            }
        }
        public void pop2() {
            if(top2 > A.length-1) {
                new Exception("Stack 2 is empty").printStackTrace();
            }
            else {
                top2+=1;
            }
        }
        public boolean isStack1Empty() {
            return (top1 < 0);
        }
        public boolean isStack2Empty() {
            return (top2 > A.length-1);
        }
        public int peek1(){
            return A[top1];
        }
        public int peek2() {
            return A[top2];
        }
    }

    public static void main(String[] args) {
        Stacks s = new Stacks(5);
        s.push1(2);
        s.push2(5);
        s.push1(3);
        s.push1(10);
        s.push1(12);
        s.pop2();
        s.push2(7);

    }
}
