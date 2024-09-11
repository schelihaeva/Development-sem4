import java.util.ArrayList;
import java.util.List;

class Employee {
    private int employeeId;
    private String phoneNumber;
    private String name;
    private int experience;

    public Employee(int employeeId, String phoneNumber, String name, int experience) {
        this.employeeId = employeeId;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experience = experience;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "табельный номер = " + employeeId +
                ", номер телефона = '" + phoneNumber + '\'' +
                ", имя = '" + name + '\'' +
                ", стаж = " + experience;
    }
}

class EmployeeDirectory {
    private List<Employee> employees;

    public EmployeeDirectory() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> findEmployeesByExperience(int targetExperience) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getExperience() == targetExperience) {
                result.add(employee);
            }
        }
        return result;
    }

    public String findPhoneNumberByName(String targetName) {
        for (Employee employee : employees) {
            if (employee.getName().equals(targetName)) {
                return employee.getPhoneNumber();
            }
        }
        return "Сотрудник не найден";
    }

    public Employee findEmployeeByEmployeeId(int targetEmployeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == targetEmployeeId) {
                return employee;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();

        // Добавление новых сотрудников
        directory.addEmployee(new Employee(1, "8(909)253-96-74", "Маслова Светлана Викторовна", 12));
        directory.addEmployee(new Employee(2, "8(953)878-25-48", "Крутиков Сергей Сергеевич", 5));
        directory.addEmployee(new Employee(3, "8(910)225-52-89", "Смирнов Валентин Петрович", 2));
        directory.addEmployee(new Employee(4, "8(809)452-78-32", "Верунчикова Ирина Анатольевна", 10));
        directory.addEmployee(new Employee(5, "8(852)566-489-22", "Кудрявцев Петр Леонидович", 4));

        // Поиск сотрудников по стажу
        List<Employee> employeesWithExperience3 = directory.findEmployeesByExperience(10);
        System.out.println("Сотрудники со стажем 10 лет: " + employeesWithExperience3);

        // Поиск номера телефона по имени
        String phoneNumberIvanov = directory.findPhoneNumberByName("Верунчикова Ирина Анатольевна");
        System.out.println("Номер телефона для: 'Верунчикова И.А': " + phoneNumberIvanov);

        // Поиск сотрудника по табельному номеру
        Employee employeeById2 = directory.findEmployeeByEmployeeId(4);
        System.out.println("Информация о сотруднике с табельным номером 4: " + employeeById2);
    }
}
