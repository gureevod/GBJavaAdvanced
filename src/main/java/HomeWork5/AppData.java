package HomeWork5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class AppData {
    private String[] header;
    private Integer[][] data;

    public AppData() {
        header = new String[]{"Sonya", "Valera", "Pasha"};
        data = new Integer[][]{{234, 21, 0}, {145, 4, 25}, {90, 1, 67}};
    }

    public void save(String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(rowToString(header));
            for (Integer[] array : data) {
                bufferedWriter.write(rowToString(array));
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private <T> String rowToString(T[] row) {
        String result = "";
        for (int i = 0; i < row.length; i++) {
            if (i < row.length - 1) {
                result = result + row[i] + ";";
            } else {
                result = result + row[i];
            }
        }
        result += "\n";
        return result;
    }

    public void load(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            header = bufferedReader.readLine().split(";");
            String line;
            ArrayList<Integer[]> arrayList = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                arrayList.add(stringToIntArray(line));
            }
            data = arrayList.toArray(new Integer[][]{});
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Integer[] stringToIntArray(String str) {
        String[] stringArray = str.split(";");
        Integer[] intArray = new Integer[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        return intArray;
    }

    public static void main(String[] args) {
        AppData appData = new AppData();
        //appData.save("test.csv");
        appData.load("test.csv");
        System.out.println(Arrays.toString(appData.header));
        System.out.println(Arrays.deepToString(appData.data));
    }
}
