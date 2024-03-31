package infrastructure.persistence;

import core.application.repository.RunRepository;
import core.domain.Run;
import core.domain.RunId;

import java.util.*;

public class RunRepositoryInMemory implements RunRepository {
    Map<RunId, Run> runs = new HashMap<>();

    @Override
    public void save(Run run) {
        runs.put(run.runId, run);
    }

    @Override
    public Run get(RunId runId) {
        return runs.get(runId);
    }
}
