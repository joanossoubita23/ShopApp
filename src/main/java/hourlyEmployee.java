public class hourlyEmployee extends  employee{
    private  int hourWork;

    public int getHourWork() {
        return hourWork;
    }

    @Override
    public String toString() {
        return "hourlyEmployee{" +
                "hourWork=" + hourWork +
                "} " + super.toString();
    }

    public void setHourWork(int hourWork) {
        this.hourWork = hourWork;
    }

    public hourlyEmployee(String name, String email, long salary, int id, int hourWork) {
        super(name, email, salary, id);
        this.hourWork = hourWork;
    }

    public hourlyEmployee(String name, String email, long salary, int id) {
        super(name, email, salary, id);
    }
}
