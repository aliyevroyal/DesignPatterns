package com.thealiyev;

public class FactoryDesignPattern {
    public interface IClass {
        void print();
    }

    public static class firstClass implements IClass {
        @Override
        public void print() {
            System.out.println("This is the first class.");
        }
    }

    public static class secondClass implements IClass {
        @Override
        public void print() {
            System.out.println("This is the second class.");
        }
    }

    public static class thirdClass implements IClass {
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
                    return new firstClass();
                case "secondclass":
                    return new secondClass();
                case "thirdclass":
                    return new thirdClass();
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
