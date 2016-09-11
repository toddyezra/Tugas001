package id.sch.smktelkom_mlg.learn.pengembalianbuku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama ;
    EditText etKelas ;
    Button bOK;
    Spinner spJurusan;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etKelas = (EditText) findViewById(R.id.editTextKelas);
        bOK = (Button) findViewById(R.id.buttonOK);
        spJurusan = (Spinner)findViewById(R.id.spinnerJurusan);
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
        tvHasil.setText(nama+" dari kelas "+kelas+" "+spJurusan.getSelectedItem().toString());
    }
}

    private boolean isValid() {
        boolean valid = true;
        String nama = etNama.getText().toString();
        String kelas = etKelas.getText().toString();

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
            etKelas.setError("kelas belom diisi");
        }
        else
        {
            etKelas.setError(null);
        }
        return false;

    }

}
