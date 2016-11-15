package fr.mpoz.model.Event;

import fr.mpoz.model.shared.SequenceGenerator;

import java.time.LocalDateTime;

public class Event {

    private final Integer id;
    private final EventType type;
    private final LocalDateTime date;
    private final Data data;
    private SequenceGenerator sequenceGenerator;

    public Event(EventType type, LocalDateTime date, Data data, SequenceGenerator sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
        this.id = sequenceGenerator.getValeurSuivante(this.getClass().getName());
        this.type = type;
        this.date = date;
        this.data = data;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        return id.equals(event.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("event{ ");
        builder.append("type=").append(this.type).append(", ");
        builder.append("date=").append(this.date).append(", ");
        builder.append(data);
        builder.append(" }");

        return builder.toString();
    }
}

