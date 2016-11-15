package fr.mpoz.model.finance;

import java.math.BigDecimal;

public class Montant {

    private BigDecimal valeur;
    private final Devise devise;

    public final static Montant ZERO_EURO = new Montant(BigDecimal.ZERO, Devise.EURO);

    public Montant(BigDecimal valeur, Devise devise) {
        this.valeur = valeur;
        this.devise = devise;
    }

    @Override
    public String toString() {
        return valeur + " " + devise;
    }

    @Override
    public int hashCode() {
        int result = valeur.hashCode();
        result = 31 * result + devise.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Montant montant = (Montant) o;

        if (!valeur.equals(montant.valeur)) return false;
        return devise == montant.devise;

    }

    public Montant multiplie(int quantite) {
        return new Montant(this.valeur.multiply(new BigDecimal(quantite)), Devise.EURO);
    }

    public Montant additionne(Montant montant) {
        return new Montant(this.valeur.add(montant.valeur), Devise.EURO);
    }
}
