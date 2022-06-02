package com.thealiyev.CreationalDesignPatterns;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractFactoryDesignPattern {
    public static Logger logger = LoggerFactory.getLogger(SingletonDesignPattern.class);

    public interface IFirstGroupClass {
        void print();
    }

    public static class FirstClassFromFirstGroup implements IFirstGroupClass {
        @Override
        public void print() {
            logger.debug("This is the first class from the first group/family.");
        }
    }

    public static class SecondClassFromFirstGroup implements IFirstGroupClass {
        @Override
        public void print() {
            logger.debug("This is the second class from the first group/family.");
        }
    }

    public static class ThirdClassFromFirstGroup implements IFirstGroupClass {
        @Override
        public void print() {
            logger.debug("This is the third class from the first group/family.");
        }
    }

    public static class FirstFactory extends AbstractFactory {
        @Override
        public IFirstGroupClass getObjectFromFirstGroup(String className) {
            className = className.toLowerCase();
            className = className.replaceAll("\\s", "");

            switch (className) {
                case "firstclass":
                    return new FirstClassFromFirstGroup();
                case "secondclass":
                    return new SecondClassFromFirstGroup();
                case "thirdclass":
                    return new ThirdClassFromFirstGroup();
                default:
                    return null;
            }
        }

        @Override
        public ISecondGroupClass getObjectFromSecondGroup(String className) {
            return null;
        }
    }

    public interface ISecondGroupClass {
        void print();
    }

    public static class FirstClassFromSecondGroup implements ISecondGroupClass {
        @Override
        public void print() {
            logger.debug("This is the first class from the second group/family.");
        }
    }

    public static class SecondClassFromSecondGroup implements ISecondGroupClass {
        @Override
        public void print() {
            logger.debug("This is the second class from the second group/family.");
        }
    }

    public static class ThirdClassFromSecondGroup implements ISecondGroupClass {
        @Override
        public void print() {
            logger.debug("This is the third class from the second group/family.");
        }
    }

    public static class SecondFactory extends AbstractFactory {
        @Override
        public IFirstGroupClass getObjectFromFirstGroup(String className) {
            return null;
        }

        @Override
        public ISecondGroupClass getObjectFromSecondGroup(String className) {
            className = className.toLowerCase();
            className = className.replaceAll("\\s", "");

            switch (className) {
                case "firstclass":
                    return new FirstClassFromSecondGroup();
                case "secondclass":
                    return new SecondClassFromSecondGroup();
                case "thirdclass":
                    return new ThirdClassFromSecondGroup();
                default:
                    return null;
            }
        }
    }

    public static abstract class AbstractFactory {
        public abstract IFirstGroupClass getObjectFromFirstGroup(String className);

        public abstract ISecondGroupClass getObjectFromSecondGroup(String className);
    }

    public static class FactoryCreator {
        public static AbstractFactory getFactory(String factoryName) {
            factoryName = factoryName.toLowerCase();
            factoryName = factoryName.replaceAll("\\s", "");

            if (factoryName.equals("firstfactory")) {
                return new FirstFactory();
            } else if (factoryName.equals("secondfactory")) {
                return new SecondFactory();
            } else {
                return null;
            }
        }
    }

    public static class Main {
        public static void main(String[] args) {
            AbstractFactory abstractFirstFactory = FactoryCreator.getFactory("firstfactory");

            IFirstGroupClass objectOfFirstClassFromFirstGroup = abstractFirstFactory.getObjectFromFirstGroup("First Class");
            objectOfFirstClassFromFirstGroup.print();

            IFirstGroupClass objectOfSecondClassFromFirstGroup = abstractFirstFactory.getObjectFromFirstGroup("Second Class");
            objectOfSecondClassFromFirstGroup.print();

            IFirstGroupClass objectOfThirdClassFromFirstGroup = abstractFirstFactory.getObjectFromFirstGroup("Third Class");
            objectOfThirdClassFromFirstGroup.print();

            AbstractFactory abstractSecondFactory = FactoryCreator.getFactory("secondfactory");

            ISecondGroupClass objectOfFirstClassFromSecondGroup = abstractSecondFactory.getObjectFromSecondGroup("First Class");
            objectOfFirstClassFromSecondGroup.print();

            ISecondGroupClass objectOfSecondClassFromSecondGroup = abstractSecondFactory.getObjectFromSecondGroup("Second Class");
            objectOfSecondClassFromSecondGroup.print();

            ISecondGroupClass objectOfThirdClassFromSecondGroup = abstractSecondFactory.getObjectFromSecondGroup("Third Class");
            objectOfThirdClassFromSecondGroup.print();
        }
    }
}
