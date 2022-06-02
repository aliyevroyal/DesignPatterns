package com.thealiyev.CreationalDesignPatterns;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class BuilderDesignPattern {
    public static Logger logger = LoggerFactory.getLogger(BuilderDesignPattern.class);

    public static class FirstClassFromFirstGroup extends FirstGroupClass {
        public void print() {
            logger.debug("This is the first class from the first group/family.");
        }
    }

    public static class SecondClassFromFirstGroup extends FirstGroupClass {
        public void print() {
            logger.debug("This is the second class from the first group/family.");
        }
    }

    public static abstract class FirstGroupClass implements IClass {
        @Override
        public void print() {

        }
    }

    public static class FirstClassFromSecondGroup extends SecondGroupClass {
        public void print() {
            logger.debug("This is the first class from the second group/family.");
        }
    }

    public static class SecondClassFromSecondGroup extends SecondGroupClass {
        public void print() {
            logger.debug("This is the second class from the second group/family.");
        }
    }

    public static abstract class SecondGroupClass implements IClass {
        @Override
        public void print() {

        }
    }

    public interface IClass {
        void print();
    }

    public static class RequestedClasses {
        private List<IClass> classes = new ArrayList<IClass>();

        public void addClass(IClass className) {
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
        public static void main(String[] args) {
            ObjectBuilder objectBuilder = new ObjectBuilder();

            RequestedClasses requestedClassesFromFirstGroup = objectBuilder.buildFirstGroupClasses();
            requestedClassesFromFirstGroup.getClasses();

            RequestedClasses requestedClassesFromSecondGroup = objectBuilder.buildSecondGroupClasses();
            requestedClassesFromSecondGroup.getClasses();
        }
    }
}
