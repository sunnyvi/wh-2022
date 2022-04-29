package com.serviceapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServiceappApplicationTests {

    @Test
    void contextLoads() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 10; i++) {

            try {

                if (i == 3) {
                    Exception e = new Exception();
                    throw e;
                }
                s.append(i+" ");
            } catch (Exception e) {
                continue;
            }
        }
        System.out.println(s);
    }

}
