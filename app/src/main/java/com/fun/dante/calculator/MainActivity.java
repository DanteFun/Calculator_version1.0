package com.fun.dante.calculator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    public enum operating {mod,hex,bin,oct,sin,cos,tan}
    public double trans(char arr[],char arrs[],int length){
        for(int i=0;i<length;i++)
        {
            arrs[i]=arr[i];
        }
        System.out.println(length);
        String str = new String(arr);
        return Double.parseDouble(str);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView Screen = findViewById(R.id.screen);
        final TextView Result_Screen = findViewById(R.id.result_screen);

        Button but_one = findViewById(R.id.one);
        but_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Screen.setText(Screen.getText()+"1");
            }
        });

        Button but_two = findViewById(R.id.two);
        but_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Screen.setText(Screen.getText()+"2");
            }
        });

        final Button but_three = findViewById(R.id.three);
        but_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Screen.setText(Screen.getText()+"3");
            }
        });

        Button but_four = findViewById(R.id.four);
        but_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Screen.setText(Screen.getText()+"4");
            }
        });

        Button but_five = findViewById(R.id.five);
        but_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Screen.setText(Screen.getText()+"5");
            }
        });

        Button but_six = findViewById(R.id.six);
        but_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Screen.setText(Screen.getText()+"6");
            }
        });

        Button but_seven = findViewById(R.id.seven);
        but_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Screen.setText(Screen.getText()+"7");
            }
        });

        Button but_eight = findViewById(R.id.eight);
        but_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Screen.setText(Screen.getText()+"8");
            }
        });

        Button but_nine = findViewById(R.id.nine);
        but_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Screen.setText(Screen.getText()+"9");
            }
        });

        Button but_zero = findViewById(R.id.zero);
        but_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Screen.setText(Screen.getText()+"0");
            }
        });

        Button but_add = findViewById(R.id.add);
        but_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Screen.setText(Screen.getText()+"+");
            }
        });

        final Button but_sub = findViewById(R.id.sub);
        but_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Screen.setText(Screen.getText()+"-");
            }
        });

        Button but_mul = findViewById(R.id.mul);
        but_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Screen.setText(Screen.getText()+"*");
            }
        });

        Button but_divide = findViewById(R.id.divide);
        but_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Screen.setText(Screen.getText()+"÷");
            }
        });

        Button but_enter = findViewById(R.id.enter);
        but_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Result_Screen.setText("");
                char text[] = ((Screen.getText()).toString()).toCharArray();
                stack s = new stack();
                int  k = 0;
                char temp [] = new char[10];
                if(Screen.getText().equals(""))
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Alert!");
                    builder.setMessage("You haven't any operator!");
                    builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                for(int i=0;i<text.length;i++,k++)
                {
                    temp[k] = text[i];
                    if(text[i] =='+'||text[i]=='-'||text[i]=='*'||text[i]=='÷'||text[i]=='('||text[i]==')'||text[i]=='b'||text[i]=='c'||text[i]=='h'||text[i]=='m'||text[i]=='o'||text[i]=='s'||text[i]=='t')
                    {
                        s.push_operator(text[i]);
                        if(i!=0)
                        {
                            char num_1[] = new char[k];
                            s.push_num(trans(temp,num_1,k));
                        }
                        if(text[i]=='b'||text[i]=='c'||text[i]=='h'||text[i]=='m'||text[i]=='o'||text[i]=='s'||text[i]=='t')
                        {
                            i += 2;
                        }
                        k = -1;
                    }
//                    if(text[i] =='+'||text[i]=='-'||text[i]=='*'||text[i]=='÷'||text[i]=='('||text[i]==')')
//                    {
//                        s.push_operator(text[i]);
//                        if(i!=0&&i!=text.length-1)
//                        {
//                            char num_1[] = new char[k];
//                            s.push_num(trans(temp,num_1,k));
//                        }
//                        k = -1;
//                    }
//                    if(i==text.length-1)
//                    {
//                        char num_1[] = new char[k+1];
//                        s.push_num(trans(temp,num_1,k+1));
//                    }
                }
            }
        });

        Button but_point = findViewById(R.id.point);
        but_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Screen.setText(Screen.getText()+".");
            }
        });

        Button but_C = findViewById(R.id.C);
        but_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Screen.setText("");
            }
        });

        Button but_ESC = findViewById(R.id.ESC);
        but_ESC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Alert!");
                builder.setMessage("Do you wanna exit?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        System.exit(0);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        Button but_mod = findViewById(R.id.mod);
        but_mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Screen.setText(Screen.getText()+"mod");
            }
        });

        Button but_delete = findViewById(R.id.delete_one);
        but_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence text = Screen.getText();
                if(text.length()!=0)
                {
                    Screen.setText(text.subSequence(0,text.length()-1));
                }
                else
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Alert!");
                    builder.setMessage("No character to delete!");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });
        Button but_sin = findViewById(R.id.sin);
        but_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Screen.setText(Screen.getText()+"sin");
            }
        });
        Button but_cos = findViewById(R.id.cos);
        but_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Screen.setText(Screen.getText()+"cos");
            }
        });
        Button but_tan = findViewById(R.id.tan);
        but_tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Screen.setText(Screen.getText()+"tan");
            }
        });
        Button but_left_bracket = findViewById(R.id.left_bracket);
        but_left_bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Screen.setText(Screen.getText()+"(");
            }
        });
        Button but_hex = findViewById(R.id.hex);
        but_hex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Screen.setText(Screen.getText()+"hex");
            }
        });
        Button but_oct = findViewById(R.id.oct);
        but_oct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Screen.setText(Screen.getText()+"oct");
            }
        });
        Button but_bin = findViewById(R.id.bin);
        but_bin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Screen.setText(Screen.getText()+"bin");
            }
        });
        Button but_right_bracket = findViewById(R.id.right_bracket);
        but_right_bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Screen.setText(Screen.getText()+")");
            }
        });
    }
}
