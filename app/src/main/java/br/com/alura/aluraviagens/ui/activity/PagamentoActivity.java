package br.com.alura.aluraviagens.ui.activity;

import static br.com.alura.aluraviagens.ui.activity.PacotesActivityConstantes.CHAVE_PACOTE;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity {

    private static final String TITULO_APPBAR = "Pagamento";

    private Pacote pacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(TITULO_APPBAR);

        Intent intent = getIntent();
        pacote = intent.getParcelableExtra(CHAVE_PACOTE);

        if (pacote != null) {
            mostraPreco();
            configuraBotaoFinalizarCompra();
        }
    }

    private void configuraBotaoFinalizarCompra() {
        Button btnFinalizarCompra = findViewById(R.id.pagamento_btn_finalizar_compra);
        btnFinalizarCompra.setOnClickListener(view -> vaiParaResumoCompra());
    }

    private void vaiParaResumoCompra() {
        Intent intent = new Intent(this, ResumoCompraActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraPreco() {
        TextView tvPrecoPacote = findViewById(R.id.pagamento_tv_preco_pacote);
        String precoFormatado = MoedaUtil.formatarParaBrasileiro(pacote.getPreco());
        tvPrecoPacote.setText(precoFormatado);
    }
}