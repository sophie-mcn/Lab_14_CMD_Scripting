import javax.swing.*;
import java.io.*;
import java.nio.file.*;

import static java.nio.file.StandardOpenOption.CREATE;

public class FileScan {


    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile = null;
        String rec = "";


        try {

            if (args.length > 0) {
                selectedFile = new File(args[0]);
                if (!selectedFile.exists()) {
                    JOptionPane.showMessageDialog(null, "Please select a file");
                }
            } else {
                File workingDir = new File(System.getProperty("user.dir"));
                chooser.setCurrentDirectory(workingDir);

                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    selectedFile = chooser.getSelectedFile();
                } else {
                    System.out.println("No file selected ... exiting. \nRun the program again and select a file.");
                }
            }
            Path file = selectedFile.toPath();

            InputStream in;
            in = new BufferedInputStream(Files.newInputStream(file, CREATE));
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(in));


            int line = 0;
            int wordcount = 0;
            int charcount = 0;

            while ((rec = reader.readLine()) != null) {

                System.out.println(rec);
                line++;
                charcount += rec.length();
                String words[] = rec.split("\\s+");
                wordcount += words.length;
            }
            reader.close();

            System.out.println("\nYou opened the file: " + selectedFile.getName());
            System.out.println("There are " + line + " lines in the file.");
            System.out.println("There are " + wordcount + " words in the file.");
            System.out.println("There are " + charcount + " characters in the file.");


        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

