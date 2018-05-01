package com.example.tsokolovs.calculator;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,
            buttonPlus, buttonMinus, buttonDal, buttonReiz, buttonVienads, buttonC;
    TextView izvade;
    TextInputEditText ievade;
    HorizontalScrollView scrollView;
    double vertiba = 0.00;
    double rezultats = 0.00;
    DecimalFormat df = new DecimalFormat("#");
    LayoutParams params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ievade = findViewById(R.id.ievade);
        izvade = findViewById(R.id.izvade);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonDal = findViewById(R.id.buttonDal);
        buttonReiz = findViewById(R.id.buttonReiz);
        buttonVienads = findViewById(R.id.buttonVienads);
        buttonC = findViewById(R.id.buttonC);
        scrollView = findViewById(R.id.horizScroll);
        params = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);

        izvade.setText("");
        ievade.setText("");
        izvade.setLayoutParams(params);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ievade.setText(ievade.getText() + "0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ievade.setText(ievade.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ievade.setText(ievade.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ievade.setText(ievade.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ievade.setText(ievade.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ievade.setText(ievade.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ievade.setText(ievade.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ievade.setText(ievade.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ievade.setText(ievade.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ievade.setText(ievade.getText() + "9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ievade.setText(ievade.getText() + "0");
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacijasApstrade("+");

            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacijasApstrade("-");
            }
        });

        buttonReiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacijasApstrade("*");
            }
        });

        buttonDal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacijasApstrade("/");
            }
        });

        buttonVienads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (irIevadesVertiba() && irIzvadesVertiba() && irIzvadaOperacija()) {
                    String operacijaPirmsVertibas = izvadaOperacijasParbaude();
                    iegutIevadesVertibu();
                    iegutRezultatu(operacijaPirmsVertibas, vertiba);
                }

                if (irIevadesVertiba() && !irIzvadesVertiba()) {
                    iegutIevadesVertibu();
                    rezultats = vertiba;
                }
                ievade.setText("");
                if (rezultats % 1 == 0) {
                    izvade.setText(df.format(rezultats));
                } else {
                    izvade.setText(rezultats + "");
                }

                izvade.setLayoutParams(params);
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (irIevadesVertiba()) {
                    ievade.setText("");
                    vertiba = 0;
                } else {
                    izvade.setText("");
                    rezultats = 0;
                    izvade.setLayoutParams(params);
                }
            }
        });
    }

    private String izvadaOperacijasParbaude() {
        String oper = "";
        if (irIzvadesVertiba()) {
            int index = izvade.getText().toString().length();
            oper = izvade.getText().toString().substring(index - 1, index);
        }
        return oper;
    }

    private boolean irIzvadaOperacija() {
        String o = izvadaOperacijasParbaude();
        if (o.equals("+") || o.equals("-") || o.equals("/") || o.equals("*")) {
            return true;
        }

        return false;
    }

    private String iznemtPedejoSimb(String str) {
        str = str.substring(0, str.length() -1);
        return str;
    }

    private boolean irIevadesVertiba() {
        return ievade.getText().toString().length() > 0;
    }

    private boolean irIzvadesVertiba() {
        return izvade.getText().toString().length() > 0;
    }

    private void operacijasApstrade(String oper) {
        iegutIevadesVertibu();
        String izv = izvade.getText().toString();

        if (!irIevadesVertiba() && irIzvadesVertiba() && irIzvadaOperacija()) {
            izvade.setText(iznemtPedejoSimb(izv) + oper);
        } else if (irIevadesVertiba() && irIzvadesVertiba() && !irIzvadaOperacija()) {
            rezultats = vertiba;
            izvade.setText(df.format(vertiba) + oper);
        } else if (!irIevadesVertiba() && irIzvadesVertiba()) {
            izvade.setText(izv + oper);
        } else if (irIevadesVertiba() && irIzvadesVertiba()) {
            String operacijaPirmsVertibas = izvadaOperacijasParbaude();
            iegutRezultatu(operacijaPirmsVertibas, vertiba);
            izvade.setText(izv + df.format(vertiba) + oper);
        } else if (!irIevadesVertiba() && !irIzvadesVertiba()) {
            if (rezultats % 1 == 0) {
                izvade.setText(df.format(rezultats) + oper);
            } else {
                izvade.setText(rezultats + oper);
            }
        } else {
            rezultats = vertiba;
            izvade.setText(df.format(vertiba) + oper);
        }

        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(View.FOCUS_RIGHT);
            }
        });
        ievade.setText("");
    }

    private void iegutRezultatu(String oper, double vert) {

        switch (oper) {
            case "+":
                rezultats += vert;
                break;
            case "-":
                rezultats -= vert;
                break;
            case "*":
                rezultats *= vert;
                break;
            case "/":
                vert = vert == 0 ? 1 : vert;
                rezultats /= vert;
                break;
            default:
                break;
        }
    }

    private void iegutIevadesVertibu() {
        if(irIevadesVertiba()) {
            vertiba = Double.parseDouble(ievade.getText().toString());
        } else {
            vertiba = 0;
        }
    }
}
