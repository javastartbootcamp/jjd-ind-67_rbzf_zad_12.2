import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("employees.csv");
        file.createNewFile();

        if (file.exists()) {
            File stats = new File("stats.txt");
            stats.createNewFile();

            int employeesNumber = getFileLineNumber(file);
            Employee[] employees = createEmployeesArray(file, employeesNumber);

            FileWriter fileWriter = new FileWriter(stats);
            fileWriter.write("Średnia wypłata: " + Statistics.avgSalary(employees) + "\n");
            fileWriter.write("Najnizsza wypłata: " + Statistics.minSalary(employees) + "\n");
            fileWriter.write("Najwyzsza wypłata: " + Statistics.maxSalary(employees) + "\n");
            fileWriter.write("Liczba pracownikow w dziale IT: " + Statistics.numberEmployeesInDep(employees, "IT") + "\n");
            fileWriter.write("Liczba pracownikow w dziale Management: " + Statistics.numberEmployeesInDep(employees, "Management") + "\n");
            fileWriter.write("Liczba pracownikow w dziale Support: " + Statistics.numberEmployeesInDep(employees, "Support") + "\n");

            fileWriter.close();
        }

    }

    private static Employee[] createEmployeesArray(File file, int employeesNumber) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        Employee[] employees = new Employee[employeesNumber];
        for (int i = 0; i < employeesNumber; i++) {
            String[] line = scanner.nextLine().split(";");
            employees[i] = new Employee(line[0], line[1], line[2], line[3], Double.parseDouble(line[4]));
        }
        return employees;
    }

    private static int getFileLineNumber(File file) throws FileNotFoundException {
        int lines = 0;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            lines++;
        }
        scanner.close();
        return lines;
    }
}
