package com.example.asb_ex_4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton[] rbtn = new RadioButton[4];
    TextView tv0, tv1;
    ImageView im1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setTitle("키키키");


        rbtn[0] = findViewById(R.id.rbtn1);
        rbtn[1] = findViewById(R.id.rbtn2);
        rbtn[2] = findViewById(R.id.rbtn3);
        rbtn[3] = findViewById(R.id.rbtn4);

        tv0 = (TextView) findViewById(R.id.tv0);
        tv1 = (TextView) findViewById(R.id.tv1);

        im1 = (ImageView)findViewById(R.id.im1);

        tv0.setTextColor(Color.MAGENTA);

        for(int i=0; i<rbtn.length; i++){
            final int idx1 = i;
            rbtn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for(int j=0; j< rbtn.length; j++){
                        final int idx2 = j;
                        if(idx1 == idx2){
                            rbtn[idx2].setChecked(true);
                            //Toast.makeText(getApplicationContext(),rbtn[idx1].getText()+"를 선택함",Toast.LENGTH_SHORT).show();
                            tv1.setText(rbtn[idx1].getText().toString()+"을 선택했습니다!");

                            switch (idx1){
                                case 0 :
                                    im1.setImageResource(R.drawable.f1);
                                    break;
                                case 1:
                                    im1.setImageResource(R.drawable.f2);
                                    break;
                                case 2 :
                                    im1.setImageResource(R.drawable.f3);
                                    break;
                                case 3 :
                                    im1.setImageResource(R.drawable.f4);
                                    break;
                            }

                        }else{
                            rbtn[idx2].setChecked(false);
                        }
                    }
                }
            });
        }

        tv0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0; i<rbtn.length; i++){
                    final int idx = i;
                    rbtn[idx].setChecked(false);
                }
                tv1.setText("메뉴를 골라주세요");
                im1.setImageResource(0);
            }
        });
    }
}