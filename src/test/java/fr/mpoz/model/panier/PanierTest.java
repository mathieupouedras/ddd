package fr.mpoz.model.panier;

import fr.mpoz.infrastructure.SequenceGeneratorInMemory;
import fr.mpoz.model.finance.Montant;
import fr.mpoz.model.shared.SequenceGenerator;
import org.junit.Test;

import java.math.BigDecimal;

import static fr.mpoz.model.finance.Devise.EURO;
import static fr.mpoz.model.finance.Montant.ZERO_EURO;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PanierTest {

    private Panier PANIER_VIDE = new Panier(new SequenceGeneratorInMemory());

    @Test
    public void should_return_montantTotal_zero_euro_quand_le_panier_est_vide() {

        Panier panier = new Panier(new SequenceGeneratorInMemory());

        Montant montantTotal = panier.calculerMontantTotal();

        assertThat(montantTotal, is(ZERO_EURO));
    }

    @Test
    public void should_etre_vide() {
        Panier panier = new Panier(new SequenceGeneratorInMemory());

        assertThat(panier.isVide(), is(true));
    }

    @Test
    public void should_contenir_3_iphone() {
        Panier panier = new Panier(new SequenceGeneratorInMemory());

        panier.ajouterArticle("iphone");
        panier.ajouterArticle("iphone");
        panier.ajouterArticle("iphone");

        assertThat(panier.getArticleQuantite("iphone"), is(3));
    }

    @Test
    public void should_etre_vide_apres_ajouter_et_retirer_iphone() {
        Panier panier = new Panier(new SequenceGeneratorInMemory());

        panier.ajouterArticle("iphone");
        panier.retirerArticle("iphone");

        assertThat(panier.isVide(), is(true));
    }

    @Test public void should_augmenter_quantite() {
        Panier panier = new Panier(new SequenceGeneratorInMemory());
        panier.ajouterArticle("iphone");
        panier.augmenterQuantiteArticle("iphone", 5);

        assertThat(panier.getArticleQuantite("iphone"), is(6));

    }

     @Test
    public void should_calculer_montant_de_3090_EUR() {
         Panier panier = new Panier(new SequenceGeneratorInMemory());

         panier.ajouterArticle("iphone");
         panier.ajouterArticle("iphone");
         panier.ajouterArticle("iphone");

         panier.ajouterArticle("coque");
         panier.ajouterArticle("coque");
         panier.ajouterArticle("coque");

         assertThat(panier.calculerMontantTotal(), is(new Montant(new BigDecimal("3090"), EURO)));
    }

    @Test(expected = RuntimeException.class)
    public void should_lance_RuntimeException_quand_la_reference_est_inconnue_du_catalogue() {
        Panier panier = new Panier(new SequenceGeneratorInMemory());

        panier.ajouterArticle("REFERENCE_INCONNUE");
    }

    @Test
    public void should_contenir_4_events() {
        SequenceGenerator sequenceGenerator = new SequenceGeneratorInMemory();
        Panier panierIphone = new Panier(sequenceGenerator);
        panierIphone.ajouterArticle("iphone");
        panierIphone.augmenterQuantiteArticle("iphone", 3);
        panierIphone.retirerArticle("iphone");

        assertThat(panierIphone.getEvents().size(), is(4));

        Panier panierCoque = new Panier(sequenceGenerator);
        panierCoque.ajouterArticle("coque");

        assertThat(panierCoque.getEvents().size(), is(2));

        panierIphone.getEvents().stream().forEach(event -> System.out.println(event));
        System.out.println("****************************");
        panierCoque.getEvents().stream().forEach(event -> System.out.println(event));
    }

}
