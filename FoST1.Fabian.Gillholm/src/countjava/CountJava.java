package countjava;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Fabian Gillholm on 2015-09-11.
 */
public class CountJava {
    // main should be called with a filepath as the only parameter
    public static void main(String[] args) {
        // Check parameter, use it if it exists
        String filepath = "";
        if(args.length != 0) {
            filepath = args[0];
        }
        else {
            System.out.println("CountJava expects a filepath as a parameter!");
            System.exit(1);
        }
        indexFiles(filepath, 1);
    }

    // Recursive function calls itself with a new filepath until it's exhausted all subdirectories.
    // Parameter index is passed, added to whenever a java file is found, and is returned to the calling function
    // this is a way to keep track of the number of java files. It would have been better to use a member variable, but the
    // instructions suggested that the class should be executable and therefore it needs to be static. Fuck it, it works.
    private static int indexFiles(String filepath, int index) {
        try {
            // Grab the root folder and its contents
            File rootFolder = new File(filepath);
            File[] listing = rootFolder.listFiles();
            if(index == 1 && listing == null) {
                System.out.println("Given path contained no files or directories.");
                System.exit(1);
            }

            // Loop through the contents and traverse subdirectories by calling this same function
            for(File file : listing) {
                if(file.isDirectory()) {
                    index = indexFiles(file.getAbsolutePath(), index);
                }
                // if a .java file is found, scan it and report the number of lines
                else if(getFileExtension(file).equals("java")){
                    printFileInfo(index, file);
                    index++;
                }
            }

        }
        catch(Exception e) {
            System.out.println("An unexpected error occurred. Probably your fault.");
            System.exit(1);
        }

        return index;
    }

    private static String getFileExtension(File file) {
        String extension = "";

        int i = file.getName().lastIndexOf('.');
        if (i > 0) {
            extension = file.getName().substring(i + 1);
        }
        return extension;
    }

    private static void printFileInfo(int index, File file) {
        System.out.println(index + " " + file.getName() + "\tlines = " + countLines(file));
    }

    private static int countLines(File file) {
        int lines = 0;

        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                scanner.nextLine();
                lines++;
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("That path sucked!");
            System.exit(1);
        }
        catch(Exception e) {
            System.out.println("An unexpected error occurred. Probably your fault.");
            System.exit(1);
        }
        return lines;
    }
}
