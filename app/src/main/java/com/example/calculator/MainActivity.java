package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import static java.util.Collections.sort;

public class MainActivity extends AppCompatActivity {
    private Button num0;
    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;

    private Button plusButton;
    private Button minusButton;
    private Button multiplyButton;
    private Button devideButton;
    private Button removeButton;
    private Button resultButton;

    private TextView result;

    private String tempnum ="";        //숫자로 바꾸기 전에 저장용
    private String tempresult ="";     //계산기 화면에 뭘 입력했는지 보이게 하는용
    private ArrayList<Integer> calculatenum = new ArrayList<Integer>();   //피연산자 배열
    private ArrayList<Operation> operation = new ArrayList<Operation>();  //연산자 배열
    private int temporder = 0;                                           //연산자의 순서

//    class Calculatenum implements Comparable<Calculatenum> {
//        int num;
//        boolean ischanged = false;
//        Calculatenum(int a){
//            num = a;
//        }
//        public int compareTo(Calculatenum t){
//            return num - t.num;
//        }
//    }

    class Operation implements Comparable<Operation>{
        int order;                                                     //연산자의 순서
        int kind;                                                       //연산자의 종류
        public int compareTo(Operation t){
            return kind - t.kind;
        }   //사칙연산 곱나누기 우선으로 하게 하기 위해
        Operation(int a){
            kind = a;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        numsetListener();
        activesetlistener();
    }
    private void init(){
        num0 = findViewById(R.id.button0);
        num1 = findViewById(R.id.button1);
        num2 = findViewById(R.id.button2);
        num3 = findViewById(R.id.button3);
        num4 = findViewById(R.id.button4);
        num5 = findViewById(R.id.button5);
        num6 = findViewById(R.id.button6);
        num7 = findViewById(R.id.button7);
        num8 = findViewById(R.id.button8);
        num9 = findViewById(R.id.button9);

        plusButton = findViewById(R.id.button_plus);
        minusButton = findViewById(R.id.button_minus);
        multiplyButton = findViewById(R.id.button_multiply);
        devideButton = findViewById(R.id.button_devide);
        resultButton = findViewById(R.id.button_result);
        removeButton = findViewById(R.id.button_remove);
        result = findViewById(R.id.result);
    }

    private void numsetListener(){
        num0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tempnum = tempnum + 0;
                    tempresult = tempresult + 0;
                    result.setText(tempresult);
                }
        });
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempnum = tempnum + 1;
                tempresult = tempresult + 1;
                        result.setText(tempresult);
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempnum = tempnum + 2;
                tempresult = tempresult + 2;
                        result.setText(tempresult);
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempnum = tempnum + 3;
                tempresult = tempresult + 3;
                        result.setText(tempresult);
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempnum = tempnum + 4;
                tempresult = tempresult + 4;
                        result.setText(tempresult);
            }

        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempnum = tempnum + 5;
                tempresult = tempresult + 5;
                        result.setText(tempresult);
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempnum = tempnum + 6;
                tempresult = tempresult + 6;
                        result.setText(tempresult);
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempnum = tempnum + 7;
                tempresult = tempresult + 7;
                        result.setText(tempresult);
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempnum = tempnum + 8;
                tempresult = tempresult + 8;
                        result.setText(tempresult);
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempnum = tempnum + 9;
                tempresult = tempresult + 9;
                        result.setText(tempresult);
            }
        });


    }
    private void activesetlistener(){
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
                result.setText(tempresult);
            }
        });
        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatenum.add(Integer.parseInt(tempnum));
                Collections.sort(operation);                              //사칙연산 순서를 지키기 위해 정렬
//                result.setText(Integer.toString(operation.get(1).kind));
                int a = 0;
                for(int i= 0; i < operation.size(); i++) {
                    int b = operation.get(i).order - i;
                    if(b < 0){ b = 0;}
                    if(operation.get(i).kind == 1) {
                        a = calculatenum.get(b) * calculatenum.get(b + 1);
                    }else if(operation.get(i).kind == 2){
                        a = calculatenum.get(b) / calculatenum.get(b + 1);
                    }else if(operation.get(i).kind == 3){
                        a = calculatenum.get(b) + calculatenum.get(b + 1);
                    }else if(operation.get(i).kind == 4){
                        a = calculatenum.get(b) - calculatenum.get(b + 1);
                    }
                    calculatenum.remove(b+1);
                    calculatenum.set(b,a);

//                    calculatenum.get(b).ischanged = true;
//                    calculatenum.get(b+1).ischanged = true;
//                    int j = 0;
//                    while(j < calculatenum.size()) {
//                        if (calculatenum.get(j).ischanged == true) {
//                            calculatenum.get(j).num = a;
//                        }
//                        j += 1;
//                    }
                }
                result.setText(Integer.toString(a));
                clear();
            }
        });
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatenum.add(Integer.parseInt(tempnum));  //임시로 저장한것을 피연산자 배열에 넣음
                tempnum = "";                                  //임시 저장용을 초기화
                tempresult = tempresult + "+";
                result.setText(tempresult);
                operation.add(new Operation(3));
                operation.get(temporder).order = temporder;
                temporder += 1;

            }
        });
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatenum.add(Integer.parseInt(tempnum));
                tempnum = "";
                tempresult = tempresult + "-";
                result.setText(tempresult);
                operation.add(new Operation(4));
                operation.get(temporder).order = temporder;
                temporder += 1;
            }
        });
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatenum.add(Integer.parseInt(tempnum));
                tempnum = "";
                tempresult = tempresult + "*";
                result.setText(tempresult);
                operation.add(new Operation(1));
                operation.get(temporder).order = temporder;
                temporder += 1;
            }
        });
        devideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatenum.add(Integer.parseInt(tempnum));
                tempnum = "";
                tempresult = tempresult + "/";
                result.setText(tempresult);
                operation.add(new Operation(2));
                operation.get(temporder).order = temporder;
                temporder += 1;
            }
        });
    }
    public void clear(){
        tempnum = "";
        tempresult = "";
        temporder = 0;
        calculatenum.clear();
        operation.clear();

    }

}
