package com.thealiyev;

public class SingletonDesignPattern {
    public static class SingleObjectClass {
        private static SingleObjectClass singleObjectClass = new SingleObjectClass();

        private SingleObjectClass() {

        }

        public static SingleObjectClass getSingleObjectClass() {
            return singleObjectClass;
        }

        public void verifier() {
            System.out.println("Singleton Design Pattern is working!!!");
        }
    }

    public static class Main {
        public static void main(String[] args) {
            SingleObjectClass singleObjectClass = SingleObjectClass.getSingleObjectClass();
            singleObjectClass.verifier();
        }
    }
}
