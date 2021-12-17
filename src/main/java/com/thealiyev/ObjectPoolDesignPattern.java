package com.thealiyev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObjectPoolDesignPattern {
    public static class Main {
        public static Logger logger = LoggerFactory.getLogger(Main.class);

        public static void main(String args[]) {
            System.out.println("Hello Object Pool design pattern.");
            logger.debug("Works till here...");
        }
    }
}
