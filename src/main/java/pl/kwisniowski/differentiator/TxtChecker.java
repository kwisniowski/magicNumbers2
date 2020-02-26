package pl.kwisniowski.differentiator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TxtChecker implements FileChecker {

    private File file;
    private boolean isTxt;

    public TxtChecker(File file) {
        this.file = file;
        this.isTxt = false;
    }

    public void validate() throws FileNotFoundException, IOException {
        boolean eof = false;
        setTxt(true);
        FileInputStream inputStream = new FileInputStream(file);
        while (!eof) {
            int input = inputStream.read();
            if (input>128) {
                setTxt(false);
            }
            if (input == -1) {
                eof = true;
            }
        }
    }

    public boolean getCheckResult() throws IOException {
        validate();
        return isTxt;
    }

    public void setTxt(boolean txt) {
        isTxt = txt;
    }

    public boolean isTxt() {
        return isTxt;
    }
}
