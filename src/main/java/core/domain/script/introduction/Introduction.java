package core.domain.script.introduction;

import core.domain.choice.Choice;
import core.domain.choice.ChoiceNumber;
import core.domain.FunctionalException;
import core.domain.script.ChanceOfSuccess;
import core.domain.script.Script;
import core.domain.script.Tag;

import java.util.ArrayList;
import java.util.List;

public class Introduction implements Script {

    private final List<Tag> tags;

    public Introduction() {
        this.tags = List.of(Tag.VISIBILITE_REDUITE);
    }

    @Override
    public List<Choice> choices() {
        return List.of(
                new Choice.Builder(ChoiceNumber.CHOICE_1, "Les rudiments de la survie en milieu dangereux")
                        .tagToEarn(Tag.SPECIALISTE_SURVIE)
                        .build(),
                new Choice.Builder(ChoiceNumber.CHOICE_2,  "La préparation et l'exécution d'attaque surprise")
                        .tagToEarn(Tag.SPECIALISTE_EMBUSCADE)
                        .build(),
                new Choice.Builder(ChoiceNumber.CHOICE_3,  "Le combat rapproché au marteau")
                        .tagToEarn(Tag.SPECIALISTE_COMBAT_MARTEAU)
                        .build()
        );
    }

    @Override
    public Script choose(ChoiceNumber choice) {
        return switch(choice){
            case CHOICE_1 -> {
                List<Tag> newTags = new ArrayList<>(tags);
                newTags.add(Tag.SPECIALISTE_SURVIE);
                yield new PlanVsDrones(newTags);
            }
            case CHOICE_2 -> {
                List<Tag> newTags = new ArrayList<>(tags);
                newTags.add(Tag.SPECIALISTE_EMBUSCADE);
                yield new PlanVsDrones(newTags);
            }
            case CHOICE_3 -> {
                List<Tag> newTags = new ArrayList<>(tags);
                newTags.add(Tag.SPECIALISTE_COMBAT_MARTEAU);
                yield new PlanVsDrones(newTags);
            }
            case CHOICE_4 -> throw new FunctionalException("Choice not allowed");
        };
    }

    @Override
    public String content() {
        return """
                <p>La neige crisse sous vos pieds à mesure que vous vous enfoncez dans la forêt. Le temps est lumineux, presque éblouissant malgré le brouillard épais qui restreint la visibilité. Il est tôt dans la matinée et le trajet qui vous attend est long : 3 jours de marche jusqu'à la scierie. Vos compagnons et vous êtes endurcis à ce genre de parcours et la bonne humeur règne dans le groupe. Solvik, un des bûcherons qui vous accompagne s’adresse à vous : “XXX, je crois que c’est la première fois que je te vois sur une escorte avec nous, ça fait longtemps que tu fais ça ?</p>
                            
                <p>PJ : “Non, je viens d'intégrer les UPH (unités de protection d'Havre-créte), j’ai terminé ma formation la semaine dernière.”</p>
                            
                <p>Solvik : “On a souvent des jeunes recrues comme toi dans les escortes, le risque est minime et ça permet de confirmer la condition physique j’imagine ! Tu as choisi quelle spécialité lors de la formation ?”</p>
                            
                <p>PJ : “Après les 6 mois d'entraînements initiaux j’ai approfondi :”
                """;
    }

    @Override
    public List<Tag> tags() {
        return tags;
    }

    @Override
    public String title() {
        return "Forêt de brume-épine, 6h30";
    }
}
