package com.thealiyev;

public class PrototypeDesignPattern {
    public interface IPrototypeClass {
        IPrototypeClass getClone();
    }

    public static class Class implements IPrototypeClass {
        String objectName;

        public Class(String objectName) {
            this.objectName = objectName;
        }

        public String getObjectName() {
            return objectName;
        }

        @Override
        public IPrototypeClass getClone() {
            System.out.println("This method gets the clone of given object.");
            return new Class(objectName);
        }
    }

    public static class Main {
        public static void main(String args[]) {
            Class object1 = new Class("object1");

            Class object2 = (Class) object1.getClone();
            System.out.println(object2.getObjectName());
        }
    }
}
