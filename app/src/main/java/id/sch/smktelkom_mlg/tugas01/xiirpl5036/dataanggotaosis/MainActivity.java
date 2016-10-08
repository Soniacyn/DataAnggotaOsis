package id.sch.smktelkom_mlg.tugas01.xiirpl5036.dataanggotaosis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText isinama;
    RadioButton rbL, rbP;
    Button bOK;
    TextView tvHasil, tvJk;
    CheckBox cbO, cbS1, cbS2;
    Spinner spJabatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isinama = (EditText) findViewById(R.id.editTextNama);
        rbL = (RadioButton) findViewById(R.id.radioButtonLaki);
        rbP = (RadioButton) findViewById(R.id.radioButtonPerempuan);
        bOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvJk = (TextView) findViewById(R.id.textView3);
        spJabatan = (Spinner) findViewById(R.id.spinnerJabatan);
        cbO = (CheckBox) findViewById(R.id.checkBoxOlahraga);
        cbS1 = (CheckBox) findViewById(R.id.checkBoxSeni);
        cbS2 = (CheckBox) findViewById(R.id.checkBoxSastra);

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });

    }

    private void doClick() {
        if (isValid()) {
            String nama = isinama.getText().toString();

            String jk = "(Not choosen)";

            if (rbL.isChecked()) {
                jk = rbL.getText().toString();
            } else if (rbP.isChecked()) {
                jk = rbP.getText().toString();
            }

            String jabatan = spJabatan.getSelectedItem().toString();

            String bakat = "Hobi Anda        : ";
            int startlen = bakat.length();
            if (cbO.isChecked()) bakat += cbO.getText() + "\n";
            if (cbS1.isChecked()) bakat += cbS1.getText() + "\n";
            if (cbS2.isChecked()) bakat += cbS2.getText() + "\n";

            if (jabatan.length() == startlen) jabatan += "(No object was choosen)";

            tvHasil.setText("Nama               : " + nama + "\n" + "Jenis Kelamin : " + jk + "\n"
                    + "Jabatan            : " + jabatan + "\n" + bakat);
        }
    }

    public boolean isValid() {
        boolean valid = true;

        String nama = isinama.getText().toString();
        String jk = "";

        if (nama.isEmpty()) {
            isinama.setError("Name must be filled!");
            valid = false;
        } else if (nama.length() < 3) {
            isinama.setError("Name min have 3 characters!");
            valid = false;
        } else {
            isinama.setError(null);
        }

        if (jk == null) {
            tvJk.setError("");
            valid = false;
        } else {
            tvJk.setError(null);
        }
        return valid;
    }

}
