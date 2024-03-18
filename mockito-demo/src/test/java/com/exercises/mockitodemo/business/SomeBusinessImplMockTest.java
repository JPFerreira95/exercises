package com.exercises.mockitodemo.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessImplMockTest {

    @Mock
    private DataService dataService;

    @InjectMocks
    private SomeBusinessImpl business;

    @Test
    public void findTheGreatestFromAllData_basicScenario() {

        when(dataService.retrieveAllData()).thenReturn(new int[] {25, 5, 15});
        assertEquals(25, business.findTheGreatestFromAllData());
    }

    @Test
    public void findTheGreatestFromAllData_withOneValue() {

        when(dataService.retrieveAllData()).thenReturn(new int[] {5});
        assertEquals(5, business.findTheGreatestFromAllData());
    }

    @Test
    public void findTheGreatestFromAllData_emptyArray() {

        when(dataService.retrieveAllData()).thenReturn(new int[] {});
        assertEquals(Integer.MIN_VALUE, business.findTheGreatestFromAllData());
    }
}
