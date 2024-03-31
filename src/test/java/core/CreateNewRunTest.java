package core;

import core.application.service.Core;
import core.application.service.RunDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateNewRunTest {
    Core core = new Core();

    @Test
    void test(){
        RunDTO run = core.createRun();
        assertNotNull(run);
        assertFalse(run.content().isEmpty());
    }
}
