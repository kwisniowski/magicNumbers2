package pl.kwisniowski.differentiator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GifChecker implements FileChecker {
    private File file;
    private final String GIF_MARK = "GIF89";
    private boolean isGif;

    public GifChecker(File file) {
        this.file = file;
        isGif = false;
    }

    public void validate() throws FileNotFoundException {
        FileInputStream inputStream = new FileInputStream(file);
        char[] first5Bytes = new char[5];
        for (int i = 0; i <= 4; i++) {
            try {
                first5Bytes[i] = (char) inputStream.read();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        if (String.valueOf(first5Bytes).equals(GIF_MARK)) {
            setGif(true);
        }
    }

    public void setGif(boolean gif) {
        isGif = gif;
    }

    public boolean isGif() {
        return isGif;
    }

    public boolean getCheckResult() throws FileNotFoundException {
        validate();
       return isGif;
    }
}
