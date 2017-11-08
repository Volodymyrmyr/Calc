package com.example.calculator_my;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Володимир on 24.02.2017.
 */
public class FragMain extends Fragment implements View.OnClickListener {
    FragmentTransaction fTrans;

    EditText showNumber;
    TextView res;

    final private String ADD_1 = "+";
    final private String SUB_1 = "-";
    final private String MUL_1 = "*";
    final private String DIV_1 = "/";


    String PromOperation = "";
    String op;
    String forShared = "";

    float prom = 0;
    float promValue = 0;
    float promRes = 0;
    float promRes1 = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view_for_activity = inflater.inflate(R.layout.frag_main, null);
        setRetainInstance(true);

        InitV(view_for_activity);
        res = (TextView) view_for_activity.findViewById(R.id.showRes);
        res.setText(forShared);
        fTrans = getFragmentManager().beginTransaction();
        return view_for_activity;
    }

    private void InitV(View r) {
        r.findViewById(R.id.button_1).setOnClickListener(this);
        r.findViewById(R.id.button_2).setOnClickListener(this);
        r.findViewById(R.id.button_3).setOnClickListener(this);
        r.findViewById(R.id.button_4).setOnClickListener(this);
        r.findViewById(R.id.button_5).setOnClickListener(this);
        r.findViewById(R.id.button_6).setOnClickListener(this);
        r.findViewById(R.id.button_7).setOnClickListener(this);
        r.findViewById(R.id.button_8).setOnClickListener(this);
        r.findViewById(R.id.button_9).setOnClickListener(this);
        r.findViewById(R.id.button_10).setOnClickListener(this);
        r.findViewById(R.id.button_point).setOnClickListener(this);

        r.findViewById(R.id.button_add).setOnClickListener(this);
        r.findViewById(R.id.button_sub).setOnClickListener(this);
        r.findViewById(R.id.button_mul).setOnClickListener(this);
        r.findViewById(R.id.button_div).setOnClickListener(this);
        r.findViewById(R.id.button_clear).setOnClickListener(this);
        r.findViewById(R.id.button_is).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        showNumber = (EditText) getActivity().findViewById(R.id.numberFirst);
        switch (v.getId()) {
            case R.id.button_1:
                showNumber.append("1");
                break;
            case R.id.button_2:
                showNumber.append("2");
                break;
            case R.id.button_3:
                showNumber.append("3");
                break;
            case R.id.button_4:
                showNumber.append("4");
                break;
            case R.id.button_5:
                showNumber.append("5");
                break;
            case R.id.button_6:
                showNumber.append("6");
                break;
            case R.id.button_7:
                showNumber.append("7");
                break;
            case R.id.button_8:
                showNumber.append("8");
                break;
            case R.id.button_9:
                showNumber.append("9");
                break;
            case R.id.button_10:
                showNumber.append("0");
                break;
            case R.id.button_point:
                showNumber.append(".");
                break;
            case R.id.button_add:
                op = showNumber.getText().toString();
                add_n(op);
                break;
            case R.id.button_sub:
                op = showNumber.getText().toString();
                sub_n(op);
                break;
            case R.id.button_mul:
                op = showNumber.getText().toString();
                mul_n(op);
                break;
            case R.id.button_div:
                op = showNumber.getText().toString();
                div_n(op);
                break;
            case R.id.button_clear:
                showNumber.setText("");
                res.setText("");
                break;
            case R.id.button_is:
                op = showNumber.getText().toString();
                notArg(op);
                break;
            default:
                break;
        }
    }

//    private void buttExit() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        builder.setTitle("")
//                .setMessage("Бажаєте вийти ?")
//                .setCancelable(true)
//                .setPositiveButton("Так",
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                getActivity().finish();
//                            }
//                        });
//        builder.setNegativeButton("Ні",
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.cancel();
//                    }
//                });
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
//    }

    private void notArg(String n) {
        if (n.equals("")) {
        } else {
            res = (TextView) getActivity().findViewById(R.id.showRes);
            promRes1 = Float.parseFloat(showNumber.getText().toString());
            promRes = returnResult(promValue, promRes1, PromOperation);
            forShared = promValue + " " + PromOperation + " " + promRes1 + " = " + promRes;
            res.setText(forShared);
            showNumber.setText("");
            //showNumber.append("" + promRes);
            promValue = promRes;
        }
    }

    private void add_n(String n) {
        if (n.equals("")) {
            PromOperation = ADD_1;
            showNumber.setText("");
        } else {
            promValue = Float.parseFloat(showNumber.getText().toString());
            PromOperation = ADD_1;
            showNumber.setText("");
        }
    }

    private void sub_n(String n) {
        if (n.equals("")) {
            PromOperation = SUB_1;
            showNumber.setText("");
        } else {
            promValue = Float.parseFloat(showNumber.getText().toString());
            PromOperation = SUB_1;
            showNumber.setText("");
        }
    }

    private void mul_n(String n) {
        if (n.equals("")) {
            PromOperation = MUL_1;
            showNumber.setText("");
        } else {
            promValue = Float.parseFloat(showNumber.getText().toString());
            PromOperation = MUL_1;
            showNumber.setText("");
        }
    }

    private void div_n(String n) {
        if (n.equals("")) {
            PromOperation = DIV_1;
            showNumber.setText("");
        } else {
            promValue = Float.parseFloat(showNumber.getText().toString());
            PromOperation = DIV_1;
            showNumber.setText("");
        }
    }

    private float returnResult(float a, float b, String oper) {
        float suma = 0;
        if (oper.equals(ADD_1)) {
            suma = a + b;
            return suma;
        }
        if (oper.equals(SUB_1)) {
            suma = a - b;
            return suma;
        }
        if (oper.equals(MUL_1)) {
            suma = a * b;
            return suma;
        }
        if (oper.equals(DIV_1)) {
            if (b != 0) {
                suma = a / b;
            } else {
                Toast toast = Toast.makeText(getActivity(), "Ділення на 0", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
            return suma;
        } else {
            res.setText("");
            Toast t = Toast.makeText(getActivity(), "Введіть значення", Toast.LENGTH_SHORT);
            t.setGravity(Gravity.CENTER, 0, 0);
            t.show();
        }
        return 0;
    }
}
