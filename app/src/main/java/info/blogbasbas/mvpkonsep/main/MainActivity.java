package info.blogbasbas.mvpkonsep.main;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import info.blogbasbas.mvpkonsep.R;


public class MainActivity extends AppCompatActivity implements MainView {
    //buat variabel global untuk presenter dan widget di layout
    Button button;
    MainPresenter mainPresenter;
    String ambilDataA, ambilDataB;
    EditText edtA,edtB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // inisialisasi id
      button   = (Button) findViewById(R.id.btn_tekanini);
      edtA = (EditText) findViewById(R.id.edt_a);
      edtB = (EditText) findViewById(R.id.edt_b);
        mainPresenter = new MainPresenter();
        onAttachVIew();
    }


    @Override
    public void showDataInDialog() {
        ambilDataA = edtA.getText().toString();
        ambilDataB = edtB.getText().toString();

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("TEST MVP");
        builder.setMessage(" Hasil inputan "+ambilDataA +" dan "+ambilDataB);
        builder.show();

    }

    @Override
    public void showError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSukses() {
        Toast.makeText(this, "Sukses", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAttachVIew() {
        mainPresenter.onAttach(this);
        addButton();

    }

    private void addButton() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              mainPresenter.showData(edtA.getText().toString(),edtB.getText().toString());
            }
        });
    }

    @Override
    public void onDetachView() {
        mainPresenter.onDetach();
    }
}
