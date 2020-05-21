package com.thealiyev;

public class FactoryDesignPattern {
    public interface employee {
        void does();
    }

    public static class projectManager implements employee {
        @Override
        public void does() {
            System.out.println("Leads project.");
        }
    }

    public static class designer implements employee {
        @Override
        public void does() {
            System.out.println("Designs application.");
        }
    }

    public static class frontEndDeveloper implements employee {
        @Override
        public void does() {
            System.out.println("Codes front end of application.");
        }
    }

    public static class backEndDeveloper implements employee {
        @Override
        public void does() {
            System.out.println("Programs back end of application.");
        }
    }

    public static class EmployeeFactory {
        public employee getEmployee(String employeeType) {
            switch (employeeType) {
                case "Project Manager":
                    return new projectManager();
                case "Designer":
                    return new designer();
                case "Front End Developer":
                    return new frontEndDeveloper();
                case "Back End Developer":
                    return new backEndDeveloper();
                default:
                    return null;
            }
        }
    }

    public static class Main {
        public static void main(String[] args) {
            EmployeeFactory employeeFactory = new EmployeeFactory();

            employee employee1 = employeeFactory.getEmployee("Project Manager");
            employee1.does();

            employee employee2 = employeeFactory.getEmployee("Designer");
            employee2.does();

            employee employee3 = employeeFactory.getEmployee("Front End Developer");
            employee3.does();

            employee employee4 = employeeFactory.getEmployee("Back End Developer");
            employee4.does();
        }
    }
}
