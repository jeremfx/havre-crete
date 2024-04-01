package userinterface.web.html;

import core.domain.script.Tag;

public class TagToEarn implements HtmlFragment{

    private final Tag tagToEarn;

    public TagToEarn(Tag tagToEarn) {
        this.tagToEarn = tagToEarn;
    }

    @Override
    public String render() {
        return """
                <span class="tag-to-earn">%s</span>
               """.formatted(tagToEarn.name);
    }
}
