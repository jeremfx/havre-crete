package core.application.service;

import core.application.repository.RunRepository;
import core.domain.Run;
import core.domain.RunId;
import core.domain.choice.ChoiceNumber;
import infrastructure.persistence.RunRepositoryInMemory;

import java.util.UUID;

public class Core {

    RunRepository runRepository = new RunRepositoryInMemory();

    public RunDTO createRun() {
        Run run = new Run(new RunId(UUID.randomUUID()));
        runRepository.save(run);
        return new RunDTO(run);
    }

    public RunDTO choose(RunId runId, ChoiceNumber choice) {
        Run runAfterChoice = runRepository.get(runId).choose(choice);
        runRepository.save(runAfterChoice);
        return new RunDTO(runAfterChoice);
    }

    public RunDTO getRun(RunId runId) {
        return new RunDTO(runRepository.get(runId));
    }
}
