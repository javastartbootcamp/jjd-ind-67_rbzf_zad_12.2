public class Statistics {
    public static double avgSalary(Employee[] employees) {
        return totalSalarySum(employees) / employees.length;
    }

    private static double totalSalarySum(Employee[] employees) {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    public static double minSalary(Employee[] employees) {
        double minSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
            }
        }
        return minSalary;
    }

    public static double maxSalary(Employee[] employees) {
        double maxSalary = 0;
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
            }
        }
        return maxSalary;
    }

    public static int numberEmployeesInDep(Employee[] employees, String department) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment().equals(department)) {
                sum++;
            }
        }
        return sum;
    }
}
