package com.fun.dante.calculator;

/**
 * Created by Fun on 2018/3/8.
 */

public class stack {
    int num_top_stack,operaotr_top_stack;
    double num_stack[] = new double[50];
    char operator_stack[] = new char[50];
    public void push_num(double num){
        num_stack[num_top_stack++]=num;
        System.out.println(num+" in num_stack: "+num_top_stack);
    }
    public void push_operator(char character){
        operator_stack[operaotr_top_stack++]=character;
        System.out.println(character+" in operator_stack: "+operaotr_top_stack);
    }
    public double pop_num(){
        return num_stack[--num_top_stack];
    }
    public char pop_operator(){
        return operator_stack[--operaotr_top_stack];
    }
}
