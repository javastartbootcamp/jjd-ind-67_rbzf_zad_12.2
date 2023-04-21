import exceptions.EmptyFileException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        File file = new File("employees.csv");
        int employeesNumber = getFileLineNumber(file);
        Employee[] employees = createEmployeesArray(file, employeesNumber);

        if (file.exists() && file.length() > 0 && employeesNumber > 0) {
            File stats = new File("stats.txt");
            try (FileWriter fileWriter = new FileWriter(stats)) {

                fileWriter.write("Średnia wypłata: " + Statistics.avgSalary(employees) + "\n");
                fileWriter.write("Minimalna wypłata: " + Statistics.minSalary(employees) + "\n");
                fileWriter.write("Maksymalna wypłata: " + Statistics.maxSalary(employees) + "\n");
                fileWriter.write("Liczba pracowników IT: " + Statistics.numberEmployeesInDep(employees, "IT") + "\n");
                fileWriter.write("Liczba pracowników Management: " + Statistics.numberEmployeesInDep(employees, "Management") + "\n");
                fileWriter.write("Liczba pracowników Support: " + Statistics.numberEmployeesInDep(employees, "Support") + "\n");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static Employee[] createEmployeesArray(File file, int employeesNumber) {
        Employee[] employees = new Employee[employeesNumber];
        try (Scanner scanner = new Scanner(file)) {
            for (int i = 0; i < employeesNumber; i++) {
                String[] line = scanner.nextLine().split(";");
                employees[i] = new Employee(line[0], line[1], line[2], line[3], Double.parseDouble(line[4]));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku");
        }
        return employees;
    }

    private static int getFileLineNumber(File file) {
        int lines = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                lines++;
            }
            if (lines == 0) {
                throw new EmptyFileException("Pusty plik z lista pracownikow.");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku");
        } catch (EmptyFileException e) {
            System.err.println(e.getMessage());
        }
        return lines;
    }
}
