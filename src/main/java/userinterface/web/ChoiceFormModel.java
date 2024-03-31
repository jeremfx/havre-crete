package userinterface.web;

import core.domain.RunId;
import core.domain.ScriptName;
import core.domain.choice.ChoiceNumber;
import core.domain.script.Tag;

import java.util.List;

public record ChoiceFormModel(RunId runId, ChoiceNumber choiceNumber) {
}
