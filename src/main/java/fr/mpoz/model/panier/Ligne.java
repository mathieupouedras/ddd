package fr.mpoz.model.panier;

import fr.mpoz.model.finance.Montant;

class Ligne {

    private Article article;
    private Integer quantite;

    Ligne(Article article, int quantite) {
        this.article = article;
        this.quantite = quantite;
    }

    Montant calculerMontant() {
        return article.getPrix().multiplie(quantite);
    }

    String getReference() {
        return this.article.getReference();
    }

    Integer getQuantite() {
        return this.quantite;
    }

    void augmenteQuantite(int quantite) {
        this.quantite += quantite;
    }

    public Integer getArticleId() {
        return this.article.getId();
    }


}
