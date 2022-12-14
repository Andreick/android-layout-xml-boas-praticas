package br.com.alura.aluraviagens.util;

import android.content.res.Resources;

import androidx.core.os.ConfigurationCompat;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class MoedaUtil {

    public static String formatarParaBrasileiro(BigDecimal valor) {
        NumberFormat formatadorBrasileiro = NumberFormat
                .getCurrencyInstance(LocaleUtil.getLocaleBrasileiro());
        ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration()).get(0);
        return formatadorBrasileiro.format(valor);
    }

}
