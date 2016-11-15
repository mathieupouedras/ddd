package fr.mpoz.model.Event;

public class Data {

    final Integer idPanier;
    final Integer idArticle;
    final Integer quantite;

    public Data(Integer idPanier, Integer idArticle, Integer quantite) {
        this.idPanier = idPanier;
        this.idArticle = idArticle;
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "data{ idPanier=" + this.idPanier + ", idArticle=" + this.idArticle + " quantite=" + this.quantite + " }";
    }
}
