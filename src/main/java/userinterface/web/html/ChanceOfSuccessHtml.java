package userinterface.web.html;

import core.domain.script.ChanceOfSuccess;

public class ChanceOfSuccessHtml implements HtmlFragment {
    private final ChanceOfSuccess chanceOfSuccess;

    public ChanceOfSuccessHtml(ChanceOfSuccess chanceOfSuccess) {
        this.chanceOfSuccess = chanceOfSuccess;
    }

    @Override
    public String render() {
        return """
                <span class="%s">[Réussite %s%%]</span>
                """.formatted(cssClass(), chanceOfSuccess.chanceInPercentage());
    }

    private String cssClass() {
        if (chanceOfSuccess.chanceInPercentage() >= 80) {
            return "chance-of-success-high";
        } else if (chanceOfSuccess.chanceInPercentage() >= 30) {
            return "chance-of-success-medium";
        } else {
            return "chance-of-success-low";
        }
    }
}
