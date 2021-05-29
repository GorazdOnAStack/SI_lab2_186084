import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    private List<Time> createList(int num1, int num2, int num3) {
        return new ArrayList<Time>(Arrays.asList(new Time(num1,num2,num3)));
    }


    @Test
    void everyBranchTest(){
        List<Integer> result = new ArrayList<Integer>();

        RuntimeException ex;

        result= SILab2.function(createList(23,23,23));
        assertEquals(23*3600+23*60+23,result.get(0));

        result= SILab2.function(createList(24,0,0));
        assertEquals(24*3600+0*60+0,result.get(0));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(-1,0,0)));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(25,0,0)));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));


        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(0,-1,0)));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(0,61,0)));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(0,0,-1)));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(0,0,61)));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(24,61,100)));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

    }

    @Test
    void multipleConditionTest(){

        RuntimeException ex;

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(-1,0,0)));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(25,0,0)));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(0,-1,0)));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(0,61,0)));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(0,0,-1)));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(0,0,61)));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(24,61,100)));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));
    }

}