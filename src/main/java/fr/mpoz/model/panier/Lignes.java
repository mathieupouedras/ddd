package fr.mpoz.model.panier;

import fr.mpoz.model.finance.Devise;
import fr.mpoz.model.finance.Montant;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static fr.mpoz.model.finance.Montant.ZERO_EURO;

class Lignes {

    private List<Ligne> lignes;
    private Devise devise;

    Lignes(Devise devise) {
        this.lignes = new ArrayList<>();
        this.devise = devise;
    }

    Montant calculerMontantTotal() {
        Montant montantTotal = ZERO_EURO;
        for (Ligne ligne : lignes) {
            montantTotal = montantTotal.additionne(ligne.calculerMontant());
        }
        return montantTotal;
    }

    void ajouter(Ligne ligne) {
        this.lignes.add(ligne);
    }

    int taille() {
        return lignes.size();
    }

    Optional<Ligne> rechercher(String reference) {
        return lignes.stream().filter(ligne -> ligne.getReference().equals(reference)).findFirst();
    }

    int getQuantite(String reference) {
        return this.rechercher(reference).get().getQuantite();
    }

    Integer retirer(String reference) {
        Ligne ligne = this.rechercher(reference).get();
        this.lignes.remove(ligne);
        return ligne.getArticleId();
    }
}
