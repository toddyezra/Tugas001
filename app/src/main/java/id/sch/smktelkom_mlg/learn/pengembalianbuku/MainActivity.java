package id.sch.smktelkom_mlg.learn.pengembalianbuku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama ;
    EditText etKelas ;
    Button bOK;
    Spinner spJurusan;
    RadioButton rbSes, rbSeb;
    CheckBox cbBipa, cbBmtk,cbBkamus;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etKelas = (EditText) findViewById(R.id.editTextKelas);
        bOK = (Button) findViewById(R.id.buttonOK);
        spJurusan = (Spinner)findViewById(R.id.spinnerJurusan);
        rbSes = (RadioButton) findViewById(R.id.radioButtonSes);
        rbSeb = (RadioButton) findViewById(R.id.radioButtonSeb);
        cbBipa= (CheckBox) findViewById(R.id.checkBoxIpa);
        cbBmtk = (CheckBox) findViewById(R.id.checkBoxMtk);
        cbBkamus = (CheckBox) findViewById(R.id.checkBoxKamus);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doProcess();

            }
        });
    }

    private void doProcess() {
        {
            if (isValid());

            String nama = etNama.getText().toString();
                 String kelas = etKelas.getText().toString();
            String hasil= "  Buku yang telah dikembalikan \n";
            String hasil1= "Tanggal Check \n";

            {
                int startlen = hasil.length();
                if (cbBipa.isChecked()) hasil+=cbBipa.getText()+"\n";
                if (cbBmtk.isChecked()) hasil+=cbBmtk.getText()+"\n";
                if (cbBkamus.isChecked()) hasil+=cbBkamus.getText()+"\n";

                if (hasil.length()==startlen) hasil+="Tidak ada pilihan";
            }
            {
                if (rbSes.isChecked()) hasil1+=rbSes.getText()+"\n";
                if (rbSeb.isChecked()) hasil1+=rbSeb.getText()+"\n";
            }

        tvHasil.setText(nama+" dari kelas "+kelas+" "+spJurusan.getSelectedItem().toString()+",   "+hasil+hasil1);
    }
}

    private boolean isValid() {
        boolean valid = true;
        String nama = etNama.getText().toString();
        String kelas = etKelas.getText().toString();
        String hasil= "Buku yang telah dikembalikan \n";



        if (nama.isEmpty())
        {
            etNama.setError("Nama Belum diisi");
            valid = false;
        }
        else
        {
            etNama.setError(null);
        }

        if (kelas.isEmpty())
        {
            etKelas.setError("kelas belum diisi");
        }
        else
        {
            etKelas.setError(null);
        }






        return false;

    }

}
