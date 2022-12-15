package br.com.alura.aluraviagens.ui.activity;

import static br.com.alura.aluraviagens.ui.activity.PacotesActivityConstantes.CHAVE_PACOTE;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.DataUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;
import br.com.alura.aluraviagens.util.ResourcesUtil;

public class ResumoCompraActivity extends AppCompatActivity {

    private static final String TITULO_APPBAR = "Resumo da compra";

    private Pacote pacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        setTitle(TITULO_APPBAR);

        Intent intent = getIntent();
        pacote = intent.getParcelableExtra(CHAVE_PACOTE);

        if (pacote != null) {
            exibirImagemDoPacote();
            exibirLocal();
            exibirData();
            exibirPrecoTotal();
        }
    }

    private void exibirPrecoTotal() {
        TextView tvPreco = findViewById(R.id.resumo_compra_preco_pacote);
        String precoFormatado = MoedaUtil.formatarParaBrasileiro(pacote.getPreco());
        tvPreco.setText(precoFormatado);
    }

    private void exibirData() {
        TextView tvData = findViewById(R.id.resumo_compra_data_viagem);
        String dataViagem = DataUtil.formatarPeriodo(pacote.getDias());
        tvData.setText(dataViagem);
    }

    private void exibirLocal() {
        TextView tvLocal = findViewById(R.id.resumo_compra_local_pacote);
        tvLocal.setText(pacote.getLocal());
    }

    private void exibirImagemDoPacote() {
        ImageView ivPacote = findViewById(R.id.resumo_compra_iv_pacote);
        Drawable drawable = ResourcesUtil.getDrawable(this, pacote.getImagem());
        ivPacote.setImageDrawable(drawable);
    }
}