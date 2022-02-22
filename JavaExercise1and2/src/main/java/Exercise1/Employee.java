package Exercise1;

public class Employee {

    private String name;
    private int hoursPerDay;
    private int salaryPerDay;

    public String getName() {
        return name;
    }


    public void getInfo(String name, int hoursPerDay, int salaryPerDay){
        this.name = name;
        this.hoursPerDay = hoursPerDay;
        this.salaryPerDay = salaryPerDay;
        if(hoursPerDay > 6){
           this.salaryPerDay = addWork(salaryPerDay);
        }
    }


    public int computeBaseSalary(int days){
        int baseSalary = days * salaryPerDay;
        if(baseSalary < 500){
            baseSalary = addSalary(baseSalary);
        }
        return baseSalary;
    }

    public int addSalary(int salary){
        salary += 10;
        return salary;
    }

    public int addWork(int salary){
        salary +=5;
        return salary;
    }

    public static void main(String[] args){
        Employee employee = new Employee();
        employee.getInfo("John Smith", 5,10);
        int salary = employee.computeBaseSalary(20);
        System.out.println("The final Salary of "+employee.name + " is $"+ salary );

        Employee employee1 = new Employee();
        employee1.getInfo("Sandra Wang", 4, 5);
        int salary1 = employee1.computeBaseSalary(20);
        System.out.println("The final Salary of "+employee1.name + " is $"+ salary1 );

        Employee employee2 = new Employee();
        employee2.getInfo("Gio Rossi", 7, 12);
        int salary2 = employee2.computeBaseSalary(20);
        System.out.println("The final Salary of "+employee2.name + " is $"+ salary2 );

    }
}
