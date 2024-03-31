package core.domain;

import java.util.Map;

public record Scripts (Map<ScriptName, String> scripts){
    public String get(ScriptName scriptName) {
        return scripts.get(scriptName);
    }
}

