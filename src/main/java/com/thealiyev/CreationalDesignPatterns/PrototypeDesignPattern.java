package com.thealiyev.CreationalDesignPatterns;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrototypeDesignPattern {
    public static Logger logger = LoggerFactory.getLogger(PrototypeDesignPattern.class);

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
            logger.debug("This method gets the clone of given object.");
            return new Class(objectName);
        }
    }

    public static class Main {
        public static void main(String[] args) {
            Class object = new Class("object");

            Class object1 = (Class) object.getClone();
            logger.debug(object1.getObjectName());

        }
    }
}
