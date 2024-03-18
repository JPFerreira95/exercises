package com.exercises.mockitodemo.business;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SomeBusinessImplTest {

    @Test
    public void findTheGreatestFromAllData_basicScenario() {

        DataServiceStub1 dataServiceStub = new DataServiceStub1();

        SomeBusinessImpl business = new SomeBusinessImpl(dataServiceStub);
        int result = business.findTheGreatestFromAllData();

        assertEquals(25, result);
    }

    @Test
    public void findTheGreatestFromAllData_withOneValue() {

        DataServiceStub2 dataServiceStub = new DataServiceStub2();

        SomeBusinessImpl business = new SomeBusinessImpl(dataServiceStub);
        int result = business.findTheGreatestFromAllData();

        assertEquals(5, result);
    }
}

/*
 * To create various scenarios we will need to create multiple stubs.
 * The alternative is to create Mocks
 */
class DataServiceStub1 implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {25, 15, 5, -1, 20};
    }
}

class DataServiceStub2 implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {5};
    }
}