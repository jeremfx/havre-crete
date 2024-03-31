package core.application.repository;

import core.domain.Run;
import core.domain.RunId;

public interface RunRepository {
    void save(Run run);
    Run get(RunId runId);
}
