package core.domain.script.introduction;

import core.domain.FunctionalException;
import core.domain.choice.Choice;
import core.domain.choice.ChoiceNumber;
import core.domain.script.Script;
import core.domain.script.Tag;

import java.util.ArrayList;
import java.util.List;

public class PlanVsDrones implements Script {

    private final List<Tag> tags;

    public PlanVsDrones(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public List<Choice> choices() {
        return List.of(
                new Choice(ChoiceNumber.CHOICE_1, "Rejoindre la position de Freyva, " +
                        "il est trop dangereux de laisser le reste du groupe derrière. Si les drones viennent jusqu’ici nous les combattrons !"),
                new Choice(ChoiceNumber.CHOICE_2, "Rejoindre la position de Eirix, " +
                        "la présence des drones aussi loin de l’enclave est inquiétante il faut en savoir plus et si nécessaire les intercepter."));
    }


    @Override
    public Script choose(ChoiceNumber choice) {
        return switch(choice){
            case CHOICE_1, CHOICE_2 -> new Introduction();
            case CHOICE_3, CHOICE_4 -> throw new FunctionalException("Choice not allowed");
        };
    }

    @Override
    public String content() {
        return """
                <p>Soudain, Eirix, l’éclaireur du groupe fait signe à tout le monde de s’arrêter pendant que sa chouette Astridra décolle de son épaule. Vous vous concentrez sur votre environnement et vous commencez à entendre un bourdonnement lointain, ce bruit est discret et vous ne l’avez entendu que peu de fois, mais vous le reconnaitrez entre mille : ce sont les drones du nexus qui approchent !</p>
                            
                <p>Le bourdonnement s’intensifie et il ne fait aucun doute que les drones ne sont plus très loin. Freyva, la cheffe de groupe, fait signe aux bûcherons de se cacher rapidement. D’un pas furtif mais déterminé vous rejoignez Freyva et le reste de l’escouade Eirix et Tyven.</p>
                            
                <p>Vous échangez quelques mots rapides avec vos compagnons : Freyva veut rester en arrière et protéger les hommes tandis que Eirix veut se rapprocher des drones, Tyven est hésitant.</p>
                """;
    }

    @Override
    public List<Tag> tags() {
        return tags;
    }

    @Override
    public String title() {
        return "";
    }
}
