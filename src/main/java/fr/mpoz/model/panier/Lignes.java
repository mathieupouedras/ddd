package fr.mpoz.model.panier;

import fr.mpoz.model.finance.Devise;
import fr.mpoz.model.finance.Montant;

import java.util.ArrayList;
import java.util.List;

import static fr.mpoz.model.finance.Montant.zeroEuro;

public class Lignes {

    private List<Ligne> lignes;
    private Devise devise;

    public Lignes(Devise devise) {
        this.lignes = new ArrayList<Ligne>();
        this.devise = devise;
    }

    public Montant calculerMontantTotal() {
        Montant montantTotal = zeroEuro();
        for (Ligne ligne : lignes) {
            montantTotal = montantTotal.additionne(ligne.calculerMontant());
        }
        return montantTotal;
    }

    public void ajouter(Ligne ligne) {
        this.lignes.add(ligne);
    }
}
