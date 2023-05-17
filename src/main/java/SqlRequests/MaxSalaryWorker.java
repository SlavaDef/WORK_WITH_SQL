package SqlRequests;

public class MaxSalaryWorker {

    private String name;
    private long salary;

    private static final String FIND_LONGEST_PROJECT = "src/main/java/SQL/find_longest_project.sql";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name +" "+ salary;
    }
}
