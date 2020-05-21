package com.thealiyev;

import java.util.Hashtable;

public class PrototypeDesignPattern {
    public static abstract class employee implements Cloneable {
        private int id;
        protected String title;
        protected String fullName;

        public abstract void does();

        public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public Object clone() {
            Object clone = null;

            try {
                clone = super.clone();
            } catch (CloneNotSupportedException cloneNotSupportedException) {
                cloneNotSupportedException.printStackTrace();
            }

            return clone;
        }
    }

    public static class projectManager extends employee {
        public projectManager() {
            title = "Project Manager";
        }

        @Override
        public void does() {
            System.out.println("Leads project");
        }
    }

    public static class designer extends employee {
        public designer() {
            title = "Designer";
        }

        @Override
        public void does() {
            System.out.println("Designs application.");
        }
    }

    public static class frontEndDeveloper extends employee {
        public frontEndDeveloper() {
            title = "Front End Developer";
        }

        @Override
        public void does() {
            System.out.println("Codes front end of application.");
        }
    }

    public static class backEndDeveloper extends employee {
        public backEndDeveloper() {
            title = "Back End Developer";
        }

        @Override
        public void does() {
            System.out.println("Programs back end of application.");
        }
    }

    public static class Cloner {
        private Hashtable<Integer, employee> employeesJobTitleHashtable = new Hashtable<>();
        private Hashtable<Integer, String> employeesNameHashtable = new Hashtable<>();

        public void createClone() {
            frontEndDeveloper frontEndDeveloper = new frontEndDeveloper();
            frontEndDeveloper.setId(1);
            employeesJobTitleHashtable.put(frontEndDeveloper.getId(), frontEndDeveloper);

            designer designer = new designer();
            designer.setId(2);
            employeesJobTitleHashtable.put(designer.getId(), designer);

            projectManager projectManager = new projectManager();
            projectManager.setId(3);
            employeesJobTitleHashtable.put(projectManager.getId(), projectManager);

            backEndDeveloper backEndDeveloper = new backEndDeveloper();
            backEndDeveloper.setId(4);
            employeesJobTitleHashtable.put(backEndDeveloper.getId(), backEndDeveloper);
        }

        public employee getTitle(int shapeId) {
            employee clonedEmployee = employeesJobTitleHashtable.get(shapeId);
            return (employee) clonedEmployee.clone();
        }
    }

    public static class Main {
        public static void main(String[] args) {
            Cloner cloner = new Cloner();
            cloner.createClone();

            employee clonedEmployeeJobTitle1 = cloner.getTitle(1);
            System.out.print("Title: " + clonedEmployeeJobTitle1.getTitle() + ". ");
            clonedEmployeeJobTitle1.does();

            employee clonedEmployeeJobTitle2 = cloner.getTitle(2);
            System.out.print("Title: " + clonedEmployeeJobTitle2.getTitle() + ". ");
            clonedEmployeeJobTitle2.does();

            employee clonedEmployeeJobTitle3 = cloner.getTitle(3);
            System.out.print("Title: " + clonedEmployeeJobTitle3.getTitle() + ". ");
            clonedEmployeeJobTitle3.does();

            employee clonedEmployeeJobTitle4 = cloner.getTitle(4);
            System.out.print("Title: " + clonedEmployeeJobTitle4.getTitle() + ". ");
            clonedEmployeeJobTitle4.does();
        }
    }
}