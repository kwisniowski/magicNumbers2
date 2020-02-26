package pl.kwisniowski.checker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileChecker {
    void validate() throws IOException;
    boolean getCheckResult() throws IOException;
}
