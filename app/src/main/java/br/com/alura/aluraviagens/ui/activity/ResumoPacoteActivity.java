package br.com.alura.aluraviagens.ui.activity;

import static br.com.alura.aluraviagens.ui.activity.PacotesActivityConstantes.CHAVE_PACOTE;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.DataUtil;
import br.com.alura.aluraviagens.util.DiasUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;
import br.com.alura.aluraviagens.util.ResourcesUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    private static final String TITULO_APPBAR = "Resumo do pacote";

    private Pacote pacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle(TITULO_APPBAR);
        obterPacote();
    }

    private void obterPacote() {
        Intent intent = getIntent();
        pacote = intent.getParcelableExtra(CHAVE_PACOTE);

        if (pacote != null) {
            exibirCampos();
            configuraBotaoPagamento();
        }
    }

    private void exibirCampos() {
        exibirImagemDoPacote();
        exibirLocal();
        exibirDias();
        exibirData();
        exibirPrecoTotal();
    }

    private void configuraBotaoPagamento() {
        Button btnPagamento = findViewById(R.id.resumo_pacote_btn_pagamento);
        btnPagamento.setOnClickListener(view -> vaiParaPagamento());
    }

    private void vaiParaPagamento() {
        Intent intent = new Intent(this, PagamentoActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void exibirPrecoTotal() {
        TextView tvPreco = findViewById(R.id.resumo_pacote_tv_preco);
        String precoFormatado = MoedaUtil.formatarParaBrasileiro(pacote.getPreco());
        tvPreco.setText(precoFormatado);
    }

    private void exibirData() {
        TextView tvData = findViewById(R.id.resumo_pacote_tv_data);
        String dataViagem = DataUtil.formatarPeriodo(pacote.getDias());
        tvData.setText(dataViagem);
    }

    private void exibirDias() {
        TextView tvDias = findViewById(R.id.resumo_pacote_tv_dias);
        String diasFormatados = DiasUtil.formatar(pacote.getDias());
        tvDias.setText(diasFormatados);
    }

    private void exibirLocal() {
        TextView tvLocal = findViewById(R.id.resumo_pacote_tv_local);
        tvLocal.setText(pacote.getLocal());
    }

    private void exibirImagemDoPacote() {
        ImageView ivPacote = findViewById(R.id.resumo_pacote_iv_pacote);
        Drawable drawable = ResourcesUtil.getDrawable(this, pacote.getImagem());
        ivPacote.setImageDrawable(drawable);
    }
}