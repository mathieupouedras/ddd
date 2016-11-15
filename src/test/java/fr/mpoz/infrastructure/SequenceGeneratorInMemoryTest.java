package fr.mpoz.infrastructure;

import fr.mpoz.model.panier.Article;
import fr.mpoz.model.panier.Panier;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SequenceGeneratorInMemoryTest {

    @Test
    public void should_retourne_valeur_suivante_1() {
        SequenceGeneratorInMemory sequenceGeneratorInMemory = new SequenceGeneratorInMemory();

        assertThat(sequenceGeneratorInMemory.getValeurSuivante(Article.class.getName()), is(1));
    }

    @Test
    public void should_retourne_valeur_suivante_article_3_et_valeur_suivante_panier_1() {
        SequenceGeneratorInMemory sequenceGeneratorInMemory = new SequenceGeneratorInMemory();

        sequenceGeneratorInMemory.getValeurSuivante(Article.class.getName());
        sequenceGeneratorInMemory.getValeurSuivante(Article.class.getName());
        Integer valeurSuivanteArticle = sequenceGeneratorInMemory.getValeurSuivante(Article.class.getName());

        Integer valeurSuivantePanier = sequenceGeneratorInMemory.getValeurSuivante(Panier.class.getName());

        assertThat(valeurSuivanteArticle, is(3));
        assertThat(valeurSuivantePanier, is(1));
    }
}