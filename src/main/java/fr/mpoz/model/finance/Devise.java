package fr.mpoz.model.finance;

public enum Devise {
    EURO("EUR"),
    DOLLAR("USD");

    private final String nomCourt;

    Devise(String nomCourt) {
        this.nomCourt = nomCourt;
    }

    @Override
    public String toString() {
        return nomCourt;
    }
}
