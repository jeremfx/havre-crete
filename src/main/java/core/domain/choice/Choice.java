package core.domain.choice;

import core.domain.script.Tag;

import java.util.Optional;

public class Choice {
    public final ChoiceNumber number;
    public final String content;
    public final Optional<Tag> tagToEarn;
    public final Optional<Tag> tagToLoose;

    public Choice(ChoiceNumber number, String content, Tag tagToEarn) {
        this.number = number;
        this.content = content;
        this.tagToEarn = Optional.of(tagToEarn);
        this.tagToLoose = Optional.empty();
    }

    public Choice(ChoiceNumber number, String content) {
        this.number = number;
        this.content = content;
        tagToEarn = Optional.empty();
        tagToLoose = Optional.empty();
    }

    public Choice(ChoiceNumber number, String content, Tag tagToEarn, Tag tagToLoose) {
        this.number = number;
        this.content = content;
        this.tagToEarn = Optional.of(tagToEarn);
        this.tagToLoose = Optional.of(tagToLoose);
    }
}
