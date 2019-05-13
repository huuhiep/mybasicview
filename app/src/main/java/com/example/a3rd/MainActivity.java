package com.example.a3rd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.app.AlertDialog;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCancel =  (Button)findViewById(R.id.btnCancel);
        Button btnInfo =  (Button)findViewById(R.id.btnOk);
        final EditText editName =  (EditText)findViewById(R.id.txtName);
        final EditText editEmail =  (EditText)findViewById(R.id.txtEmail);
        final CheckBox chkA =  (CheckBox) findViewById(R.id.chbA);
        final CheckBox chkB =  (CheckBox) findViewById(R.id.chbB);
        final CheckBox chkC =  (CheckBox) findViewById(R.id.chbC);
        final RadioButton rdMale =  (RadioButton) findViewById(R.id.rdMale);
        final RadioButton rdFemale =  (RadioButton) findViewById(R.id.rdFemale);
        final Spinner spinLang =  (Spinner) findViewById(R.id.spinLang);
        final Switch switchExpert =  (Switch) findViewById(R.id.switchExpert);


        btnCancel.setOnClickListener(new View.OnClickListener() {

                                         public void onClick(View v) {
                                             Cancel(v);
                                         }
                                     }
        );
        btnInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String msg = "My name: " + editName.getText().toString() +
                        System.getProperty("line.separator") +
                        "Email: " + editEmail.getText().toString();
                msg += System.getProperty("line.separator") + "My hobbies: ";
                if(chkA.isChecked())
                    msg +=  chkA.getText().toString()+ ", ";
                if(chkB.isChecked())
                    msg += chkB.getText().toString() + ", ";
                if(chkC.isChecked())
                    msg += chkC.getText().toString()+ ", ";
                msg += System.getProperty("line.separator") + "My Sex: ";
                if(rdFemale.isChecked())
                    msg += rdFemale.getText().toString();
                if(rdMale.isChecked())
                    msg += rdMale.getText().toString();
                msg += System.getProperty("line.separator") + "My language: " + spinLang.getSelectedItem().toString();
                msg += System.getProperty("line.separator") + "Do you have experience with Java frameworks: ";
                if(switchExpert.isChecked())
                    msg += "Yes";
                else
                    msg += "No";
                Info(v,msg);
                editName.setText("");
                editEmail.setText("");
                chkA.setChecked(false);
                chkB.setChecked(false);
                chkC.setChecked(false);
                rdFemale.setChecked(false);
                rdMale.setChecked(false);


            }
        });
    }




    public  void  Cancel(View v)
    {
        System.exit(0);
    }

    public void Info(View v, String msg){
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage(msg);
        dlgAlert.setTitle("My New App");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }
}
