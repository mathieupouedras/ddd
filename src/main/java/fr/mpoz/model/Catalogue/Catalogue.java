package fr.mpoz.model.Catalogue;

import fr.mpoz.infrastructure.SequenceGeneratorInMemory;
import fr.mpoz.model.finance.Montant;
import fr.mpoz.model.panier.Article;
import fr.mpoz.model.shared.SequenceGenerator;

import java.math.BigDecimal;
import java.util.Optional;

import static fr.mpoz.model.finance.Devise.EURO;

public class Catalogue {

    private SequenceGenerator sequenceGenerator;

    public Catalogue(SequenceGenerator sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    public Optional<Article> findByReference(String reference) {
        switch (reference) {
            case("iphone") : {
                return Optional.of(new Article(reference, new Montant(new BigDecimal("1000"), EURO), sequenceGenerator));
            }
            case("coque") : {
                return Optional.of(new Article(reference, new Montant(new BigDecimal("30"), EURO), sequenceGenerator));
            }
            default: {
                return Optional.empty();
            }
        }

    }

}
