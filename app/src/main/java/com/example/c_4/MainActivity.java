package com.example.c_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String str = "{{[()]}}";

        if (checkBalancedBrackets(str)) {
            Log.d("TAG", "Balanced");
        } else {
            Log.d("TAG", "Not balanced");

        }

        Log.d("TAG", String.valueOf(strCopies("cowcatcatcowcow", "cow", 3)));


    }

    public static boolean checkBalancedBrackets(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }

        }
        return stack.isEmpty();

    }

    public boolean strCopies(String str, String sub, int n) {


        Log.d("TAG", str + " " + "\t searching:" + sub + " \t N:" + n);

        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int count = 0;

        for (int i = 0; i < str.length(); i++) {

            if (str.contains(sub)) {
                count++;
                int start = str.indexOf(sub);
                start = start + sub.length() - 1;
                str = str.substring(start, str.length());
            }

            if(n == count){
                return true;
            }

        }

        return false;
    }


    

}
