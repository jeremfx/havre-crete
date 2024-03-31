package core;

import core.application.service.Core;
import core.application.service.RunDTO;
import core.domain.choice.ChoiceNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ChooseTest {
    Core core = new Core();

    @Test
    void test(){
        RunDTO run = core.createRun();
        RunDTO runAfterChoice = core.choose(run.runId(), run.choices().getFirst().number);
        assertFalse(runAfterChoice.content().isEmpty());
        assertNotEquals(run, runAfterChoice);
    }

}
