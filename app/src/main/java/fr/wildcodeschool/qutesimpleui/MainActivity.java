package fr.wildcodeschool.qutesimpleui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox checkWilder = findViewById(R.id.check_wilder);
        checkWilder.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                EditText editFirstname = findViewById(R.id.edit_firstname);
                EditText editLastname = findViewById(R.id.edit_lastname);
                Button buttonAccept = findViewById(R.id.button_accept);
                if (isChecked){
                    editFirstname.setEnabled(true);
                    editLastname.setEnabled(true);
                    buttonAccept.setEnabled(true);

                }
                else {
                    editFirstname.setEnabled(false);
                    editLastname.setEnabled(false);
                    buttonAccept.setEnabled(false);
                }

            }
        });

        Button buttonAccept = findViewById(R.id.button_accept);
        buttonAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editFirstname = findViewById(R.id.edit_firstname);
                String firstname = editFirstname.getText().toString();
                EditText editLastname = findViewById(R.id.edit_lastname);
                String lastname = editLastname.getText().toString();
                TextView textCongrat = findViewById(R.id.text_congrat);
                String congrat = textCongrat.getText().toString();
                if(firstname.matches("")|(lastname.matches(""))){
                    Toast.makeText(MainActivity.this, "Please fill your firstname and lastname !", Toast.LENGTH_SHORT).show();
                }

                else{
                    String mgs = "Congratulation " + firstname + " " + lastname;
                    textCongrat.setText(mgs);
                   //Toast.makeText(MainActivity.this, "Congratulation " + firstname + " " + lastname, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}
