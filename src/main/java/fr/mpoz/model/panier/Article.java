package fr.mpoz.model.panier;

import fr.mpoz.model.finance.Montant;
import fr.mpoz.model.shared.SequenceGenerator;

public class Article {

    private final Integer id;
    private final String reference;
    private final Montant prix;
    private SequenceGenerator sequenceGenerator;

    public Article(String reference, Montant prix, SequenceGenerator sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
        this.id = sequenceGenerator.getValeurSuivante(this.getClass().getName());
        this.reference = reference;
        this.prix = prix;
    }

    public Montant getPrix() {
        return prix;
    }

    @Override
    public String toString() {
        return "Article{" +
                "reference='" + reference + '\'' +
                ", prix=" + prix +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        return reference.equals(article.reference);

    }

    @Override
    public int hashCode() {
        return reference.hashCode();
    }

    public String getReference() {
        return this.reference;
    }

    public Integer getId() {
        return this.id;
    }
}
