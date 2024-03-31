package core.domain.script;

public enum Tag {
    SPECIALISTE_SURVIE("Spécialisé dans la survie en milieu hostile"),
    SPECIALISTE_EMBUSCADE("Spécialisé dans la planification et l'exécution d'attque surprise"),
    SPECIALISTE_COMBAT_MARTEAU("Spécialisé dans le combat au marteau"),
    VISIBILITE_REDUITE("La visibilité est restreinte dans cette environnement");

    public final String description;

    Tag(String description) {
        this.description = description;
    }
}
