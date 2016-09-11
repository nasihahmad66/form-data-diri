package id.sch.smktelkom_mlg.tugas01.xirpl1023.formdatadiri;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama, etTelfon, etEmail;
    RadioGroup rgJK;
    CheckBox cbConceptor, cbCoder, cbDesign, cbAnalist, cbDatabase, cbTester;
    Spinner spKota;
    TextView tvNama, tvTelfon, tvEmail, tvJK, tvBidang, tvKota, TView1, tbidang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etNama = (EditText) findViewById(R.id.editTextNama);
        etTelfon = (EditText) findViewById(R.id.editTextTelfon);
        etEmail = (EditText) findViewById(R.id.editTextEmail);

        rgJK = (RadioGroup) findViewById(R.id.radioGroupJK);
        TView1 = (TextView) findViewById(R.id.TJK);

        tbidang = (TextView) findViewById(R.id.TTBidang);
        cbConceptor = (CheckBox) findViewById(R.id.checkBoxConceptor);
        cbCoder = (CheckBox) findViewById(R.id.checkBoxCoder);
        cbDesign = (CheckBox) findViewById(R.id.checkBoxDesign);
        cbAnalist = (CheckBox) findViewById(R.id.checkBoxAnalist);
        cbDatabase = (CheckBox) findViewById(R.id.checkBoxDatabase);
        cbTester = (CheckBox) findViewById(R.id.checkBoxTester);

        spKota = (Spinner) findViewById(R.id.spinnerKota);

        tvNama = (TextView) findViewById(R.id.textViewNama);
        tvTelfon = (TextView) findViewById(R.id.textViewTelfon);
        tvEmail = (TextView) findViewById(R.id.textViewEmail);
        tvJK = (TextView) findViewById(R.id.textViewJK);
        tvBidang = (TextView) findViewById(R.id.textViewBidang);
        tvKota = (TextView) findViewById(R.id.textViewKota);

        findViewById(R.id.buttonTampil).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });
    }

    private void doClick() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            String bidang = "";
            String telfon = etTelfon.getText().toString();
            String email = etEmail.getText().toString();
            String JK = null;
            int starlen = bidang.length();
            String kota = spKota.getSelectedItem().toString();

            tvNama.setText(nama + "\n");
            tvTelfon.setText("" + telfon + "\n");
            tvEmail.setText(email + "\n");

            if (rgJK.getCheckedRadioButtonId() != -1) {
                RadioButton rb = (RadioButton)
                        findViewById(rgJK.getCheckedRadioButtonId());
                JK = rb.getText().toString();
            }
            if (JK == null) {
                tvJK.setText("Anda Belum Memilih Jenis Kelamin");
                TView1.setError("Pilih Jenis Kelamin");
            } else {
                TView1.setError(null);
                tvJK.setText(JK + "\n");
            }

            if (cbConceptor.isChecked()) bidang += cbConceptor.getText() + "\n";
            if (cbCoder.isChecked()) bidang += cbCoder.getText() + "\n";
            if (cbDesign.isChecked()) bidang += cbDesign.getText() + "\n";
            if (cbAnalist.isChecked()) bidang += cbAnalist.getText() + "\n";
            if (cbDatabase.isChecked()) bidang += cbDatabase.getText() + "\n";
            if (cbTester.isChecked()) bidang += cbTester.getText() + "\n";
            if (bidang.length() == starlen) bidang += "Anda Belum Memilih Bidang";
            tvBidang.setText(bidang);

            tvKota.setText(kota);
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String telfon = etTelfon.getText().toString();
        String email = etEmail.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama Belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama Minimal 3 karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }
        if (telfon.isEmpty()) {
            etTelfon.setError("Nomor Telfon Belum diisi");
        } else if (telfon.length() < 12) {
            etTelfon.setError("Nomor : 628xxxxxxxxxx");
        } else if (telfon.length() > 13) {
            etTelfon.setError("Nomor : 628xxxxxxxxxx");
        } else {
            etTelfon.setError(null);
        }

        if (email.isEmpty()) {
            etEmail.setError("Email Tidak Boleh Kosog");
        } else if (email.length() < 8) {
            etEmail.setError("Email Anda Tidak Valid");
        } else {
            etEmail.setError(null);
        }
        return valid;
    }
}
