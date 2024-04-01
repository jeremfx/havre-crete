package core.domain.script;

public enum Tag {
    SPECIALISTE_SURVIE("Spécialiste : survie dans la nature", "Spécialisé dans la survie en milieu hostile"),
    SPECIALISTE_EMBUSCADE("Spécialiste : embuscade", "Spécialisé dans la planification et l'exécution d'attque surprise"),
    SPECIALISTE_COMBAT_MARTEAU("Spécialiste : combat au marteau", "Spécialisé dans le combat au marteau"),
    VISIBILITE_REDUITE("Visibilité réduite", "La visibilité est restreinte dans cette environnement"),

    AMIS_DES_BETES("Amis des bêtes", "Amis des bêtes"),

    ;

    public final String name;
    public final String description;

    Tag(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
