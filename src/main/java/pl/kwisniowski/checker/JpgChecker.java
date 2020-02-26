package pl.kwisniowski.checker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JpgChecker implements FileChecker{
    private File file;
    private boolean isJpg;

    public JpgChecker(File file) {
        this.file = file;
        isJpg=false;
    }

    public void validate() throws FileNotFoundException {
        byte[] bytes = new byte[2];
        try {
            FileInputStream inputStream = new FileInputStream(file);
            bytes[0] = (byte) inputStream.read();
            bytes[1] = (byte) inputStream.read();
            if ((bytes[0]==-1)&&(bytes[1]==-40)) {
                setJpg(true);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean getCheckResult() throws FileNotFoundException {
        validate();
        return isJpg;
    }

    public boolean isJpg() {
        return isJpg;
    }

    public void setJpg(boolean jpg) {
        isJpg = jpg;
    }
}
