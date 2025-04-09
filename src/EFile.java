import java.io.*;
import java.util.ArrayList;

public class EFile {

    private static File file = new File("src/files/answers.txt");
    private static String fileName = "src/files/answers.txt";

    public static void save(String answer,String operation){
        if (file.exists()){
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                if (!load(fileName).equals("")){
                    writer.newLine();
                }
                writer.write(operation);
                writer.newLine();
                writer.write(answer);
            } catch (IOException e) {
                System.err.println("Помилка збереження: " + e.getMessage());
            }


        }else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write(operation);
                writer.newLine();
                writer.write(answer);
            } catch (IOException e) {
                System.err.println("Помилка збереження: " + e.getMessage());
            }
        }
    }

    public static String load(String fileName) {
        String content = "";
        try (BufferedReader reader = new BufferedReader(new FileReader("src/files/answers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null){
                content = line + "\n";
            }
            System.out.println();
        } catch (IOException e){
            System.err.println("Помилка завантаження файлу: " + e.getMessage());
        }
        return content;
    }

    public static String loadLastAction() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/files/answers.txt"))) {
            ArrayList<String> lines = new ArrayList<>();
            String line;

            // Чтение всех строк в список
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            // Если файл не пустой, возвращаем последние две строки
            if (lines.size() >= 2) {
                String op = lines.get(lines.size() - 2) + "= "; // предположим, что "op" это предпоследняя строка
                String answ = lines.get(lines.size() - 1); // последняя строка - это "answ"
                return op + answ;
            }
        } catch (IOException e) {
            System.err.println("Помилка завантаження: " + e.getMessage());
        }
        return "";
    }

    public static String loadAnsw() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/files/answers.txt"))) {
            for (int i = 1; i <= reader.lines().count(); i++) {

            }
        } catch (IOException e){
            System.err.println("Помилка завантаження: " + e.getMessage());
        }
        return "";
    }



}
