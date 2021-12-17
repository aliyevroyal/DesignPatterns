package com.thealiyev.CreationalDesignPatterns;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FactoryDesignPattern {
    public static Logger logger = LoggerFactory.getLogger(FactoryDesignPattern.class);

    public interface IClass {
        void print();
    }

    public static class FirstClass implements IClass {
        @Override
        public void print() {
            System.out.println("This is the first class.");
        }
    }

    public static class SecondClass implements IClass {
        @Override
        public void print() {
            System.out.println("This is the second class.");
        }
    }

    public static class ThirdClass implements IClass {
        @Override
        public void print() {
            System.out.println("This is the third class.");
        }
    }

    public static class Factory {
        public IClass createObject(String className) {
            className = className.toLowerCase();
            className = className.replaceAll("\\s", "");

            switch (className) {
                case "firstclass":
                    return new FirstClass();
                case "secondclass":
                    return new SecondClass();
                case "thirdclass":
                    return new ThirdClass();
                default:
                    return null;
            }
        }
    }

    public static class Main {
        public static void main(String args[]) {
            Factory factory = new Factory();

            IClass objectOfFirstClass = factory.createObject("First Class");
            objectOfFirstClass.print();

            IClass objectOfSecondClass = factory.createObject("Second Class");
            objectOfSecondClass.print();

            IClass objectOfThirdClass = factory.createObject("Third Class");
            objectOfThirdClass.print();
        }
    }
}
