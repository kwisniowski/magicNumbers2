package pl.kwisniowski.exception;

import java.io.FileNotFoundException;

public class EmptyFolderException extends FileNotFoundException {

    public EmptyFolderException() {
        super("Input folder is empty, please put test files into src\\main\\resources\\file_input");
    }
}
