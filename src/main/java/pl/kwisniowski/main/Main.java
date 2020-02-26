package pl.kwisniowski.main;

import pl.kwisniowski.differentiator.FileDifferentiator;
import pl.kwisniowski.exception.EmptyFolderException;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws EmptyFolderException, IOException {

        //Please put test files into:
        File directory = new File ("src\\main\\resources\\file_input");

        if ((directory.exists())&&(directory.listFiles().length!=0)) {
            File[] files = directory.listFiles();
            for(File file: files) {
                System.out.println(file.getName()+": ");
                FileDifferentiator differentiator = new FileDifferentiator(file);
                System.out.println(differentiator.showCheckResult()+"\n");
            }
        }
        else throw new EmptyFolderException();
    }

}
