package com.thealiyev;

import java.util.ArrayList;
import java.util.List;

public class BuilderDesignPattern {
    public static class FirstClassFromFirstGroup extends FirstGroupClass {
        public void print() {
            System.out.println("This is the first class from the first group/family.");
        }
    }

    public static class SecondClassFromFirstGroup extends FirstGroupClass {
        public void print() {
            System.out.println("This is the second class from the first group/family.");
        }
    }

    public static abstract class FirstGroupClass implements Class {
        @Override
        public void print() {

        }
    }

    public static class FirstClassFromSecondGroup extends SecondGroupClass {
        public void print() {
            System.out.println("This is the first class from the second group/family.");
        }
    }

    public static class SecondClassFromSecondGroup extends SecondGroupClass {
        public void print() {
            System.out.println("This is the second class from the second group/family.");
        }
    }

    public static abstract class SecondGroupClass implements Class {
        @Override
        public void print() {

        }
    }

    public interface Class {
        void print();
    }

    public static class RequestedClasses {
        private List<Class> classes = new ArrayList<Class>();

        public void addClass(Class className) {
            classes.add(className);
        }

        public void getClasses() {
            for (int counter = 0; counter < classes.size(); counter = counter + 1) {
                classes.get(counter).print();
            }
        }
    }

    public static class ObjectBuilder {
        public RequestedClasses buildFirstGroupClasses() {
            RequestedClasses requestedClasses = new RequestedClasses();

            requestedClasses.addClass(new FirstClassFromFirstGroup());
            requestedClasses.addClass(new SecondClassFromFirstGroup());

            return requestedClasses;
        }

        public RequestedClasses buildSecondGroupClasses() {
            RequestedClasses requestedClasses = new RequestedClasses();

            requestedClasses.addClass(new FirstClassFromSecondGroup());
            requestedClasses.addClass(new SecondClassFromSecondGroup());

            return requestedClasses;
        }
    }

    public static class Main {
        public static void main(String args[]) {
            ObjectBuilder objectBuilder = new ObjectBuilder();

            RequestedClasses requestedClassesFromFirstGroup = objectBuilder.buildFirstGroupClasses();
            requestedClassesFromFirstGroup.getClasses();

            RequestedClasses requestedClassesFromSecondGroup = objectBuilder.buildSecondGroupClasses();
            requestedClassesFromSecondGroup.getClasses();
        }
    }
}