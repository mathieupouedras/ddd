package fr.mpoz.model.panier;

import fr.mpoz.infrastructure.SequenceGeneratorInMemory;
import fr.mpoz.model.finance.Devise;
import fr.mpoz.model.finance.Montant;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LignesTest {

    @Test
    public void should_calcul_montant_total_de_1060_EUR() {
        // GIVEN
        Article iphone = new Article("iphone", new Montant(new BigDecimal(500), Devise.EURO), new SequenceGeneratorInMemory());
        Article housse = new Article("housse", new Montant(new BigDecimal(30), Devise.EURO), new SequenceGeneratorInMemory());

        Ligne ligneIphone = new Ligne(iphone, 2);
        Ligne ligneHousse = new Ligne(housse, 2);

        Lignes lignes = new Lignes(Devise.EURO);
        lignes.ajouter(ligneIphone);
        lignes.ajouter(ligneHousse);

        // WHEN
        Montant montantTotal = lignes.calculerMontantTotal();

        // THEN
        assertThat(montantTotal, is(new Montant(new BigDecimal(1060), Devise.EURO)));
    }
}
