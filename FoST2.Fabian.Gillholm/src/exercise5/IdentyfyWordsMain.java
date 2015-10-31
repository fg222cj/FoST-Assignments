package exercise5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Fabian Gillholm on 2015-10-31.
 */
public class IdentyfyWordsMain {

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<String>();
        String filepath = "";
        if(args.length != 0) {
            filepath = args[0];
        }
        else {
            System.out.println("CountChars expects a filepath as a parameter!");
            System.exit(1);
        }

        try {
            File file = new File(filepath);
            Scanner fileScan = new Scanner(file);
            StringBuilder sb = new StringBuilder();

            while(fileScan.hasNext()) {
                String row = fileScan.nextLine();
                // Loop through the row, checking each character
                for(int i = 0; i < row.length(); i++) {
                    char character = row.charAt(i);

                    if(Character.isLetter(character)) {
                        sb.append(character);
                    }
                    else {
                        if(sb.length() > 0) {
                            words.add(sb.toString());
                        }

                        sb = new StringBuilder();
                    }
                }
                if(sb.length() > 0) {
                    words.add(sb.toString());
                }

                sb = new StringBuilder();
                words.add("\r\n");
            }

            PrintWriter pw = new PrintWriter("output.txt", "UTF-8");
            for(String word : words) {
                pw.print(word);
                if(word != "\r\n") {
                    pw.print(" ");
                }
            }
            pw.close();

        }
        catch(FileNotFoundException e) {
            System.out.println("You suck! File was not found.");
            System.exit(1);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
