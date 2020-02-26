package pl.kwisniowski.exception;

public class FileNotSupported extends IllegalArgumentException {

    public FileNotSupported() {
        super("File not supportdd. Acceptable extensions are: txt, gif, jpg");
    }
}
