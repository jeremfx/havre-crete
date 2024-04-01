package core.domain.choice;

import core.domain.script.ChanceOfSuccess;
import core.domain.script.Tag;

import java.util.Optional;

public class Choice {
    public final ChoiceNumber number;
    public final String content;
    public final Optional<ChanceOfSuccess> chanceOfSuccess;
    public final Optional<Tag> tagToEarn;
    public final Optional<Tag> tagToLose;

    private Choice(Builder builder) {
        this.number = builder.number;
        this.content = builder.content;
        this.chanceOfSuccess = Optional.ofNullable(builder.chanceOfSuccess);
        this.tagToEarn = Optional.ofNullable(builder.tagToEarn);
        this.tagToLose = Optional.ofNullable(builder.tagToLose);
    }

    public static class Builder {
        private final ChoiceNumber number;
        private final String content;
        private ChanceOfSuccess chanceOfSuccess;
        private Tag tagToEarn;
        private Tag tagToLose;

        public Builder(ChoiceNumber number, String content) {
            this.number = number;
            this.content = content;
        }

        public Builder chanceOfSuccess(ChanceOfSuccess chanceOfSuccess) {
            this.chanceOfSuccess = chanceOfSuccess;
            return this;
        }

        public Builder tagToEarn(Tag tagToEarn) {
            this.tagToEarn = tagToEarn;
            return this;
        }

        public Builder tagToLose(Tag tagToLose) {
            this.tagToLose = tagToLose;
            return this;
        }

        public Choice build() {
            return new Choice(this);
        }
    }
}
