package fr.mpoz.infrastructure;

import fr.mpoz.model.shared.SequenceGenerator;

import java.util.HashMap;
import java.util.Map;

public class SequenceGeneratorInMemory implements SequenceGenerator {

    private Map<String, Integer> sequences;

    public SequenceGeneratorInMemory() {
        this.sequences = new HashMap<>();
    }

    @Override
    public Integer getValeurSuivante(String entite) {
        Integer valeurCourante = sequences.get(entite);
        if (valeurCourante == null) {
            valeurCourante = 1;
        }
        else {
            valeurCourante++;
        }
        sequences.put(entite, valeurCourante);

        return valeurCourante;
    }
}
