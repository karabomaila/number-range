package src.main.numberrangesummarizer;
import java.util.Collection;

/**
 * @author Werner
 *
 * Interface to produce a comma delimited list of numbers,
 * grouping the numbers into a range when they are sequential.
 *
 */
public interface NumberRangeSummarizer {
    // collect the input
    Collection<Integer> collect(String input);
    
    // get the summarized string
    String summarizeCollection(Collection<Integer> input);
}


