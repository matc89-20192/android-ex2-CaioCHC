package matc89.exercicio2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mensagem;
    private String nome = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mensagem = (TextView)findViewById(R.id.textView);
    }

    public void botaoClicado(View v) {
        Intent intent = new Intent(this, outraActivity.class);
        intent.putExtra("nome",nome);
        startActivityForResult(intent,1234);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 1234 && resultCode == RESULT_OK) {
            nome = data.getStringExtra("usuario");
            if(nome.length()>0){
                mensagem.setText("Oi, "+nome+"!");
            }
            else
                mensagem.setText("Oi!");
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("meutexto", mensagem.getText().toString());
        outState.putString("nome",nome);

    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String meutexto = savedInstanceState.getString("meutexto");
        mensagem.setText(meutexto);
        String meuNome = savedInstanceState.getString("nome");
        nome = meuNome;
    }

}
