package ru.otus.hw.l17;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HW {
    public static void main(String[] args) {
        List<String> textFiles = getTextFiles();
        System.out.println(textFiles);

        Scanner sc = new Scanner(System.in);

        String selectedFile = askUser(sc, "Enter name of the file you want to work with: ");
        String fileContent = getFileContent(selectedFile);
        System.out.println(fileContent);

        String userContent = askUser(sc, "Enter text you want to save in the selected file: ");
        appendFile(selectedFile, userContent);
    }

    public static List<String> getTextFiles() {
        File file = new File(".");
        File[] files = file.listFiles();

        List<String> textFiles = Arrays.stream(files)
                .filter(el -> el.isFile() && el.getName().endsWith(".txt"))
                .map(File::getName)
                .toList();

        return textFiles;
    }

    public static String askUser(Scanner sc, String message) {
        System.out.println(message);
        return sc.next();
    }

    public static String getFileContent(String filename) {
        StringBuilder sb = new StringBuilder();

        try (InputStreamReader isr = new InputStreamReader(new BufferedInputStream(new FileInputStream(filename)))) {
            int ch = isr.read();
            while (ch != -1) {
                sb.append((char) ch);
                ch = isr.read();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return sb.toString();
    }

    public static void appendFile(String filename, String content) {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filename, true))) {
            byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
            bos.write(bytes);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
