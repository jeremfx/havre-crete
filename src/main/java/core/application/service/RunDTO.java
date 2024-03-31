package core.application.service;

import core.domain.Run;
import core.domain.RunId;
import core.domain.choice.Choice;
import core.domain.script.Tag;

import java.util.List;

public record RunDTO(RunId runId, String content, List<Choice> choices, List<Tag> currentTags, String scriptTitle) {

    public RunDTO(Run run) {
        this(run.runId, run.currentScript.content(), run.choices(), run.currentTags, run.currentScript.title());
    }
}
