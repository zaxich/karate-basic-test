package org.example;

//overloading
class Operation {
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    //overloading: parameter menjadi 3 int
    public int add(int a, int b, int c) {
        return a + b + c;
    }
}


//overriding

class MultiplyOverride extends Operation {
    @Override
    public int add(int a, int b) {
        return a * b;
    }
}


public class Polymorphism {

    public static void main(String[] args) {
        Operation op = new Operation();
        Operation mulOp = new MultiplyOverride(); //better yang ini, karena nandain dy inherit dari sana
        MultiplyOverride mulOp2 = new MultiplyOverride();

        int result1 = op.add(5, 10);
        double result2 = op.add(2.5, 3.5);
        int result3 = op.add(5, 10, 15);
        int result4 = mulOp.add(5, 10);
        int result5 = mulOp2.add(5, 10);

        System.out.println("Operation (5,10): " + result1);
        System.out.println("Operation (2.5,3.5): " + result2);
        System.out.println("Operation (5,10,15): " + result3);
        System.out.println("Operation (5,10): " + result4);
        System.out.println("Operation (5,10): " + result5);

        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught Arithmetic exception " + e.getMessage());
        }

        try {
            int[] arr = new int[5];
            int index = arr[10];
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Caught ArrayIndexOutOfBounds " + e.getMessage());
        }

        try{
            String str = null;
            str.length();
        }catch (NullPointerException e){
            System.out.println("Caught NPE " + e.getMessage());
        }

        try{
            String str = "Hello";
            char ch = str.charAt(10);
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("Caught StringIndexOutOfBoundsException " + e.getMessage());
        }

        try{
            Thread t = new Thread();
            t.start();
            t.start(); //mencoba memanggil thread saat yang pertama belum selesai
        }catch (IllegalThreadStateException e){
            System.out.println("Caught IllegalThreadStateException " + e.getMessage());
        }
    }
}
