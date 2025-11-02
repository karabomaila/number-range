package numberrangesummarizer;
import org.junit.jupiter.api.Test;

import numberrangesummarizer.NumberRangeSummarizerImp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.Arrays;



public class NumberRangeSummarizerImpTest{
    NumberRangeSummarizerImp numberRangeSummarizerImp = new NumberRangeSummarizerImp();

    @Test
    public void testCollect() {
        String input = "1, 3 ,6,7,8, 12,13,14";
        Collection<Integer> expected = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14);
        assertEquals(expected, numberRangeSummarizerImp.collect(input));
    }

    @Test 
    public void testCollectWithEmptyInput() {
        String input = "";
        Collection<Integer> expected = Arrays.asList();
        assertEquals(expected, numberRangeSummarizerImp.collect(input));
    }

    @Test
    public void testSummarizeCollection() {
        Collection<Integer> input = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        String expected = "1, 3, 6-8, 12-15, 21-24, 31";
        assertEquals(expected, numberRangeSummarizerImp.summarizeCollection(input));
    }

    @Test
    public void testSummarizeCollectionWithEmptyInput() {
        Collection<Integer> input = Arrays.asList();
        String expected = "";
        assertEquals(expected, numberRangeSummarizerImp.summarizeCollection(input));
    }

    @Test
    public void testSummarizeCollectionWithSingleNumber() {
        Collection<Integer> input = Arrays.asList(5);
        String expected = "5";
        assertEquals(expected, numberRangeSummarizerImp.summarizeCollection(input));
    }

    @Test
    public void testSummarizeCollectionWithAllSequentialNumbers() {
        Collection<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        String expected = "1-5";
        assertEquals(expected, numberRangeSummarizerImp.summarizeCollection(input));
    }

    @Test
    public void testSummarizeCollectionWithNoSequentialNumbers() {
        Collection<Integer> input = Arrays.asList(1, 3, 6);
        String expected = "1, 3, 6";
        assertEquals(expected, numberRangeSummarizerImp.summarizeCollection(input));
    }

    @Test 
    public void testSummarizeCollectionWithDuplicateNumbers() {
        Collection<Integer> input = Arrays.asList(1,2,3,3,5,6,1,2,3,6,6,32);
        String expected = "1-3, 3, 5-6, 1-3, 6, 6, 32";

        assertEquals(expected, numberRangeSummarizerImp.summarizeCollection(input));
    }
    
}