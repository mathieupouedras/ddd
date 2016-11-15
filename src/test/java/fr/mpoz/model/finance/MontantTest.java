package fr.mpoz.model.finance;

import fr.mpoz.model.finance.Devise;
import fr.mpoz.model.finance.Montant;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MontantTest {

    @Test
    public void should_create_montant_de_10_euros() {
        Montant dixEuros = new Montant(BigDecimal.TEN, Devise.EURO);

        assertThat(dixEuros.toString(), is("10 EUR"));
    }
}
