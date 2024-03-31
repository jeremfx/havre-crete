package core.domain;

import core.domain.choice.Choice;
import core.domain.choice.ChoiceNumber;
import core.domain.script.Script;
import core.domain.script.Tag;
import core.domain.script.introduction.Introduction;

import java.util.ArrayList;
import java.util.List;

public class Run {
    public final RunId runId;

    public final Script currentScript;

    public final List<Tag> currentTags;

    public List<Choice> choices() {
        return currentScript.choices();
    }

    public Run(RunId runId) {
        this.runId = runId;
        this.currentScript = new Introduction();
        this.currentTags = List.of();
    }

    private Run(RunId runId, Script currentScript, List<Tag> currentTags) {
        this.runId = runId;
        this.currentScript = currentScript;
        this.currentTags = currentTags;
    }
    public Run choose(ChoiceNumber choice) {
        Script scriptAfterChoice = currentScript.choose(choice);
        return new Run(runId, scriptAfterChoice, scriptAfterChoice.tags());
    }
}
