package fr.mpoz.model.panier;

import fr.mpoz.model.finance.Montant;

public class Ligne {

    private Article article;
    private int quantite;

    public Ligne(Article article, int quantite) {
        this.article = article;
        this.quantite = quantite;
    }

    public Montant calculerMontant() {
        return article.getPrix().multiplie(quantite);
    }
}
