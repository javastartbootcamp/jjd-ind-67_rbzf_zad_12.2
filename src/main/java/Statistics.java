public class Statistics {
    public static double avgSalary(Employee[] employees) {
        if (employees != null) {
            return totalSalarySum(employees) / employees.length;
        } else {
            return 0;
        }
    }

    private static double totalSalarySum(Employee[] employees) {
        double sum = 0;
        if (employees != null) {
            for (Employee employee : employees) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public static double minSalary(Employee[] employees) {
        if (employees != null) {
            double minSalary = employees[0].getSalary();
            for (Employee employee : employees) {
                if (employee.getSalary() < minSalary) {
                    minSalary = employee.getSalary();
                }
            }
            return minSalary;
        } else {
            return 0;
        }
    }

    public static double maxSalary(Employee[] employees) {
        double maxSalary = 0;
        if (employees != null) {
            for (Employee employee : employees) {
                if (employee.getSalary() > maxSalary) {
                    maxSalary = employee.getSalary();
                }
            }
        }
        return maxSalary;
    }

    public static int numberEmployeesInDep(Employee[] employees, String department)  {
        int sum = 0;
        if (employees != null) {
            for (Employee employee : employees) {
                if (employee.getDepartment().equals(department)) {
                    sum++;
                }
            }
        }
        return sum;
    }
}
