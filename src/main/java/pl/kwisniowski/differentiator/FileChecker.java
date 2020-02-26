package pl.kwisniowski.differentiator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileChecker {
    void validate() throws IOException;
    boolean getCheckResult() throws IOException;
}
