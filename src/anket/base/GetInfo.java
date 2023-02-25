package anket.base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetInfo {

    String[] getInfo(String name) {
        String buffer;
        List<String> list = new ArrayList<>();
        int count = 0;
        String fileName = name.replace(" ", "");

        try (BufferedReader infoRdr = new BufferedReader
                (new FileReader(("C:\\Users\\Илья\\IdeaProjects\\java-basic\\src\\anket\\base\\data\\" + fileName + ".txt")))) {

            do {
                buffer = infoRdr.readLine();
                if (buffer != null) {
                    list.add(buffer);
                    count++;
                }
            } while ((buffer != null));
            String[] info = list.toArray(new String[count]);
            return info;

        } catch (IOException exc) {
            System.out.println("Error when trying to access the help file");
            return null;
        }
    }

    String[] showName() {

        String buffer;
        List<String> list = new ArrayList<>();
        int count = 0;

        try (BufferedReader nameRdr = new BufferedReader(
                new FileReader("C:\\Users\\Илья\\IdeaProjects\\java-basic\\src\\anket\\base\\data\\data.txt"))) {
            do {
                buffer = nameRdr.readLine();
                if (buffer != null) {
                    list.add(buffer);
                    count++;
                }
            } while ((buffer != null));
            String[] data = list.toArray(new String[count]);
            return data;

        } catch (IOException exc) {
            System.out.println("Error when trying to access the help file");
            return null;
        }
    }

    public void search(){

    }
}
