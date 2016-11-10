package fr.mpoz.model.panier;

import fr.mpoz.model.finance.Devise;
import fr.mpoz.model.finance.Montant;

class Panier {

    private Lignes lignes;

    public Panier() {
        this.lignes = new Lignes(Devise.EURO);
    }

    public Montant calculerMontantTotal() {
        return lignes.calculerMontantTotal();
    }
}
