package userinterface.web.html;

import core.application.service.RunDTO;
import core.domain.RunId;
import core.domain.choice.Choice;
import core.domain.script.Tag;

import java.util.List;
import java.util.stream.Collectors;

public class ChoicesHtml implements HtmlFragment {

    private final RunDTO run;

    public ChoicesHtml(RunDTO run) {
        this.run = run;
    }

    @Override
    public String render() {
        return """
                <ul>
                    %s
                </ul>
                """.formatted(renderChoices());
    }

    private String renderChoices() {
        return run.choices().stream().map(this::renderChoice).collect(Collectors.joining(System.lineSeparator()));
    }

    private String renderChoice(Choice choice){
        return """
                <li>
                    <form action="/" method="POST">
                        <input type="hidden" name="run_id" value="%s" />
                        <input type="hidden" name="choice_number" value="%s" />
                        <button type="submit">%s %s %s %s</button>
                    </form>
                </li>
                """.formatted(run.runId().id(), choice.number, choice.content,
                choice.chanceOfSuccess.map(c -> new ChanceOfSuccessHtml(c).render()).orElse(""),
                choice.tagToEarn.map(t -> new TagToEarn(t).render()).orElse(""),
                choice.tagToLose.map(t -> new TagToLoose(t).render()).orElse(""));
    }
}
