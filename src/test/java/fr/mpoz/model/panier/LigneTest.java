package fr.mpoz.model.panier;

import fr.mpoz.model.finance.Devise;
import fr.mpoz.model.finance.Montant;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LigneTest {

    @Test
    public void should_calcul_montant_total_de_1000_EUR() {
        Article iphone = new Article("iphone", new Montant(new BigDecimal(500), Devise.EURO));
        Ligne ligne = new Ligne(iphone, 2);

        Montant montantTotal = ligne.calculerMontant();

        assertThat(montantTotal, is(new Montant(new BigDecimal(1000), Devise.EURO)));
    }
}
