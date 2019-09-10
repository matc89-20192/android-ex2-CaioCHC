package matc89.exercicio2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class outraActivity extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outra);
        editText = (EditText)findViewById(R.id.editText);
        editText.setText("");
        Bundle extras = getIntent().getExtras();
        if(extras!=null) {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            String texto = prefs.getString("texto", extras.getString("nome"));
            editText.setText(texto);
        }

    }
    public void botaoCancelar(View v) {
        finish();
    }
    public void botaoConfirmar(View v) {
        Intent data = new Intent();
        data.putExtra("usuario",editText.getText().toString());
        setResult(RESULT_OK, data);
        finish();
    }
}
