import javax.swing.*;

import static java.nio.file.StandardOpenOption.CREATE;

void main(String[] args) {
    JFileChooser chooser = new JFileChooser();
    File selectedFile;
    String rec = "";

    if(args.length>0)
    {
      selectedFile = new File(args[0]);
      if (!selectedFile.exists())
      {
        JOptionPane.showMessageDialog(null,"Please select a file");
      }
    }
    else {
        try {
            File workingDir = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDir);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
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

            } else {
                System.out.println("No file selected ... exiting. \nRun the program again and select a file.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

