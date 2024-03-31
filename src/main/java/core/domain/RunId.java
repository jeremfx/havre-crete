package core.domain;

import java.util.UUID;

public record RunId(UUID id) {
    public RunId(String id) {
        this(UUID.fromString(id));
    }
}
