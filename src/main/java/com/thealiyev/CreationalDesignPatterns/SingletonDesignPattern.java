package com.thealiyev.CreationalDesignPatterns;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingletonDesignPattern {
    public static Logger logger = LoggerFactory.getLogger(SingletonDesignPattern.class);

    public static class SingleObjectClass {
        private static SingleObjectClass singleObjectClass;

        private SingleObjectClass() {

        }

        static {
            try {
                singleObjectClass = new SingleObjectClass();
            } catch (Exception exception) {
                logger.debug(String.valueOf(exception));
            }
        }

        private static SingleObjectClass getSingleObjectClass() {
            return singleObjectClass;
        }

        public void verifier() {
            logger.debug("Singleton Design Pattern is working!!!");
        }
    }

    public static class Main {
        public static void main(String[] args) {
            SingleObjectClass singleObjectClass = new SingleObjectClass();
            singleObjectClass.verifier();
        }
    }
}