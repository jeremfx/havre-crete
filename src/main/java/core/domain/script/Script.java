package core.domain.script;

import core.domain.choice.Choice;
import core.domain.choice.ChoiceNumber;

import java.util.List;
import java.util.Optional;

public interface Script {
    List<Choice> choices();
    Script choose(ChoiceNumber choice);
    String content();
    List<Tag> tags();
    String title();
}
