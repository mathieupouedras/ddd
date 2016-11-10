package fr.mpoz.model.panier;

import fr.mpoz.model.finance.Devise;
import fr.mpoz.model.finance.Montant;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ArticleTest {

    @Test
    public void should_create_iphone_avec_prix_500_eur() {
        Article iphone = new Article("iphone", new Montant(new BigDecimal(500), Devise.EURO));

        assertThat(iphone.toString(), is("Article{reference='iphone', prix=500 EUR}"));
    }
}
