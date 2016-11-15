package fr.mpoz.model.panier;

import fr.mpoz.model.Catalogue.Catalogue;
import fr.mpoz.model.Event.Data;
import fr.mpoz.model.Event.Event;
import fr.mpoz.model.finance.Devise;
import fr.mpoz.model.finance.Montant;
import fr.mpoz.model.shared.SequenceGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static fr.mpoz.model.Event.EventType.*;
import static java.time.LocalDateTime.now;

public class Panier {

    private static final Integer PAS_DE_QUANTITE = null;
    private Integer id;
    private Lignes lignes;
    private Catalogue catalogue;

    public List<Event> getEvents() {
        return events;
    }

    private List<Event> events;
    private SequenceGenerator sequenceGenerator;

    public Panier(SequenceGenerator sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
        this.id = sequenceGenerator.getValeurSuivante(this.getClass().getName());
        catalogue = new Catalogue(this.sequenceGenerator);
        events = new ArrayList<>();
        this.lignes = new Lignes(Devise.EURO);
        events.add(new Event(PANIER_CREE, now(), new Data(this.id, null, null), this.sequenceGenerator));
    }

    public Montant calculerMontantTotal() {
        return lignes.calculerMontantTotal();
    }

    public void ajouterArticle(String reference) {
        Optional<Ligne> ligne = lignes.rechercher(reference);
        if (ligne.isPresent()) {
            augmenterQuantiteArticle(reference, 1);
        }
        else {
            ajouterNouvelArticle(reference);
        }
    }

    private void ajouterNouvelArticle(String reference) {
        Optional<Article> article = catalogue.findByReference(reference);
        if (article.isPresent()) {
            lignes.ajouter(new Ligne(article.get(), 1));
            events.add(new Event(ARTICLE_AJOUTE, now(),
                                    new Data(this.id, article.get().getId(), 1),
                                    this.sequenceGenerator));
        }
        else {
            throw new RuntimeException("Aucun article trouvé pour la réference : " + reference);
        }
    }

    public boolean isVide() {
        return lignes.taille() == 0;
    }

    int getArticleQuantite(String reference) {
        return lignes.getQuantite(reference);
    }

    void retirerArticle(String reference) {
        Integer articleId = this.lignes.retirer(reference);
        events.add(new Event(ARTICLE_RETIRE, now(),
                new Data(this.id, articleId, PAS_DE_QUANTITE),
                this.sequenceGenerator));
    }

    public void augmenterQuantiteArticle(String reference, Integer quantite) {
        Optional<Ligne> ligne = lignes.rechercher(reference);
        ligne.get().augmenteQuantite(quantite);
        events.add(new Event(QUANTITE_ARTICLE_AUGMENTE, now(),
                new Data(this.id, ligne.get().getArticleId(), quantite),
                this.sequenceGenerator));

    }
}
