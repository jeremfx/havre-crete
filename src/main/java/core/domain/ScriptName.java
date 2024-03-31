package core.domain;

public enum ScriptName {
    INTRO("private/introduction/specialite.html"),
    CHOIX_SPECIALITE("private/introduction/plan-eirix-ou-freyva.html"),
    ;
    public final String fileName;

    ScriptName(String fileName) {
        this.fileName = fileName;
    }
}
