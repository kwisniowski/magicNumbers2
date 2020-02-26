package pl.kwisniowski.main;

import pl.kwisniowski.exception.EmptyFolderException;

import java.io.File;

public class Main {

    public static void main(String[] args) throws EmptyFolderException {
        File directory = new File ("src\\main\\resources\\file_input");
        if ((directory.exists())&&(directory.listFiles().length!=0)) {
            File[] files = directory.listFiles();
            for(File file: files) {
                System.out.println(file.getName());
            }
        }
        else throw new EmptyFolderException();
    }
}
