package fr.mpoz.model.panier;

import fr.mpoz.model.finance.Devise;
import fr.mpoz.model.finance.Montant;
import org.junit.Test;

import java.math.BigDecimal;

import static fr.mpoz.model.finance.Montant.zeroEuro;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PanierTest {

    private Panier PANIER_VIDE = new Panier();

    @Test
    public void should_return_montantTotal_zero_euro_quand_le_panier_est_vide() {

        Panier panier = new Panier();

        Montant montantTotal = panier.calculerMontantTotal();

        assertThat(montantTotal, is(zeroEuro()));
    }

}
