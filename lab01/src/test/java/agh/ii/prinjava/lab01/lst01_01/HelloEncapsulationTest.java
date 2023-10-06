package agh.ii.prinjava.lab01.lst01_01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class HelloEncapsulationTest {

    @BeforeEach
    void setUp() {
        int C2;
        HelloEncapsulation C1 = new HelloEncapsulation(55);
        C1.setPropVal(33);
        C2 = C1.getPropVal();
        System.out.println(C2);
    }

    @AfterEach
    void tearDown() {
    }
}