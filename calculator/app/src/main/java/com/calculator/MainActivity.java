package com.calculator;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    float i=0;
    float j=0;
    float t=0;
    int op=0;
    int dc=0;

    TextView number,result;
    Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,mul,div,plus,min,clr,del,dot,sum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number=findViewById(R.id.number);
        result=findViewById(R.id.result);

        button0=findViewById(R.id.button0);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
        button7=findViewById(R.id.button7);
        button8=findViewById(R.id.button8);
        button9=findViewById(R.id.button9);
        dot=findViewById(R.id.dot);
        plus=findViewById(R.id.plus);
        min=findViewById(R.id.min);
        mul=findViewById(R.id.mul);
        div=findViewById(R.id.div);
        clr=findViewById(R.id.clr);
        del=findViewById(R.id.del);
        sum=findViewById(R.id.sum);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        dot.setOnClickListener(this);
        plus.setOnClickListener(this);
        min.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        clr.setOnClickListener(this);
        del.setOnClickListener(this);
        sum.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){
            case(R.id.button0):
                number.append("0");
                if (dc==1) {
                    i= (float) (i+0.0);
                }
                else{
                    i=i*10+0;
                }
                break;
            case(R.id.button1):
                number.append("1");
                if (dc==1) {
                    i= (float) (i+0.1);
                }
                else{
                    i=i*10+1;
                }
                break;

            case(R.id.button2):
                number.append("2");
                if (dc==1) {
                    i= (float) (i+0.2);
                }
                else{
                    i=i*10+2;
                }
                break;
            case(R.id.button3):
                number.append("3");
                if (dc==1) {
                    i= (float) (i+0.3);
                }
                else{
                    i=i*10+3;
                }
                break;
            case(R.id.button4):
                number.append("4");
                if (dc==1) {
                    i= (float) (i+0.4);
                }
                else{
                    i=i*10+4;
                }
                break;
            case(R.id.button5):
                number.append("5");
                if (dc==1) {
                    i= (float) (i+0.5);
                }
                else{
                    i=i*10+5;
                }
                break;
            case(R.id.button6):
                number.append("6");
                if (dc==1) {
                    i= (float) (i+0.6);
                }
                else{
                    i=i*10+6;
                }
                break;
            case(R.id.button7):
                number.append("7");
                if (dc==1) {
                    i= (float) (i+0.7);
                }
                else{
                    i=i*10+7;
                }
                break;
            case(R.id.button8):
                number.append("8");
                if (dc==1) {
                    i= (float) (i+0.8);
                }
                else{
                    i=i*10+8;
                }
                break;
            case(R.id.button9):
                number.append("9");
                if (dc==1) {
                    i= (float) (i+0.9);
                }
                else{
                    i=i*10+9;
                }
                break;

            case (R.id.dot):
                number.append(".");
                dc=1;
                break;



            case(R.id.plus):
                number.append("+");

                dc=0;

                if (op == 0) {
                    t = i;
                    op = 1;
                    i = 0;
                }
                else if (op==1){
                    t=t+i;
                    op=1;
                    i=0;
                }
                else if (op==2){
                    t=t-i;
                    op=1;
                    i=0;
                }
                else if (op==3){
                    t=t*i;
                    op=1;
                    i=0;
                }
                else if (op==4){
                    t=t/i;
                    op=1;
                    i=0;
                }


                break;
            case(R.id.min):
                number.append("-");
                dc=0;

                if (op == 0) {
                    t = i;
                    op = 2;
                    i = 0;
                }
                else if (op==1){
                    t=t+i;
                    op=2;
                    i=0;
                }
                else if (op==2){
                    t=t-i;
                    op=2;
                    i=0;
                }
                else if (op==3){
                    t=t*i;
                    op=2;
                    i=0;
                }
                else if (op==4){
                    t=t/i;
                    op=2;
                    i=0;
                }
                break;
            case(R.id.mul):
                number.append("*");

                dc=0;

                if (op == 0) {
                    t = i;
                    op = 3;
                    i = 0;
                }
                else if (op==1){
                    t=t+i;
                    op=3;
                    i=0;
                }
                else if (op==2){
                    t=t-i;
                    op=3;
                    i=0;
                }
                else if (op==3){
                    t=t*i;
                    op=3;
                    i=0;
                }
                else if (op==4){
                    t=t/i;
                    op=3;
                    i=0;
                }
                break;

            case(R.id.div):
                number.append("/");
                dc=0;

                if (op == 0) {
                    t = i;
                    op = 4;
                    i = 0;
                }
                else if (op==1){
                    t=t+i;
                    op=4;
                    i=0;
                }
                else if (op==2){
                    t=t-i;
                    op=4;
                    i=0;
                }
                else if (op==3){
                    t=t*i;
                    op=4;
                    i=0;
                }
                else if (op==4){
                    t=t/i;
                    op=4;
                    i=0;
                }
                break;
            case(R.id.clr & R.id.del):
                number.setText("");
                result.setText("");
                i=0;
                j=0;
                dc=0;
                t=0;
                op=0;
                break;



            case (R.id.sum):
                float s=0;
                if (op == 0) {
                    s = t;
                    op = 0;
                    dc=0;
                }
                else if (op==1){
                    s=t+i;
                    op=0;
                }
                else if (op==2){
                    s=t-i;
                    op=0;
                }
                else if (op==3){
                    s=t*i;
                    op=0;
                }
                else if (op==4){
                    s=t/i;
                    op=0;
                }
                String str ;
                str = String.valueOf(s);
                result.setText(str);
                break;

        }

    }
}