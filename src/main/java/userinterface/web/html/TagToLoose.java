package userinterface.web.html;

import core.domain.script.Tag;

public class TagToLoose implements HtmlFragment{
    private final Tag tagToLoose;

    public TagToLoose(Tag tagToEarn) {
        this.tagToLoose = tagToEarn;
    }

    @Override
    public String render() {
        return """
                <span class="tag-to-loose">%s</span>
               """.formatted(tagToLoose);
    }
}
