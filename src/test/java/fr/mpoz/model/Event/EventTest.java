package fr.mpoz.model.Event;

import fr.mpoz.infrastructure.SequenceGeneratorInMemory;
import org.junit.Test;

import java.time.LocalDateTime;

import static fr.mpoz.model.Event.EventType.*;
import static java.time.LocalDateTime.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class EventTest {

    @Test
    public void should_afficher_to_string_correctement() {
        LocalDateTime now = now();
        Data data = new Data(1, 12, 3);
        Event event = new Event(PANIER_CREE, now, data, new SequenceGeneratorInMemory());

        String toString = event.toString();
        StringBuilder expectedToString = new StringBuilder();
        expectedToString.append("event{ type=").append(PANIER_CREE).append(", ");
        expectedToString.append("date=").append(now).append(", ");
        expectedToString.append(data.toString());
        expectedToString.append(" }");

        assertThat(toString, is(expectedToString.toString()));
    }

}