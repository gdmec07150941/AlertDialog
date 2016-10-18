package com.example.administrator.alretdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AlertDialog dialog;
    private AlertDialog.Builder builder;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.textView);
        Button btn1 = (Button) findViewById(R.id.button1);
        Button btn2 = (Button) findViewById(R.id.button2);
        Button btn3 = (Button) findViewById(R.id.button3);
        Button btn4 = (Button) findViewById(R.id.button4);
        Button btn5 = (Button) findViewById(R.id.button5);
        Button btn6 = (Button) findViewById(R.id.button6);
        Button btn7 = (Button) findViewById(R.id.button7);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button1:
                        dialog1();
                        break;
                    case R.id.button2:
                        dialog2();
                        break;
                    case R.id.button3:
                        dialog3();
                        break;
                    case R.id.button4:
                        dialog4();
                        break;
                    case R.id.button5:
                        dialog5();
                        break;
                    case R.id.button6:
                        dialog6();
                        break;
                    case R.id.button7:
                        dialog7();
                        break;
                }
            }
        };
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);
    }

    private void dialog1(){
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("提示");
        dialog.setMessage("确定退出吗?");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        //  创建按钮监听器
        DialogInterface.OnClickListener listener1 = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {      //which: AlertDialog中的哪个按钮
                if (which == DialogInterface.BUTTON_POSITIVE){  //按下确定按钮
                    dialog.dismiss();
                    finish();     //  退出当前Activity
                }else if(which == DialogInterface.BUTTON_NEGATIVE){     //按下取消按钮
                    dialog.dismiss();
                }
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener1);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener1);
        dialog.show();
    }
    private void dialog2(){
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("调查");
        dialog.setMessage("你平时忙吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        //  创建按钮监听器
        DialogInterface.OnClickListener listener2 = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "";
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        str = "平时很忙 ";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str = "平时一般 ";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str = "平时清闲 ";
                        break;
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"忙碌",listener2);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"一般",listener2);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"清闲",listener2);
        dialog.show();
    }
    private void dialog3(){
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("请输入：");
        dialog.setMessage("你平时忙碌吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        final EditText tEidt = new EditText(this);
        dialog.setView(tEidt);
        //  创建事件监听器
        DialogInterface.OnClickListener listener3 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("输入的是："+tEidt.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener3);
        dialog.show();
    }
    private void dialog4(){
        final String item[] = new String[]{"北京","上海","广州"};
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener listener41 = new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                //  用数组记录下选择的所有选项
                bSelect[which] = isChecked;
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item,null,listener41);
        dialog = builder.create();
        dialog.setTitle("复选框");
        DialogInterface.OnClickListener listener42 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了：";
                for (int i = 0; i <bSelect.length; i++){
                    if(bSelect[i]){
                        str = str + "\n"+ item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener42);
        dialog.show();
    }
    private void dialog5(){
        final String item[] = new String[]{"北京","上海","广州"};
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnClickListener listener51 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                for (int i = 0; i < bSelect.length; i++){
                    if(i != which){
                        bSelect[i] = false;
                    }else{
                        bSelect[i] = true;
                    }
                }
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,listener51);
        dialog = builder.create();
        dialog.setTitle("单选");
        DialogInterface.OnClickListener listener52 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选了";
                for (int i = 0; i < bSelect.length; i++){
                    if (bSelect[i]){
                        str = str + "\n" + item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener52);
        dialog.show();
    }
    private void dialog6(){
        final String item[] = new String[]{"北京","上海","广州"};
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnClickListener listener61 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了: "+item[which];
                tv1.setText(str);
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setItems(item,listener61);
        dialog = builder.create();
        dialog.setTitle("列表");
        DialogInterface.OnClickListener listener62 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener62);
        dialog.show();
    }
    private void dialog7(){
        LayoutInflater layoutInflater = getLayoutInflater();
        View layout = layoutInflater.inflate(R.layout.layout,null);
        final EditText editText = (EditText) layout.findViewById(R.id.editText);
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("自定义布局");
        dialog.setView(layout);
        DialogInterface.OnClickListener listener7 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("你输入的是："+editText.getText().toString());
            }
        };
        dialog.setButton(AlertDialog.BUTTON_POSITIVE,"确定",listener7);
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE,"取消",listener7);
        dialog.show();
    }

}
