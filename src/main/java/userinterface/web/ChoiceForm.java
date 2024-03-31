package userinterface.web;

import core.domain.RunId;
import core.domain.ScriptName;
import core.domain.choice.ChoiceNumber;
import core.domain.script.Tag;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class ChoiceForm {
    public static ChoiceFormModel parseResponse(Map<String, List<String>> form) {
        return new ChoiceFormModel(new RunId(form.get("run_id").get(0)),
                ChoiceNumber.valueOf(form.get("choice_number").get(0))) ;
    }
}
