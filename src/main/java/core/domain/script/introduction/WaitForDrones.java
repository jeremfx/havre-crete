package core.domain.script.introduction;

import core.domain.FunctionalException;
import core.domain.choice.Choice;
import core.domain.choice.ChoiceNumber;
import core.domain.script.ChanceOfSuccess;
import core.domain.script.Script;
import core.domain.script.Tag;

import java.util.List;

public record WaitForDrones(List<Tag> tags) implements Script {

    @Override
    public List<Choice> choices() {
        return List.of(
                new Choice.Builder(ChoiceNumber.CHOICE_1, "Essayer de rassurer les rennes pour qu’ils se calment.")
                        .chanceOfSuccess(new ChanceOfSuccess(50))
                        .tagToEarn(Tag.AMIS_DES_BETES)
                        .build(),
                new Choice.Builder(ChoiceNumber.CHOICE_2, "Demander à quelqu’un d’autre de s’en occuper.")
                        .chanceOfSuccess(new ChanceOfSuccess(80))
                        .build()
        );
    }

    @Override
    public Script choose(ChoiceNumber choice) {
        return switch (choice) {
            case CHOICE_1 -> new Introduction();
            case CHOICE_2 -> new Introduction();
            case CHOICE_3, CHOICE_4 -> throw new FunctionalException("Choice not allowed");
        };
    }

    @Override
    public String content() {
        return """
                <p>A l’écoute de vos arguments Tyrven acquiesce. A  3 contre 1, Eirix est contraint, à regret, de suivre la décision du groupe.<p>
                                
                <p>Pendant ce temps, les rennes qui tiraient le traîneau de matériel commencent à s’agiter, ce n’est pas tant le bourdonnement des drones que le comportement des hommes qui les à alertés. Il faut vite qu’ils se calment sinon les drones pourraient nous repérer !<p>
                """;
    }

    @Override
    public String title() {
        return "Forêt de brume-épine, 6h30";
    }
}
