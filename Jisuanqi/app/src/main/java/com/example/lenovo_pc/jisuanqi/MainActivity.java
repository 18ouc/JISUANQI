package com.example.lenovo_pc.jisuanqi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.NumberFormat;
public class MainActivity extends AppCompatActivity {
    double sum = 0;//记录界面上显示的数（十分重要）
    boolean flag = true;//用于判定是不是第一次按下按钮
    int quLing = 0;//用于排除 0000的出现
    double result = 0;
    double sum1 = 0;
    double sum2 = 0;
    int lingHouDian = 0;//使敲击 四则运算符号 后马上敲击 点 可以得到0.
    int dengHouDian = 0; int oc = 0;//使敲击 等号 后马上敲击 点 可以得到0.
    int op = 0;//用于判断是四则运算的哪一个
    int t =0;//控制deng 里面两个if只有一个执行
    int x = 0;//实现1+1+1
    int d = 0;//防止11出现
    //实现多次四则运算
    String first = "0";
    String second = "";
    int k = 0;//用来避免多个小数点出现
    int lianDian = 0;//用于实现连续点等号可以实现自加情况
    int  m = 0;//用于判断 四则运算敲击次数
    int p = 0;//用于实现连加
    int od = 0;//用于实现连加
    int hehe = 0;
    int xx = 0;//用于控制无效输出后的等号
    int yy = 0;//用于控制单目运算后 加 等号
    int q  = 0;//修补2.2.2.
    int qq = 0;
    int a = 0;//修补按平方后再按数字的
    int pp = 0;//用于修补99平方 + 1（崩溃bug）
    int kk  = 0;//用于修补 除等bug
    int fudian = 0;//用于修补按点后按负号点会消失
    int bfudian = 0;//保存产生的点
    int ffudian = 0;//防止产生两个点
    int fffudian = 0;//实现-0.0
    int ppt = 0;//用于使平方后退位失灵
    int ooo = 0;//用于修复按点0再按加减的bug
    int aaa = 0;//用于修补四则运算后不能退位的情况
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //绑定各个控件监听**********************************************************
        Button btn_0 = (Button)findViewById(R.id.Btn0);
        Button btn_1 = (Button)findViewById(R.id.Btn1);
        Button btn_2 = (Button)findViewById(R.id.Btn2);
        Button btn_3 = (Button)findViewById(R.id.Btn3);
        Button btn_4 = (Button)findViewById(R.id.Btn4);
        Button btn_5 = (Button)findViewById(R.id.Btn5);
        Button btn_6 = (Button)findViewById(R.id.Btn6);
        Button btn_7 = (Button)findViewById(R.id.Btn7);
        Button btn_8 = (Button)findViewById(R.id.Btn8);
        Button btn_9 = (Button)findViewById(R.id.Btn9);
        Button btn_genhao = (Button)findViewById(R.id.BtnRooting);
        Button btn_pingfang = (Button)findViewById(R.id.BtnSquare);
        Button btn_daoshu = (Button)findViewById(R.id.BtnReciprocal);
        Button btn_jia = (Button) findViewById(R.id.BtnPlus);
        Button btn_jian = (Button)findViewById(R.id.BtnMinus);
        Button btn_cheng = (Button)findViewById(R.id.BtnMultiply);
        Button btn_chu = (Button)findViewById(R.id.BtnDivide);
        Button btn_CE = (Button)findViewById(R.id.BtnCE);
        Button btn_C = (Button)findViewById(R.id.BtnC);
        Button btn_tuiwei = (Button)findViewById(R.id.BtnBack);
        Button btn_jiajian = (Button)findViewById(R.id.BtnSign);
        Button btn_deng = (Button)findViewById(R.id.BtnEqual);
        Button btn_dian = (Button)findViewById(R.id.BtnPoint);
        final TextView textView = (TextView) findViewById(R.id.tvResult);
        textView.setText("0");
//绑定 = 的监听事件！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
        btn_deng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aaa = 0;//用于修补四则运算后不能退位的情况
                NumberFormat nf = NumberFormat.getInstance();
                nf.setMaximumFractionDigits(15);
                textView.setText(String.valueOf(nf.format(sum)));//修补2.00按等号的bug0
                int ppp = 0;//用与控制非零数除以0 输出除数不能为0
                bfudian = 0;//保存产生的点（按其他都置零
                if(xx == 1) {                                           //控制某些情况下点 等号 后出现 0
                    textView.setText("0");
                    xx = 0;
                }
                if(first == "0" && hehe == 0 && second != ""){      //如果第一个字符为 0 且 第二个字符不为空字符
                    sum2 = Double.parseDouble(second);
                    sum1 = 0;
                    hehe = 1;
                    if(op == 1) {
                        result = sum2;
                        lianDian = 1;
                    }
                    if(op == 2){
                        result = -sum2;
                        lianDian = 2;
                    }
                    if(op == 3) {
                        result = 0;
                        lianDian = 3;
                    }
                    if(op == 4){
                        result = 0;
                        lianDian = 4;
                    }
                    //NumberFormat nf = NumberFormat.getInstance();
                    nf.setMaximumFractionDigits(15);
                    textView.setText(String.valueOf(nf.format(result)));
                    sum1 = result;//*******************
                    sum = result;
                }
                else {
                    if (lianDian == 1) {
                        result = sum + sum2;
                        //NumberFormat nf = NumberFormat.getInstance();
                        nf.setMaximumFractionDigits(15);
                        textView.setText(String.valueOf(nf.format(result)));
                        sum = result;
                        t = 1;
                    }
                    if (lianDian == 2) {
                        result = sum - sum2;
                        //NumberFormat nf = NumberFormat.getInstance();
                        nf.setMaximumFractionDigits(15);
                        textView.setText(String.valueOf(nf.format(result)));
                        sum = result;
                        t = 1;
                    }
                    if (lianDian == 3) {
                        result = sum * sum2;
                        //NumberFormat nf = NumberFormat.getInstance();
                        nf.setMaximumFractionDigits(15);
                        textView.setText(String.valueOf(nf.format(result)));
                        sum = result;
                        t = 1;
                    }

                    if (lianDian == 4) {
                        if(sum2 != 0) result = sum / sum2;
                        //NumberFormat nf = NumberFormat.getInstance();
                        nf.setMaximumFractionDigits(15);
                        textView.setText(String.valueOf(nf.format(result)));
                        sum = result;
                        t = 1;
                    }
                    if (op == 1 && t != 1) {
                        if(x == 0) {
                            if(pp == 0)sum1 = Double.parseDouble(first);//!!!!删除该语句补了（99平方 +1崩溃）
                            else pp = 0;
                            if("".equals(second)) {
                                sum2 = sum1;
                                result = sum1 + sum;//修改
                            }
                            else{
                                //sum2 = Double.parseDouble(second);//！！！！！！！！！！！！！！最近修改
                                result = sum1 + sum;
                            }
                        }
                        if(x == 1){
                            //刚修改部分 用于修补连续两次+=程序崩溃的情况
                            if("".equals(second)) {
                                sum2 = sum1;
                                result = sum1 + sum;//修改
                            }
                            //刚修改部分用于修补连续两次+=程序崩溃的情况
                            else{
                                //sum2 = Double.parseDouble(second);！！！！！！！！！！！！！！！！最近修改
                                result = result + sum;
                                sum2 = sum;//用于解决四则运算符 + 等号bug
                            }
                        }
                        //NumberFormat nf = NumberFormat.getInstance();
                        nf.setMaximumFractionDigits(15);
                        textView.setText(String.valueOf(nf.format(result)));
                        sum = result;
                        lianDian = 1;
                        x = 1;
                    }
                    if (op == 2 && t != 1) {
                        if(x == 0) {
                            if(pp == 0)sum1 = Double.parseDouble(first);//!!!!删除该语句补了（99平方 +1崩溃）
                            else pp = 0;
                            if("".equals(second)) {
                                sum2 = sum1;
                                result = sum1 - sum;//修改
                            }
                            else{
                                //sum2 = Double.parseDouble(second);！！！！！！！！！！！！！！！！最近修改
                                result = sum1 - sum;
                            }
                        }
                        if(x == 1){
                            if("".equals(second)) {
                                sum2 = sum1;
                                result = sum1 - sum;//修改
                            }
                            else{
                                //sum2 = Double.parseDouble(second);！！！！！！！！！！！！！！！！最近修改
                                result = result - sum;
                                sum2 = sum;//用于解决四则运算符 + 等号bug
                            }
                        }
                        //NumberFormat nf = NumberFormat.getInstance();
                        nf.setMaximumFractionDigits(15);
                        textView.setText(String.valueOf(nf.format(result)));
                        sum = result;
                        sum1 = result;
                        lianDian = 2;
                        x = 1;
                    }

                    if (op == 3 && t != 1) {
                        if(x == 0) {
                            if(pp == 0)sum1 = Double.parseDouble(first);//!!!!删除该语句补了（99平方 +1崩溃）
                            else pp = 0;
                            if("".equals(second)) {
                                sum2 = sum1;
                                result = sum1 * sum;//修改
                            }
                            else{
                                //sum2 = Double.parseDouble(second);！！！！！！！！！！！！！！！！最近修改
                                result = sum1 * sum;
                            }
                        }
                        if(x == 1){
                            if("".equals(second)) {
                                sum2 = sum1;
                                result = sum1 * sum;//修改
                            }
                            else{
                                //sum2 = Double.parseDouble(second);！！！！！！！！！！！！！！！！最近修改
                            result = result * sum;
                            sum2 = sum;//用于解决四则运算符 + 等号bug
                            }
                        }
                        //NumberFormat nf = NumberFormat.getInstance();
                        nf.setMaximumFractionDigits(15);
                        textView.setText(String.valueOf(nf.format(result)));
                        sum = result;
                        sum1 = result;//*******************
                        lianDian = 3;
                        x = 1;
                    }

                    if (op == 4 && t != 1) {
                        if(x == 0) {
                            if(pp == 0)sum1 = Double.parseDouble(first);//!!!!删除该语句补了（99平方 +1崩溃）
                            else pp = 0;
                            if("".equals(second)) {
                                sum2 = sum1;
                                result = sum1 / sum;
                                if(sum1 != 0) ppp = 1;//用与控制非零数除以0 输出除数不能为0
                                if(sum2 != 0) result = sum1 / sum;
                                else kk = 1;
                            }
                            else{
                                if(sum1 != 0) ppp = 1;//用与控制非零数除以0 输出除数不能为0
                                //sum2 = Double.parseDouble(second);！！！！！！！！！！！！！！！！最近修改
                                if(/*sum2*/sum != 0) {
                                    result = sum1 / sum;
                                }
                            }
                        }
                        if(x == 1){
                            if("".equals(second)) {
                                sum2 = sum1;
                                result = sum1 / sum;
                                if(sum1 != 0) ppp = 1;//用与控制非零数除以0 输出除数不能为0
                                if(sum2 != 0) result = sum1 / sum;
                                else kk = 1;
                            }
                            else {
                                if(result != 0) ppp = 1;//用与控制非零数除以0 输出除数不能为0
                                //sum2 = Double.parseDouble(second);！！！！！！！！！！！！！！！！最近修改
                                if (/*sum2*/sum != 0) {
                                    result = result / sum;
                                    sum2 = sum;//用于解决四则运算符 + 等号bug
                                }
                            }
                        }
                        //NumberFormat nf = NumberFormat.getInstance();
                        nf.setMaximumFractionDigits(15);
                        textView.setText(String.valueOf(nf.format(result)));
                        sum = result;
                        sum1 = result;//*******************
                        lianDian = 4;
                        x = 1;
                    }
                }
                if((op == 4 || lianDian == 4) && sum2 == 0 ){
                    if(ppp == 1) {//用与控制非零数除以0 输出除数不能为0
                        textView.setText("除数不能为0");
                        ppp = 0;
                    }
                    else if(sum1 == 0 || result == 0 || kk == 1) textView.setText("结果未定义");
                    flag = true; k = 0; op = 0; lianDian = 0; result = 0; sum1 = 0; sum2 = 0; m = 0; quLing = 0; lingHouDian =0; first = "0";
                    second = ""; dengHouDian = 0;  t = 0;  d = 0 ;p = 0; sum = 0; x = 0;od = 0;hehe = 0;yy = 0;
                    xx = 1;q = 0;qq = 0;a = 0;pp = 0;  kk = 0;fudian = 0;ffudian = 0;//防止产生两个点
                }
                else{
                    dengHouDian = 1;
                    t = 0;
                    m = 1;
                    q = 0;//修补2.00 按等号 后再按数 按点的bug
                }
            }
        });
//绑定 = 的监听事件！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！

//绑定 0 到 9 的监听事件
//绑定按钮 0  的监听事件
        btn_0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                aaa = 0;//用于修补四则运算后不能退位的情况
                ppt = 0;//用于使平方后退位失灵
                bfudian = 0;//保存产生的点（按其他都置零
                if(a == 1){//修补按平方后再按数字的bug
                    flag = true; k = 0; op = 0; /*lianDian = 0;*/ result = 0; sum1 = 0; /*sum2 = 0; */m = 0; quLing = 0; lingHouDian =0; first = "0";
                    second = ""; /*!!*/dengHouDian = 0;  t = 0;  d = 0 ;p = 0;  sum = 0; x = 0;od = 0;hehe = 0;yy = 0;fudian = 0;ffudian = 0;//防止产生两个点
                    xx = 0;//！！q = 0;
                    a = 0;//修补按平方后再按数字的bug
                    pp = 0;//待确定
                }
                yy = 0;//修补了 6 + 5= 平方再加的bug
                if(dengHouDian == 1){                          //除了quling 其余同 1
                    op = 0;
                    first = "0";
                    textView.setText("0");
                    first = first.replaceFirst(",","");//!!!!!!!!!!!!!!!!!!!!!!!!!!!修复了遇到，系统崩溃的bug
                    sum1 = Double.parseDouble(first);
                    sum = sum1;
                    flag = false;
                    dengHouDian = 0;
                    quLing = 0;                                     //为了防止00 或者 01的出现(QULING == 0 表示不会出现缀连）
                    x = 0;
                }
                if(op == 0){
                    if(flag == true){
                        first = "0";
                        textView.setText("0");
                        sum1 = Double.parseDouble(first);
                        sum = sum1;
                        flag = false;
                        k = 1;//k = 0;                                    //避免多个小数点 出现？？
                        quLing = 0;                                 //为了防止00 或者 01的出现 (QULING == 0 表示不会出现缀连）
                    }
                    else if(flag == false && quLing == 1){
                        first = first + "0";
                        first = first.replaceFirst(",","");//!!!!!!!!!!!!!!!!!!!!!!!!!!!修复了遇到，系统崩溃的bug
                        textView.setText(first);
                        sum1 = Double.parseDouble(first);
                        sum = sum1;
                        k = 1;                                      ////避免多个小数点 出现？？
                    }
                }
                if(op != 0){
                    if(flag == true){
                        second = "0";
                        textView.setText("0");
                        sum2 = Double.parseDouble(second);
                        sum = sum2;
                        flag = false;
                        k = 1;//k = 0;                                          //避免多个小数点 出现？？
                        quLing = 0;
                    }
                    else if(flag == false && quLing == 1){
                        second = second + "0";
                        second = second.replaceFirst(",","");//!!!!!!!!!!!!!!!!!!!!!!!!!!!修复了遇到，系统崩溃的bug
                        textView.setText(second);
                        sum2 = Double.parseDouble(second);
                        sum = sum2;
                        k = 1;                                          //避免多个小数点 出现？？
                    }
                }
                m = 0;                                                          //用于判断四则运算敲击次数
                ooo = 1;//用于修复按点0再按加减的bug
            }
        });
//绑定按钮 1 的监听事件
        btn_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                aaa = 0;//用于修补四则运算后不能退位的情况
                ooo = 0;//用于修复按点0再按加减的bug           ！！！！！！！！！！！！！！！！！2-9还未改
                ppt = 0;//用于使平方后退位失灵
                bfudian = 0;//保存产生的点（按其他都置零
                if(a == 1){//修补按平方后再按数字的bug
                    flag = true; k = 0; op = 0; /*lianDian = 0;*/ result = 0; sum1 = 0; /*sum2 = 0; */m = 0; quLing = 0; lingHouDian =0; first = "0";
                    second = ""; /*!!*/dengHouDian = 0;  t = 0;  d = 0 ;p = 0;  sum = 0; x = 0;od = 0;hehe = 0;yy = 0;fudian = 0;ffudian = 0;//防止产生两个点
                    xx = 0;//！！q = 0;
                    a = 0;//修补按平方后再按数字的bug
                    pp = 0;//待确定
                }
                yy = 0;//实验！！！！！！！！！！！
                d = 0;                                                   //防止11的出现（只让该if语句执行一次）后面不执行
                if(dengHouDian == 1 ){                       //按等号后发生的事
                    op = 0;                                    //四则运算符置零
                    first = "1";                              //第一个字符串变为 1
                    textView.setText("1");                      //屏幕输出按该键显示数
                    sum1 = Double.parseDouble(first);          //(double)sum1 记录此时的第一个字符串的值 （类型转化）
                    sum = sum1;                                 //记录屏幕上显示的值
                    flag = false;                               //该按键不是第一次点击
                    dengHouDian = 0;                            //防止以后再按数字键（未按等号）执行该语句
                    d = 1;                                      //防止 11 出现（只让该if语句执行一次）后面不执行
                    x = 0;                                      //实现1 + 1 + 1？？
                }
                if(op == 0 && d == 0){                              //判断输出在 双目运算符前面还是后面 和 防止执行前一if语句后再执行 后面flag = false
                    if(flag == true){                        //判断是否为第一次按 1（因为初始值默认为 0 如果直接执行下面语句会出现 01
                        first = "1";                                 //将first 字符串 变为 1
                        textView.setText("1");                       //显示 1
                        sum1 = Double.parseDouble(first);           //将first字符串转化为double 类型输出
                        sum = sum1;                                     //记录当前界面显示值
                        flag = false;                            //使下一次点 1 为下一语句输出输出情况
                        k = 1;                                   //用来避免多个小数点出现？？？（k = 0 执行 0. k = 1执行 加点 k = 2什么都不执行！！
                    }
                    else if(flag == false){                     //在已有数字上再缀连的语句
                        if(quLing == 1)                         //用于排除 0000的出现？？？
                            first = first + "1";            //在当前字符串基础上 加 1
                        else
                            first = "1";                 //直接输出 1
                        first = first.replaceFirst(",","");//!!!!!!!!!!!!!!!!!!!!!!!!!!!修复了遇到，系统崩溃的bug
                        textView.setText(first);//输出该 first 字符串对应值
                        sum1 = Double.parseDouble(first);           //将first 字符串值转化为（double）sum1     sum1用于（加数）//!!!!!!!出错点
                        sum = sum1;                                 //*将sum1 的值赋给 记录界面 显示值 sum
                        k = 1;                                   //用来避免多个小数点出现？？？
                    }
                }
                if(op != 0 && d == 0){                          //此时 已点击四则运算符 准备产生 sum2 和（防止执行前一if语句后再执行 后面flag = false）
                    if(flag == true){                           //判断是否为第一次按 1（因为初始值默认为 0 如果直接执行下面语句会出现 01
                        second = "1";                               ////将second 字符串 变为 1
                        textView.setText("1");                      //输出字符串 1
                        sum2 = Double.parseDouble(second);      //记录（被加数）
                        sum = sum2;                                          //记录界面显示值
                        flag = false;                                    //防止输出下一 if语句
                        k = 1;                                       //用来避免多个小数点出现？？？
                    }
                    else if(flag == false){                          //在已有数字上再缀连的语句
                        if(quLing == 1)                                     ////用于排除 00或者 01的出现
                            second= second + "1";
                        else                                            //单纯将second字符串值转为 1
                            second = "1";
                        second = second.replaceFirst(",","");//!!!!!!!!!!!!!!!!!!!!!!!!!!!修复了遇到，系统崩溃的bug
                        textView.setText(second);                                   //输出字符串 值
                        sum2 = Double.parseDouble(second);                      //将字符串 值记录给 被（加）数
                        sum = sum2;                                         //记录界面上的数
                        k = 1;                                   //用来避免多个小数点出现？？？
                    }
                }
                quLing = 1;                                     //用于排除 00或者 01的出现
                m = 0;                                          //用于判断四则运算敲击次数？？？
            }
        });

 //绑定 0 到 9 的监听事件

 //小数点  小数点  小数点  小数点  小数点  小数点  小数点  小数点  小数点  小数点  小数点  小数点
//绑定  . 的监听事件
        btn_dian.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                aaa = 0;//用于修补四则运算后不能退位的情况
                ppt = 0;//用于使平方后退位失灵
                //bfudian = 0;//保存产生的点（按其他都置零
                if(a == 1){//修补按平方后再按数字的bug
                    flag = true; k = 0; op = 0; /*lianDian = 0;*/ result = 0; sum1 = 0; /*sum2 = 0; */m = 0; quLing = 0; lingHouDian =0; first = "0";
                    second = ""; /*!!*/dengHouDian = 0;  t = 0;  d = 0 ;p = 0;  sum = 0; x = 0;od = 0;hehe = 0;yy = 0;fudian = 0;ffudian = 0;//防止产生两个点
                    xx = 0;//！！q = 0;
                    a = 0;//修补按平方后再按数字的bug
                    pp = 0;//待确定
                }
                yy = 0;//实验！！！！！！！！！！！
                quLing = 1;                         //用于排除 00或者 01的出现
                m = 0;                                       //用于判断四则运算敲击次数？？？
                if(dengHouDian == 1){
                    op = 0;
                    first = "0.";
                    textView.setText("0.");
                    sum1 = Double.parseDouble(first);
                    sum = sum1;
                    k = 2;                                       //用来避免多个小数点出现？？？（k = 0 执行 0. k = 1执行 加点 k = 2什么都不执行！！
                    flag = false;
                    dengHouDian = 0;
                    x = 0;                                      //实现1 + 1 + 1？？
                }
                if(op == 0){
                        if (k == 0) {
                            first = "0.";
                            textView.setText("0.");
                            sum1 = Double.parseDouble(first);
                            sum = sum1;
                            k = 2;
                            flag = false;
                        }
                        else if (k == 1 && q == 0 && first.indexOf(".") == -1) {
                            first = first + ".";
                            first = first.replace(",","");//!!!!!!!!!!!!!!!!!!!!!!!!!!!修复了遇到，系统崩溃的bug
                            textView.setText(first);
                            sum1 = Double.parseDouble(first);
                            sum = sum1;
                            k = 2;
                            flag = false;
                            q = 1;                                  //除去按2.2.2.2崩溃的bug
                        }
                }
                else if(op != 0){
                    if(lingHouDian == 1 && k == 0){
                        second = "0.";
                        textView.setText("0.");
                        sum2 = Double.parseDouble(second);
                        sum = sum2;//******************
                        k = 2;
                        flag = false;
                    }
                     else {
                        if (k == 0) {
                            second = "0.";
                            textView.setText("0.");
                            sum2 = Double.parseDouble(second);
                            sum = sum2;//******************
                            k = 2;
                            flag = false;
                        } else if (k == 1 && qq == 0 && second.indexOf(".") == -1) {//修补按 + 2.2崩溃的bug
                            second = second + ".";
                            second = second.replace(",","");//!!!!!!!!!!!!!!!!!!!!!!!!!!!修复了遇到，系统崩溃的bug
                            textView.setText(second);
                            sum2 = Double.parseDouble(second);
                            sum = sum2;//******************
                            k = 2;
                            flag = false;
                            qq = 1;//修补按 + 2.2崩溃的bug
                        }
                    }
                }
                if(ffudian == 0) fudian = 1;
            }
        });
 //小数点  小数点  小数点  小数点  小数点  小数点  小数点  小数点  小数点  小数点  小数点  小数点

 //单目运算 单目运算 单目运算 单目运算 单目运算 单目运算 单目运算 单目运算 单目运算 单目运算 单目运算
// 绑定 根号 的监听事件
        btn_genhao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                aaa = 0;//用于修补四则运算后不能退位的情况
                ooo = 0;//用于修复按点0再按加减的bug
                bfudian = 0;//保存产生的点（按其他都置零
                if(sum >= 0){
                    NumberFormat nf = NumberFormat.getInstance();
                    nf.setMaximumFractionDigits(15);
                    if(yy == 0){                                        //实现 根号 加 这一神奇现象
                        if(sum == sum1){                                    //判断该显示值为那类值从而进行修改
                            sum  = Math.sqrt(sum);
                            first = String.valueOf(nf.format(sum));
                            sum1 = sum;
                        }
                        else if(sum == sum2) {
                            sum  = Math.sqrt(sum);
                            second = String.valueOf(nf.format(sum));
                            sum2 = sum;
                        }
                        else if(sum == result) {
                            sum  = Math.sqrt(sum);
                            first = String.valueOf(nf.format(sum));
                            result = sum;
                        }
                    }
                    else{
                        sum  = Math.sqrt(sum);
                        second = String.valueOf(nf.format(sum));                //默认为第二操作数
                        sum2 = sum;
                        yy = 0;
                    }
                    textView.setText(String.valueOf(nf.format(sum)));
                }
                else {                                                      //数学没学好的人按了的下场
                    textView.setText("无效输入");
                    flag = true; k = 0; op = 0; lianDian = 0; result = 0; sum1 = 0; sum2 = 0; m = 0; quLing = 0; lingHouDian =0; first = "0";
                    second = ""; dengHouDian = 0;  t = 0;  d = 0 ;p = 0;  sum = 0; x = 0;od = 0;hehe = 0;yy = 0;fudian = 0;ffudian = 0;//防止产生两个点
                    xx = 1;q = 0;qq = 0;a = 0;pp = 0;
                }
                a = 1;//修补按平方后再按数字的bug
                pp = 1;//修补99平方加1
                ppt = 1;//用于使平方后退位失灵
//在按了单目运算后按 任何数字都是直接复原
            }
        });
//绑定 平方 的监听事件
        btn_pingfang.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                    aaa = 0;//用于修补四则运算后不能退位的情况
                    ooo = 0;//用于修复按点0再按加减的bug
                    bfudian = 0;//保存产生的点（按其他都置零
                    NumberFormat nf = NumberFormat.getInstance();
                    nf.setMaximumFractionDigits(15);
                    if(yy == 0){
                        if(sum == sum1 && sum != sum2){
                            sum  = Math.pow(sum,2);
                            first = String.valueOf(nf.format(sum));
                            sum1 = sum;
                        }
                        else if(sum == sum2) {//修补1+2=再平方的bug
                            sum  = Math.pow(sum,2);
                            second = String.valueOf(nf.format(sum));
                            sum2 = sum;
                        }
                        else if(sum == result) {
                            sum  = Math.pow(sum,2);
                            first = String.valueOf(nf.format(sum));
                            result = sum;
                        }
                    }
                    else{
                        sum  = Math.pow(sum,2);
                        second = String.valueOf(nf.format(sum));
                        sum2 = sum;
                        yy = 0;
                    }
                    textView.setText(String.valueOf(nf.format(sum)));
                    a = 1;//修补按平方后再按数字的bug
                    pp = 1;//修补99平方加1
                    ppt = 1;//用于使平方后退位失灵
            }
        });
//绑定 倒数 的监听事件
        btn_daoshu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                        aaa = 0;//用于修补四则运算后不能退位的情况
                        ooo = 0;//用于修复按点0再按加减的bug
                        bfudian = 0;//保存产生的点（按其他都置零
                        if(sum != 0) {
                            NumberFormat nf = NumberFormat.getInstance();
                            nf.setMaximumFractionDigits(15);
                            if(yy == 0){
                                if(sum == sum1 && sum != sum2){
                                    sum = 1 / sum;
                                    first = String.valueOf(nf.format(sum));
                                    sum1 = sum;
                                }
                                else if(sum == sum2) {
                                    sum = 1 / sum;
                                    second = String.valueOf(nf.format(sum));
                                    sum2 = sum;
                                }
                                else if(sum == result) {
                                    sum = 1 / sum;
                                    first = String.valueOf(nf.format(sum));
                                    result = sum;
                                }
                            }
                            else{
                                sum = 1 / sum;
                                second = String.valueOf(nf.format(sum));
                                sum2 = sum;
                                yy = 0;
                            }
                            textView.setText(String.valueOf(nf.format(sum)));
                        }
                        else{
                            textView.setText("除数不能为0");
                            flag = true; k = 0; op = 0; lianDian = 0; result = 0; sum1 = 0; sum2 = 0; m = 0; quLing = 0; lingHouDian =0; first = "0";
                            second = ""; dengHouDian = 0;  t = 0;  d = 0 ;p = 0; sum = 0; x = 0;od = 0;hehe = 0;fudian = 0;ffudian = 0;//防止产生两个点
                            xx = 1;q = 0;qq = 0;a = 0;pp = 0;
                        }
                        a = 1;//修补按平方后再按数字的bug
                        pp = 1;//修补99平方加1
                        ppt = 1;//用于使平方后退位失灵
            }
        });
//绑定 加减号 的监听事件
        //11.1在这里修复了 0 ± ±bug
        btn_jiajian.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                    aaa = 0;//用于修补四则运算后不能退位的情况
                    NumberFormat nf = NumberFormat.getInstance();
                    nf.setMaximumFractionDigits(15);
                    if(yy == 0){
                        if(sum == 0  && (first.indexOf(".") != -1) && second == ""){
                            double dzz = Double.parseDouble(first + "1");
                            if(dzz > 0) first = "-" + first;
                            else first = first.replaceFirst("-","");
                            textView.setText(first);
                        }
                        else if(sum == 0  && (second.indexOf(".") != -1)){//有点
                            double dzz = Double.parseDouble(second + "1");
                            if(dzz > 0) second = "-" + second;
                            else second = second.replaceFirst("-","");
                            textView.setText(second);
                        }
                        else if(sum == sum1 && sum != sum2){
                            sum  = 0 - sum;
                            if(ooo == 0) first = String.valueOf(nf.format(sum));
                            else{
                                if(first.indexOf("-") == -1 && first.indexOf(".") != -1) first = "-" + first;
                                else first = first.replaceFirst("-","");
                            }
                            first = first.replace(",","");
                            //防止按了四则运算符再按 ±就有点
                            if( (fudian == 1 || bfudian == 1)  && (first.indexOf(".") == -1) ){//防止两个点出现
                                first = first +".";
                                fudian = 0;
                                bfudian = 1;
                                ffudian = 1;
                                fffudian = 1;
                            }
                            sum1 = sum;
                            if(first == "") first = "0";
                            textView.setText(first);
                        }
                        else if(sum == sum2 && op != 0) {//修补 0±
                            sum = 0 - sum;
                            if(ooo == 0) second = String.valueOf(nf.format(sum));
                            else{
                                if(second.indexOf("-") == -1 && second.indexOf(".") != -1) second = "-" + second;//修补有负号 无点输出修补 0±
                                else second = second.replaceFirst("-","");
                            }
                            second = second.replace(",","");
                            if( (fudian == 1 || bfudian == 1)  && (second.indexOf(".") == -1)){
                                second = second +".";
                                fudian = 0;
                                bfudian = 1;
                                ffudian = 1;
                                fffudian = 1;
                            }
                            sum2 = sum;
                            if(second == "") second = "0";
                            textView.setText(second);
                        }
                        else if(sum == result ) {//防止按了四则运算符再按 ±就有点
                            sum = 0 - sum;
                            if(ooo == 0) first = String.valueOf(nf.format(sum));
                            else{
                                if(first.indexOf("-") == -1 && first.indexOf(".") != -1) first = "-" + first;
                                else first = first.replaceFirst("-","");
                            }
                            if( (fudian == 1 || bfudian == 1)  && (first.indexOf(".") == -1)){
                                first = first +".";
                                fudian = 0;
                                bfudian = 1;
                                ffudian = 1;
                                fffudian = 1;
                            }
                            result = sum;
                            if(first == "") first = "0";
                            textView.setText(first);
                        }
                    }
                    else{
                        int pppp = 0;//用于修补2 + ±bug
                        if(second.indexOf(".") != -1) pppp = 1;
                        sum = 0 - sum;
                        if(ooo == 0) second = String.valueOf(nf.format(sum));
                        else{
                            if(second.indexOf("-") == -1) second = "-" + second;
                            else second = second.replaceFirst("-","");
                        }
                        if((fudian == 1 || bfudian == 1|| ffudian == 0) && (second.indexOf(".") == -1) && pppp == 1){
                            second = second +".";
                            fudian = 0;
                            bfudian = 1;
                            ffudian = 1;
                            fffudian = 1;
                            pppp = 0;
                        }
                        sum2 = sum;
                        textView.setText(second);
                        yy = 0;
                    }
                    pp = 1;//修补99平方加1
                //123±点！！！！！！！！！！
            }
        });
//单目运算 单目运算 单目运算 单目运算 单目运算 单目运算 单目运算 单目运算 单目运算 单目运算 单目运算

//双目运算 双目运算 双目运算 双目运算 双目运算 双目运算 双目运算 双目运算 双目运算 双目运算 双目运算
// 绑定 加 号 的监听事件
        btn_jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aaa = 1;//用于修补四则运算后不能退位的情况
                ooo = 0;//用于修复按点0再按加减的bug
                ppt = 0;//用于使平方后退位失灵
                a = 0;//用于实现按了根号后再按四则运算符可以运算
                bfudian = 0;//保存产生的点（按其他都置零
                if(m == 0 /*&& dengHouDian == 1*/){
                    if(op == 1 && second != "") {                     //排除连续点两次加崩溃
                        if(sum1 == 0) sum1 = Double.parseDouble(first);
                        sum2 = Double.parseDouble(second);
                        result = sum1 + sum2;//加号篡改了我需要输出的值
                        NumberFormat nf = NumberFormat.getInstance();
                        nf.setMaximumFractionDigits(15);
                        textView.setText(String.valueOf(nf.format(result)));
                        first = result + "";//修补1+2+3 = 6bug
                        sum1 = result;
                        sum = result;
                        m = 1;
                    }
                    else if(op == 2 && second != "") {
                        if(sum1 == 0) sum1 = Double.parseDouble(first);
                        sum2 = Double.parseDouble(second);
                        result = sum1 - sum2;
                        NumberFormat nf = NumberFormat.getInstance();
                        nf.setMaximumFractionDigits(15);
                        textView.setText(String.valueOf(nf.format(result)));
                        first = result + "";//修补1+2+3 = 6bug
                        sum1 = result;
                        sum = result;
                        m = 1;
                    }
                    else if(op == 3 && second != "") {
                        if(sum1 == 0) sum1 = Double.parseDouble(first);
                        sum2 = Double.parseDouble(second);
                        result = sum1 * sum2;
                        NumberFormat nf = NumberFormat.getInstance();
                        nf.setMaximumFractionDigits(15);
                        textView.setText(String.valueOf(nf.format(result)));
                        first = result + "";//修补1+2+3 = 6bug
                        sum1 = result;
                        sum = result;
                        m = 1;
                    }
                    else if(op == 4 && second != "") {
                        if(sum1 == 0) sum1 = Double.parseDouble(first);
                        sum2 = Double.parseDouble(second);
                        if(sum2 != 0) result = sum1 / sum2;
                        NumberFormat nf = NumberFormat.getInstance();
                        nf.setMaximumFractionDigits(15);
                        textView.setText(String.valueOf(nf.format(result)));
                        first = result + "";//修补1+2+3 = 6bug
                        sum1 = result;
                        sum = result;
                        m = 1;
                    }
                }
                if(sum2 == 0 && op == 4 && second != ""){
                    textView.setText("除数不能为0");
                    flag = true; k = 0; op = 0; lianDian = 0; result = 0; sum1 = 0; sum2 = 0; m = 0; quLing = 0; lingHouDian =0; first = "0";
                    second = ""; dengHouDian = 0; t = 0;  d = 0 ;p = 0; sum = 0; x = 0;od = 0;hehe = 0;yy =0;fudian = 0;ffudian = 0;//防止产生两个点
                    xx = 1;q = 0;qq = 0;a = 0;pp = 0;
                }
                else {
                    op = 1;
                    flag = true;
                    lingHouDian = 1;
                    k = 0;
                    dengHouDian = 0;
                    lianDian = 0;
                    yy = 1;//用于控制单目运算后 加 等号 (8 +平方*/
                }
            }
        });
//绑定 除 号 的监听事件
        btn_chu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aaa = 1;//用于修补四则运算后不能退位的情况
                ooo = 0;//用于修复按点0再按加减的bug
                ppt = 0;//用于使平方后退位失灵
                bfudian = 0;//保存产生的点（按其他都置零
                a = 0;//用于实现按了根号后再按四则运算符可以运算
                if(m == 0 /*&& dengHouDian == 1*/){
                    if(op == 1 && second != "") {
                        if(sum1 == 0) sum1 = Double.parseDouble(first);
                        sum2 = Double.parseDouble(second);
                        result = sum1 + sum2;
                        NumberFormat nf = NumberFormat.getInstance();
                        nf.setMaximumFractionDigits(15);
                        textView.setText(String.valueOf(nf.format(result)));
                        first = result + "";//修补1+2+3 = 6bug
                        sum1 = result;
                        sum = result;
                        m = 1;
                    }
                    else if(op == 2 && second != "") {
                        if(sum1 == 0) sum1 = Double.parseDouble(first);
                        sum2 = Double.parseDouble(second);
                        result = sum1 - sum2;
                        NumberFormat nf = NumberFormat.getInstance();
                        nf.setMaximumFractionDigits(15);
                        textView.setText(String.valueOf(nf.format(result)));
                        first = result + "";//修补1+2+3 = 6bug
                        sum1 = result;
                        sum = result;
                        m = 1;
                    }
                    else if(op == 3 && second != "") {
                        if(sum1 == 0) sum1 = Double.parseDouble(first);
                        sum2 = Double.parseDouble(second);
                        result = sum1 * sum2;
                        NumberFormat nf = NumberFormat.getInstance();
                        nf.setMaximumFractionDigits(15);
                        textView.setText(String.valueOf(nf.format(result)));
                        first = result + "";//修补1+2+3 = 6bug
                        sum1 = result;
                        sum = result;
                        m = 1;
                    }
                    else if(op == 4 && second != "") {
                        if(sum1 == 0) sum1 = Double.parseDouble(first);
                        sum2 = Double.parseDouble(second);
                        if(sum2 != 0) result = sum1 / sum2;
                        NumberFormat nf = NumberFormat.getInstance();
                        nf.setMaximumFractionDigits(15);
                        textView.setText(String.valueOf(nf.format(result)));
                        first = result + "";//修补1+2+3 = 6bug
                        sum1 = result;
                        sum = result;
                        m = 1;
                    }
                }
                if(sum2 == 0 && op == 4 && second !=""){
                    textView.setText("除数不能为0");
                    flag = true; k = 0; op = 0; lianDian = 0; result = 0; sum1 = 0; sum2 = 0; m = 0; quLing = 0; lingHouDian =0; first = "0";
                    second = ""; dengHouDian = 0;  t = 0;  d = 0 ;p = 0; sum = 0; x = 0;od = 0;hehe = 0;yy = 0;fudian = 0;ffudian = 0;//防止产生两个点
                    xx = 1;q = 0;qq = 0;a = 0;pp = 0;
                }
                else {
                    op = 4;
                    flag = true;
                    lingHouDian = 1;
                    k = 0;
                    dengHouDian = 0;
                    lianDian = 0;
                    yy = 1;//用于控制单目运算后 加 等号
                }
            }
        });
//双目运算 双目运算 双目运算 双目运算 双目运算 双目运算 双目运算 双目运算 双目运算 双目运算 双目运算

//清除 清除 清除 清除 清除 清除 清除 清除 清除 清除 清除 清除 清除 清除 清除 清除 清除 清除 清除 清除
//绑定 清除（C）的监听事件
        btn_C.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                textView.setText("0");
                flag = true; k = 0; op = 0; lianDian = 0; result = 0; sum1 = 0; sum2 = 0; m = 0; quLing = 0; lingHouDian =0; first = "0";
                second = ""; dengHouDian = 0;  t = 0;  d = 0 ;p = 0;sum = 0; x = 0;od = 0;hehe = 0;fudian = 0;ffudian = 0;//防止产生两个点
                xx = 0;yy = 0;q = 0;qq = 0;a = 0;pp = 0;bfudian = 0;//保存产生的点（按其他都置零
                 ppt = 0;//用于使平方后退位失灵
                ooo = 0;//用于修复按点0再按加减的bug
                hehe = 0;
                kk = 0;
                fffudian = 0;
                aaa = 0;//用于修补四则运算后不能退位的情况
            }
        });
//绑定清除（CE）的监听事件
        btn_CE.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                aaa = 0;//用于修补四则运算后不能退位的情况
                flag = true;//排除按了该键在按0的bug
                bfudian = 0;//保存产生的点（按其他都置零
                ffudian = 0;//防止产生两个点
                fudian = 0;
                ooo = 0;//用于修复按点0再按加减的bug
                k = 0;q = 0;qq = 0; /*op = 0;lianDian = 0;  result = 0; sum1 = 0; sum2 = 0;*m = 0;*/ quLing = 0; lingHouDian =0; /*first = "0";
                second = ""; dengHouDian = 0;  t = 0;  d = 0 ;p = 0;sum = 0; x = 0;od = 0;hehe = 0;fudian = 0;ffudian = 0;//防止产生两个点
                xx = 0;yy = 0;q = 0;qq = 0;a = 0;pp = 0;bfudian = 0;//保存产生的点（按其他都置零
                ppt = 0;//用于使平方后退位失灵
                ffudian = 0;*/

                if(sum == sum1 && op == 0) {
                    first = "0";
                    textView.setText(first);
                    sum = Double.parseDouble(first);
                    sum1 = Double.parseDouble(first);
                }
                else if(sum == sum2 || (sum == sum1 && op !=0)){
                    second = "0";
                    textView.setText(second);
                    sum = Double.parseDouble(second);
                    sum2 = Double.parseDouble(second);
                    flag = true;//新家**************************************
                }
                else if(sum == result){
                    result = 0;
                    sum = 0;
                    textView.setText("0");
                    flag = true; k = 0; op = 0;  result = 0; sum1 = 0;  m = 0; quLing = 0; lingHouDian =0; first = "0";
                    second =""; dengHouDian = 0;  t = 0;  d = 0 ;p = 0;sum = 0; x = 0;od = 0;hehe = 0;fudian = 0;
                    xx = 0;yy = 0;q = 0;qq = 0; /*   a不变 */;/*pp不变*/
                    sum2 = sum2;
                    lianDian = lianDian;
                    ppt = 0;//用于使平方后退位失灵
                }
            }
        });
//绑定 退位 的监听事件
        btn_tuiwei.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //11.1修补了1± 退位 等等崩溃bug
                ooo = 0;//用于修复按点0再按加减的bug
                //修复初始界面按0.000按退位无反应的bug
                //qwe用于修补等号后重新按数的bug
                if(sum == sum1 && (sum != sum2 || (sum == 0 && first.indexOf(".")!= -1)) &&/*second == ""&& */first != "" && ppt == 0&&aaa ==0) {//v用于控制平方 开方 倒数
                    first = first.replaceFirst(",","");//!!!!!!!!!!!!!!!!!!!!!!!!!!!修复了遇到，系统崩溃的bug
                    int len1 = first.length();;//分为有符号和没有符号
                    if (len1 == 1 || (len1 == 2 && (first.indexOf("-") != -1 || first.indexOf(".") != -1)) ){
                        first = "0";
                        textView.setText(first);
                        flag = true;//新加*********************************
                    }
                    else if (len1 > 1) {
                        first = first.substring(0, len1 - 1);
                        /*if(first.indexOf(".") == -1)  {
                            bfudian = 0;//保存产生的点（按其他都置零
                            fffudian = 0;
                            //ffudian = 0;//防止产生两个点
                        }*/
                        textView.setText(first);
                    }
                    sum = Double.parseDouble(first);
                    sum1 = Double.parseDouble(first);
                }
                else if(sum == sum2 && second != "" && ppt == 0){
                    second = second.replaceFirst(",","");//!!!!!!!!!!!!!!!!!!!!!!!!!!!修复了遇到，系统崩溃的bug
                    int len2 = second.length();
                    if (len2 == 1 || (len2 == 2 && (second.indexOf("-") != -1|| second.indexOf(".") != -1))) {
                        second = "0";
                        textView.setText(second);
                        flag = true;//新加*********************************
                    }
                    else if (len2 > 1) {
                        second = second.substring(0, len2 - 1);
                        /*if(second.indexOf(".") == -1)  {
                            bfudian = 0;//保存产生的点（按其他都置零
                            fffudian = 0;
                            //ffudian = 0;//防止产生两个点
                        }*/
                        textView.setText(second);
                    }

                    sum = Double.parseDouble(second);
                    sum2 = Double.parseDouble(second);
                }
                if(first == ""  || (second == "" && op != 0)) flag = true;//修补对first存在值后按退位后能再接上值 （暂未发现新bug
                //清除了小数点要保证还能输入！！！！！！！！
            }
        });
//清除 清除 清除 清除 清除 清除 清除 清除 清除 清除 清除 清除 清除 清除 清除 清除 清除 清除 清除 清除
        //绑定按钮 2 的监听事件
        btn_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                aaa = 0;//用于修补四则运算后不能退位的情况
                ooo = 0;//用于修复按点0再按加减的bug
                ppt = 0;//用于使平方后退位失灵
                bfudian = 0;//保存产生的点（按其他都置零
                if(a == 1){//修补按平方后再按数字的bug
                    flag = true; k = 0; op = 0; /*lianDian = 0;*/ result = 0; sum1 = 0; /*sum2 = 0; */m = 0; quLing = 0; lingHouDian =0; first = "0";
                    second = ""; /*!!*/dengHouDian = 0;  t = 0;  d = 0 ;p = 0;  sum = 0; x = 0;od = 0;hehe = 0;yy = 0;fudian = 0;ffudian = 0;//防止产生两个点
                    xx = 0;//！！q = 0;
                    pp = 0;//待确定
                    a = 0;//修补按平方后再按数字的bug
                }
                yy = 0;//实验！！！！！！！！！！！
                d = 0;
                if(dengHouDian == 1){
                    op = 0;
                    first = "2";
                    textView.setText("2");
                    sum1 = Double.parseDouble(first);
                    sum = sum1;
                    flag = false;
                    dengHouDian = 0;
                    d = 1;
                    x = 0;//不确定
                }
                if(op == 0 && d == 0){
                    if(flag == true){
                        first = "2";
                        textView.setText("2");
                        sum1 = Double.parseDouble(first);
                        sum = sum1;
                        flag = false;
                        k = 1;
                    }
                    else if(flag == false){
                        if(quLing == 1)
                            first = first + "2";
                        else
                            first = "2";
                        textView.setText(first);
                        sum1 = Double.parseDouble(first);
                        sum = sum1;
                        k = 1;
                    }
                }
                if(op != 0 && d == 0){
                    sum1 = result;
                    if(flag == true){
                        second = "2";
                        textView.setText("2");
                        sum2 = Double.parseDouble(second);
                        sum = sum2;
                        flag = false;
                        k = 1;
                    }
                    else if(flag == false){
                        if(quLing == 1)
                            second = second + "2";
                        else
                            second = "2";
                        second = second.replaceFirst(",","");//!!!!!!!!!!!!!!!!!!!!!!!!!!!修复了遇到，系统崩溃的bug
                        textView.setText(second);
                        sum2 = Double.parseDouble(second);
                        sum = sum2;
                        k = 1;
                    }
                }
                quLing = 1;
                m = 0;
            }
        });
//绑定按钮 3 的监听事件
        btn_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                aaa = 0;//用于修补四则运算后不能退位的情况
                ooo = 0;//用于修复按点0再按加减的bug
                ppt = 0;//用于使平方后退位失灵
                bfudian = 0;//保存产生的点（按其他都置零
                if(a == 1){//修补按平方后再按数字的bug
                    flag = true; k = 0; op = 0; /*lianDian = 0;*/ result = 0; sum1 = 0; /*sum2 = 0; */m = 0; quLing = 0; lingHouDian =0; first = "0";
                    second = ""; /*!!*/dengHouDian = 0;  t = 0;  d = 0 ;p = 0;  sum = 0; x = 0;od = 0;hehe = 0;yy = 0;fudian = 0;ffudian = 0;
                    xx = 0;//！！q = 0;
                    a = 0;//修补按平方后再按数字的bug
                    pp = 0;//待确定
                }
                yy = 0;//实验！！！！！！！！！！！
                d = 0;
                if(dengHouDian == 1){
                    op = 0;
                    first = "3";
                    textView.setText("3");
                    sum1 = Double.parseDouble(first);
                    sum = sum1;
                    flag = false;
                    dengHouDian = 0;
                    d = 1;
                    x = 0;//不确定
                }
                if(op == 0 && d == 0){
                    if(flag == true){
                        first = "3";
                        textView.setText("3");
                        sum1 = Double.parseDouble(first);
                        sum = sum1;
                        flag = false;
                        k = 1;
                    }
                    else if(flag == false){
                        if(quLing == 1)
                            first = first + "3";
                        else
                            first = "3";
                        first = first.replaceFirst(",","");//!!!!!!!!!!!!!!!!!!!!!!!!!!!修复了遇到，系统崩溃的bug
                        textView.setText(first);
                        sum1 = Double.parseDouble(first);
                        sum = sum1;
                        k = 1;
                    }
                }
                if(op != 0 && d == 0){
                    if(flag == true){
                        second = "3";
                        textView.setText("3");
                        sum2 = Double.parseDouble(second);
                        sum = sum2;
                        flag = false;
                        k = 1;
                    }
                    else if(flag == false){
                        if(quLing == 1)
                            second = second + "3";
                        else
                            second = "3";
                        second = second.replaceFirst(",","");//!!!!!!!!!!!!!!!!!!!!!!!!!!!修复了遇到，系统崩溃的bug
                        textView.setText(second);
                        sum2 = Double.parseDouble(second);
                        sum = sum2;
                        k = 1;
                    }
                }
                quLing = 1;
                m = 0;
            }
        });
//绑定按钮 4 的监听事件
        btn_4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                aaa = 0;//用于修补四则运算后不能退位的情况
                ooo = 0;//用于修复按点0再按加减的bug
                ppt = 0;//用于使平方后退位失灵
                bfudian = 0;//保存产生的点（按其他都置零
                if(a == 1){//修补按平方后再按数字的bug
                    flag = true; k = 0; op = 0; /*lianDian = 0;*/ result = 0; sum1 = 0; /*sum2 = 0; */m = 0; quLing = 0; lingHouDian =0; first = "0";
                    second = ""; /*!!*/dengHouDian = 0;  t = 0;  d = 0 ;p = 0;  sum = 0; x = 0;od = 0;hehe = 0;yy = 0;fudian = 0;ffudian = 0;
                    xx = 0;//！！q = 0;
                    a = 0;//修补按平方后再按数字的bug
                    pp = 0;//待确定
                }
                yy = 0;//实验！！！！！！！！！！！
                d = 0;
                if(dengHouDian == 1){
                    op = 0;
                    first = "4";
                    textView.setText("4");
                    sum1 = Double.parseDouble(first);
                    sum = sum1;
                    flag = false;
                    dengHouDian = 0;
                    d = 1;
                    x = 0;//不确定
                }
                if(op == 0 && d == 0){
                    if(flag == true){
                        first = "4";
                        textView.setText("4");
                        sum1 = Double.parseDouble(first);
                        sum = sum1;
                        flag = false;
                        k = 1;
                    }
                    else if(flag == false){
                        if(quLing == 1)
                            first = first + "4";
                        else
                            first = "4";
                        textView.setText(first);
                        first = first.replaceFirst(",","");//!!!!!!!!!!!!!!!!!!!!!!!!!!!修复了遇到，系统崩溃的bug
                        sum1 = Double.parseDouble(first);
                        sum = sum1;
                        k = 1;
                    }
                }
                if(op != 0 && d == 0){
                    if(flag == true){
                        second = "4";
                        textView.setText("4");
                        sum2 = Double.parseDouble(second);
                        sum = sum2;
                        flag = false;
                        k = 1;
                    }
                    else if(flag == false){
                        if(quLing == 1)
                            second = second + "4";
                        else
                            second = "4";
                        second = second.replaceFirst(",","");//!!!!!!!!!!!!!!!!!!!!!!!!!!!修复了遇到，系统崩溃的bug
                        textView.setText(second);
                        sum2 = Double.parseDouble(second);
                        sum = sum2;
                        k = 1;
                    }
                }
                quLing = 1;
                m = 0;
            }
        });
//绑定按钮 5 的监听事件
        btn_5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                aaa = 0;//用于修补四则运算后不能退位的情况
                ooo = 0;//用于修复按点0再按加减的bug
                ppt = 0;//用于使平方后退位失灵
                bfudian = 0;//保存产生的点（按其他都置零
                if(a == 1){//修补按平方后再按数字的bug
                    flag = true; k = 0; op = 0; /*lianDian = 0;*/ result = 0; sum1 = 0; /*sum2 = 0; */m = 0; quLing = 0; lingHouDian =0; first = "0";
                    second = ""; /*!!*/dengHouDian = 0;  t = 0;  d = 0 ;p = 0;  sum = 0; x = 0;od = 0;hehe = 0;yy = 0;fudian = 0;ffudian = 0;
                    xx = 0;//！！q = 0;
                    a = 0;//修补按平方后再按数字的bug
                    pp = 0;//待确定
                }
                yy = 0;//实验！！！！！！！！！！！
                d = 0;
                if(dengHouDian == 1){
                    op = 0;
                    first = "5";
                    textView.setText("5");
                    sum1 = Double.parseDouble(first);
                    sum = sum1;
                    flag = false;
                    dengHouDian = 0;
                    d = 1;
                    x = 0;
                }
                if(op == 0 && d == 0){
                    if(flag == true){
                        first = "5";
                        textView.setText("5");
                        sum1 = Double.parseDouble(first);
                        sum = sum1;
                        flag = false;
                        k = 1;
                    }
                    else if(flag == false){
                        if(quLing == 1)
                            first = first + "5";
                        else
                            first = "5";
                        first = first.replaceFirst(",","");//!!!!!!!!!!!!!!!!!!!!!!!!!!!修复了遇到，系统崩溃的bug
                        textView.setText(first);
                        sum1 = Double.parseDouble(first);
                        sum = sum1;
                        k = 1;
                    }
                }
                if(op != 0 && d == 0){
                    if(flag == true){
                        second = "5";
                        textView.setText("5");
                        sum2 = Double.parseDouble(second);
                        sum = sum2;
                        flag = false;
                        k = 1;
                    }
                    else if(flag == false){
                        if(quLing == 1)
                            second = second + "5";
                        else
                            second = "5";
                        second = second.replaceFirst(",","");//!!!!!!!!!!!!!!!!!!!!!!!!!!!修复了遇到，系统崩溃的bug
                        textView.setText(second);
                        sum2 = Double.parseDouble(second);
                        sum = sum2;
                        k = 1;
                    }
                }
                quLing = 1;
                m = 0;
            }
        });
//绑定按钮 6 的监听事件
        btn_6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                aaa = 0;//用于修补四则运算后不能退位的情况
                ooo = 0;//用于修复按点0再按加减的bug
                ppt = 0;//用于使平方后退位失灵
                bfudian = 0;//保存产生的点（按其他都置零
                if(a == 1){//修补按平方后再按数字的bug
                    flag = true; k = 0; op = 0; /*lianDian = 0;*/ result = 0; sum1 = 0; /*sum2 = 0; */m = 0; quLing = 0; lingHouDian =0; first = "0";
                    second = ""; /*!!*/dengHouDian = 0;  t = 0;  d = 0 ;p = 0;  sum = 0; x = 0;od = 0;hehe = 0;yy = 0;fudian = 0;ffudian = 0;
                    xx = 0;//！！q = 0;
                    a = 0;//修补按平方后再按数字的bug
                    pp = 0;//待确定
                }
                yy = 0;//实验！！！！！！！！！！！
                d = 0;
                if(dengHouDian == 1){
                    op = 0;
                    first = "6";
                    textView.setText("6");
                    sum1 = Double.parseDouble(first);
                    sum = sum1;
                    flag = false;
                    dengHouDian = 0;
                    d = 1;
                    x = 0;//不确定
                }
                if(op == 0 && d == 0){
                    if(flag == true){
                        first = "6";
                        textView.setText("6");
                        sum1 = Double.parseDouble(first);
                        sum = sum1;
                        flag = false;
                        k = 1;
                    }
                    else if(flag == false){
                        if(quLing == 1)
                            first = first + "6";
                        else
                            first = "6";
                        first = first.replaceFirst(",","");//!!!!!!!!!!!!!!!!!!!!!!!!!!!修复了遇到，系统崩溃的bug
                        textView.setText(first);
                        sum1 = Double.parseDouble(first);
                        sum = sum1;
                        k = 1;
                    }
                }
                if(op != 0 && d == 0){
                    if(flag == true){
                        second = "6";
                        textView.setText("6");
                        sum2 = Double.parseDouble(second);
                        sum = sum2;
                        flag = false;
                        k = 1;
                    }
                    else if(flag == false){
                        if(quLing == 1)
                            second = second + "6";
                        else
                            second= "6";
                        second = second.replaceFirst(",","");//!!!!!!!!!!!!!!!!!!!!!!!!!!!修复了遇到，系统崩溃的bug
                        textView.setText(second);
                        sum2 = Double.parseDouble(second);
                        sum = sum2;
                        k = 1;
                    }
                }
                quLing = 1;
                m = 0;
            }
        });
//绑定按钮 7 的监听事件
        btn_7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                aaa = 0;//用于修补四则运算后不能退位的情况
                ooo = 0;//用于修复按点0再按加减的bug
                ppt = 0;//用于使平方后退位失灵
                bfudian = 0;//保存产生的点（按其他都置零
                if(a == 1){//修补按平方后再按数字的bug
                    flag = true; k = 0; op = 0; /*lianDian = 0;*/ result = 0; sum1 = 0; /*sum2 = 0; */m = 0; quLing = 0; lingHouDian =0; first = "0";
                    second = ""; /*!!*/dengHouDian = 0;  t = 0;  d = 0 ;p = 0;  sum = 0; x = 0;od = 0;hehe = 0;yy = 0;fudian = 0;ffudian = 0;
                    xx = 0;//！！q = 0;
                    a = 0;//修补按平方后再按数字的bug
                    pp = 0;//待确定
                }
                yy = 0;//实验！！！！！！！！！！！
                d = 0;
                if(dengHouDian == 1){
                    op = 0;
                    first = "7";
                    textView.setText("7");
                    sum1 = Double.parseDouble(first);
                    sum = sum1;
                    flag = false;
                    dengHouDian = 0;
                    d = 1;
                    x = 0;
                }
                if(op == 0 && d == 0){
                    if(flag == true){
                        first = "7";
                        textView.setText("7");
                        sum1 = Double.parseDouble(first);
                        sum = sum1;
                        flag = false;
                        k = 1;
                    }
                    else if(flag == false){
                        if(quLing == 1)
                            first = first + "7";
                        else
                            first = "7";
                        first = first.replaceFirst(",","");//!!!!!!!!!!!!!!!!!!!!!!!!!!!修复了遇到，系统崩溃的bug
                        textView.setText(first);
                        sum1 = Double.parseDouble(first);
                        sum = sum1;
                        k = 1;
                    }
                }
                if(op != 0 && d == 0){
                    if(flag == true){
                        second = "7";
                        textView.setText("7");
                        sum2 = Double.parseDouble(second);
                        sum = sum2;
                        flag = false;
                        k = 1;
                    }
                    else if(flag == false){
                        if(quLing == 1)
                            second = second + "7";
                        else
                            second = "7";
                        second = second.replaceFirst(",","");//!!!!!!!!!!!!!!!!!!!!!!!!!!!修复了遇到，系统崩溃的bug
                        textView.setText(second);
                        sum2 = Double.parseDouble(second);
                        sum = sum2;
                        k = 1;
                    }
                }
                quLing = 1;
                m = 0;
            }
        });
//绑定按钮 8 的监听事件
        btn_8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                aaa = 0;//用于修补四则运算后不能退位的情况
                ooo = 0;//用于修复按点0再按加减的bug
                ppt = 0;//用于使平方后退位失灵
                bfudian = 0;//保存产生的点（按其他都置零
                if(a == 1){//修补按平方后再按数字的bug
                    flag = true; k = 0; op = 0; /*lianDian = 0;*/ result = 0; sum1 = 0; /*sum2 = 0; */m = 0; quLing = 0; lingHouDian =0; first = "0";
                    second = ""; /*!!*/dengHouDian = 0;  t = 0;  d = 0 ;p = 0;  sum = 0; x = 0;od = 0;hehe = 0;yy = 0;fudian = 0;ffudian = 0;
                    xx = 0;//！！q = 0;
                    a = 0;//修补按平方后再按数字的bug
                    pp = 0;//待确定
                }
                yy = 0;//实验！！！！！！！！！！！
                d = 0;
                if(dengHouDian == 1){
                    op = 0;
                    first = "8";
                    textView.setText("8");
                    sum1 = Double.parseDouble(first);
                    sum = sum1;
                    flag = false;
                    dengHouDian = 0;
                    d = 1;
                    x = 0;//不确定
                }
                if(op == 0 && d == 0){
                    if(flag == true){
                        first = "8";
                        textView.setText("8");
                        sum1 = Double.parseDouble(first);
                        sum = sum1;
                        flag = false;
                        k = 1;
                    }
                    else if(flag == false){
                        if(quLing == 1)
                            first = first + "8";
                        else
                            first = "8";
                        first = first.replaceFirst(",","");//!!!!!!!!!!!!!!!!!!!!!!!!!!!修复了遇到，系统崩溃的bug
                        textView.setText(first);
                        sum1 = Double.parseDouble(first);
                        sum = sum1;
                        k = 1;
                    }
                }
                if(op != 0 && d == 0){
                    if(flag == true){
                        second = "8";
                        textView.setText("8");
                        sum2 = Double.parseDouble(second);
                        sum = sum2;
                        flag = false;
                        k = 1;
                    }
                    else if(flag == false){
                        if(quLing == 1)
                            second= second + "8";
                        else
                            second = "8";
                        second = second.replaceFirst(",","");//!!!!!!!!!!!!!!!!!!!!!!!!!!!修复了遇到，系统崩溃的bug
                        textView.setText(second);
                        sum2 = Double.parseDouble(second);
                        sum = sum2;
                        k = 1;
                    }
                }
                quLing = 1;
                m = 0;
            }
        });
//绑定按钮 9 的监听事件
        btn_9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                aaa = 0;//用于修补四则运算后不能退位的情况
                ooo = 0;//用于修复按点0再按加减的bug
                ppt = 0;//用于使平方后退位失灵
                bfudian = 0;//保存产生的点（按其他都置零
                if(a == 1){//修补按平方后再按数字的bug
                    flag = true; k = 0; op = 0; /*lianDian = 0;*/ result = 0; sum1 = 0; /*sum2 = 0; */m = 0; quLing = 0; lingHouDian =0; first = "0";
                    second = ""; /*!!*/dengHouDian = 0;  t = 0;  d = 0 ;p = 0;  sum = 0; x = 0;od = 0;hehe = 0;yy = 0;fudian = 0;ffudian = 0;
                    xx = 0;//！！q = 0;
                    a = 0;//修补按平方后再按数字的bug
                    pp = 0;//待确定
                }
                yy = 0;//实验！！！！！！！！！！！
                d = 0;
                if(dengHouDian == 1){
                    op = 0;
                    first = "9";
                    textView.setText("9");
                    sum1 = Double.parseDouble(first);
                    sum = sum1;
                    flag = false;
                    dengHouDian = 0;
                    d = 1;
                    x = 0;
                }
                if(op == 0 && d == 0){
                    if(flag == true){
                        first = "9";
                        textView.setText("9");
                        sum1 = Double.parseDouble(first);
                        sum = sum1;
                        flag = false;
                        k = 1;
                    }
                    else if(flag == false){
                        if(quLing == 1)
                            first = first + "9";
                        else
                            first = "9";
                        first = first.replaceFirst(",","");//!!!!!!!!!!!!!!!!!!!!!!!!!!!修复了遇到，系统崩溃的bug
                        textView.setText(first);
                        sum1 = Double.parseDouble(first);
                        sum = sum1;
                        k = 1;
                    }
                }
                if(op != 0 && d == 0){
                    if(flag == true){
                        second = "9";
                        textView.setText("9");
                        sum2 = Double.parseDouble(second);
                        sum = sum2;
                        flag = false;
                        k = 1;
                    }
                    else if(flag == false){
                        if(quLing == 1)
                            second = second + "9";
                        else
                            second = "9";
                        second = second.replaceFirst(",","");//!!!!!!!!!!!!!!!!!!!!!!!!!!!修复了遇到，系统崩溃的bug
                        textView.setText(second);
                        sum2 = Double.parseDouble(second);
                        sum = sum2;
                        k = 1;
                    }
                }
                quLing = 1;
                m = 0;
            }
        });

        //绑定 减 号 的监听事件
        btn_jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aaa = 1;//用于修补四则运算后不能退位的情况
                ooo = 0;//用于修复按点0再按加减的bug
                ppt = 0;//用于使平方后退位失灵
                bfudian = 0;//保存产生的点（按其他都置零
                a = 0;//用于实现按了根号后再按四则运算符可以运算
                if(m == 0 /*&& dengHouDian == 1*/){
                    if(op == 1 && second != "") {
                        if(sum1 == 0) sum1 = Double.parseDouble(first);
                        sum2 = Double.parseDouble(second);
                        result = sum1 + sum2;
                        NumberFormat nf = NumberFormat.getInstance();
                        nf.setMaximumFractionDigits(15);
                        textView.setText(String.valueOf(nf.format(result)));
                        first = result + "";//修补1+2+3 = 6bug
                        sum1 = result;
                        sum = result;
                        m = 1;
                    }
                    else if(op == 2 && second != "") {
                        if(sum1 == 0) sum1 = Double.parseDouble(first);
                        sum2 = Double.parseDouble(second);
                        result = sum1 - sum2;
                        NumberFormat nf = NumberFormat.getInstance();
                        nf.setMaximumFractionDigits(15);
                        textView.setText(String.valueOf(nf.format(result)));
                        first = result + "";//修补1+2+3 = 6bug
                        sum1 = result;
                        sum = result;
                        m = 1;
                    }
                    else if(op == 3 && second != "") {
                        if(sum1 == 0) sum1 = Double.parseDouble(first);
                        sum2 = Double.parseDouble(second);
                        result = sum1 * sum2;
                        NumberFormat nf = NumberFormat.getInstance();
                        nf.setMaximumFractionDigits(15);
                        textView.setText(String.valueOf(nf.format(result)));
                        first = result + "";//修补1+2+3 = 6bug
                        sum1 = result;
                        sum = result;
                        m = 1;
                    }
                    else if(op == 4 && second != "") {
                        if(sum1 == 0) sum1 = Double.parseDouble(first);
                        sum2 = Double.parseDouble(second);
                        if(sum2 != 0) result = sum1 / sum2;
                        NumberFormat nf = NumberFormat.getInstance();
                        nf.setMaximumFractionDigits(15);
                        textView.setText(String.valueOf(nf.format(result)));
                        first = result + "";//修补1+2+3 = 6bug
                        sum1 = result;
                        sum = result;
                        m = 1;
                    }
                }
                if(sum2 == 0 && op == 4 && second !=""){
                    textView.setText("除数不能为0");
                    flag = true; k = 0; op = 0; lianDian = 0; result = 0; sum1 = 0; sum2 = 0; m = 0; quLing = 0; lingHouDian =0; first = "0";
                    second = ""; dengHouDian = 0; t = 0;  d = 0 ;p = 0; sum = 0; x = 0;od = 0;hehe = 0;yy = 0;fudian = 0;ffudian = 0;
                    xx = 1;q = 0;qq = 0;a = 0;pp = 0;
                }
                else {
                    op = 2;
                    flag = true;
                    lingHouDian = 1;
                    k = 0;
                    dengHouDian = 0;
                    lianDian = 0;
                    yy = 1;//用于控制单目运算后 加 等号
                }
            }
        });
//绑定 乘 号 的监听事件
        btn_cheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aaa = 1;//用于修补四则运算后不能退位的情况
                ooo = 0;//用于修复按点0再按加减的bug
                ppt = 0;//用于使平方后退位失灵
                bfudian = 0;//保存产生的点（按其他都置零
                a = 0;//用于实现按了根号后再按四则运算符可以运算
                if(m == 0 /*&& dengHouDian == 1*/){
                    if(op == 1 && second != "") {
                        if(sum1 == 0) sum1 = Double.parseDouble(first);
                        sum2 = Double.parseDouble(second);
                        result = sum1 + sum2;
                        NumberFormat nf = NumberFormat.getInstance();
                        nf.setMaximumFractionDigits(15);
                        textView.setText(String.valueOf(nf.format(result)));
                        first = result + "";//修补1+2+3 = 6bug
                        sum1 = result;
                        sum = result;
                        m = 1;
                    }
                    else if(op == 2 && second != "") {
                        if(sum1 == 0) sum1 = Double.parseDouble(first);
                        sum2 = Double.parseDouble(second);
                        result = sum1 - sum2;
                        NumberFormat nf = NumberFormat.getInstance();
                        nf.setMaximumFractionDigits(15);
                        textView.setText(String.valueOf(nf.format(result)));
                        first = result + "";//修补1+2+3 = 6bug
                        sum1 = result;
                        sum = result;
                        m = 1;
                    }
                    else if(op == 3 && second != "") {
                        if(sum1 == 0) sum1 = Double.parseDouble(first);
                        sum2 = Double.parseDouble(second);
                        result = sum1 * sum2;
                        NumberFormat nf = NumberFormat.getInstance();
                        nf.setMaximumFractionDigits(15);
                        textView.setText(String.valueOf(nf.format(result)));
                        first = result + "";//修补1+2+3 = 6bug
                        sum1 = result;
                        sum = result;
                        m = 1;
                    }
                    else if(op == 4 && second != "") {
                        if(sum1 == 0) sum1 = Double.parseDouble(first);
                        sum2 = Double.parseDouble(second);
                        if(sum2 != 0) result = sum1 / sum2;
                        NumberFormat nf = NumberFormat.getInstance();
                        nf.setMaximumFractionDigits(15);
                        textView.setText(String.valueOf(nf.format(result)));
                        first = result + "";//修补1+2+3 = 6bug
                        sum1 = result;
                        sum = result;
                        m = 1;
                    }
                }
                if(sum2 == 0 && op == 4 && second !=""){
                    textView.setText("除数不能为0");
                    flag = true; k = 0; op = 0; lianDian = 0; result = 0; sum1 = 0; sum2 = 0; m = 0; quLing = 0; lingHouDian =0; first = "0";
                    second = ""; dengHouDian = 0; t = 0;  d = 0 ;p = 0;  sum = 0; x = 0;od = 0;hehe = 0;yy = 0;fudian = 0;ffudian = 0;
                    xx = 1;q = 0; qq = 0;a = 0;pp = 0;
                }
                else {
                    op = 3;
                    flag = true;
                    lingHouDian = 1;
                    k = 0;
                    dengHouDian = 0;
                    lianDian = 0;
                    yy = 1;//用于控制单目运算后 加 等号
                }
            }
        });
    }
}