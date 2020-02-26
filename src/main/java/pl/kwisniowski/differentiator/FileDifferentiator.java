package pl.kwisniowski.differentiator;

import pl.kwisniowski.checker.FileChecker;
import pl.kwisniowski.checker.GifChecker;
import pl.kwisniowski.checker.JpgChecker;
import pl.kwisniowski.checker.TxtChecker;
import pl.kwisniowski.exception.FileNotSupported;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileDifferentiator {

    private File file;
    private FileType fileType;
    public String[] handledExtentions = {"jpg","gif","txt"};
    private FileChecker txtChecker;
    private FileChecker jpgChecker;
    private FileChecker gifChecker;

    public FileDifferentiator(File file) {
        this.file = file;
        fileType = FileType.NONE;
        if (!validateIsHandled(file)) {
            throw new FileNotSupported();
        }
        this.txtChecker = new TxtChecker(file);
        this.jpgChecker = new JpgChecker(file);
        this.gifChecker = new GifChecker(file);
    }

    private boolean validateIsHandled(File file) {
        List<String> handledExt = Arrays.asList(handledExtentions);
        if (handledExt.contains(getFileExtension(file))) {
            return true;
        }
        else return false;
    }

    private String getFileExtension(File file) {
        int dotIndex = file.getName().lastIndexOf(".");
        return file.getName().substring(dotIndex+1,dotIndex+4);
    }

    private void validateByContent() throws IOException {
        if (txtChecker.getCheckResult()) {
            setFileType(FileType.TXT);
        }
        else if (gifChecker.getCheckResult()) {
            setFileType((FileType.GIF));
        }
        else if (jpgChecker.getCheckResult()) {
            setFileType(FileType.JPG);
        }
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public String showCheckResult() throws IOException {
        validateByContent();
        if (String.valueOf(fileType).toLowerCase().equals(getFileExtension(file))) {
            return "Correct! File extension is: '"+getFileExtension(file)+"' and content of the file is: '"+fileType+"'";
        }
        else {
            return "Not correct! File extension is: '"+getFileExtension(file)+"' while in fact it is: '"+fileType+"'";
        }
    }
}
