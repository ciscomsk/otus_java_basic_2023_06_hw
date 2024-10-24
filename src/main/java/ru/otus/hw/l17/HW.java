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
//        File[] files = file.listFiles();
        File[] files = file.listFiles();

        return Arrays.stream(files)
                .filter(el -> el.isFile() && el.getName().endsWith(".txt"))
                .map(File::getName)
                .toList();
    }

    public static String askUser(Scanner sc, String message) {
        System.out.println(message);
        return sc.next();
    }

    public static String getFileContent(String filename) {
        StringBuilder sb = new StringBuilder();

//        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {
//            int ch = br.read();
//            while (ch != -1) {
//                sb.append((char) ch);
//                ch = br.read();
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return sb.toString();
    }

    public static void appendFile(String filename, String content) {
//        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filename, true))) {
//            byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
//            bos.write(bytes);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

        try (BufferedWriter bos = new BufferedWriter(new FileWriter(filename, true))) {
            bos.newLine();
            bos.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
