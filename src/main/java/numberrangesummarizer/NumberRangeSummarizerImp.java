package numberrangesummarizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NumberRangeSummarizerImp {
    public Collection<Integer> collect(String input){
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (String num: input.split(",")) nums.add(Integer.parseInt(num.trim()));
        return nums;
    }

    public String summarizeCollection(Collection<Integer> input){
        if (input.size() == 0) return "";
        List<String> result = new ArrayList<String>();

        int prev_num = 0;
        int i = 0;
        for (int curr_num: input){
            if (i == 0){
                result.add(Integer.toString(curr_num));
            }
            else{
                String curr_sq = result.get(result.size() - 1);
                
                if (prev_num == curr_num - 1 && i == input.size() - 1){
                    result.set( result.size() - 1, curr_sq + "-" + Integer.toString(curr_num));          
                }
                else if (prev_num != curr_num - 1){
                    String prev_num2 = Integer.toString(prev_num);

                    if (!curr_sq.equals(prev_num2)){
                        result.set( result.size() - 1, curr_sq + "-" + prev_num2);                   
                    }

                    result.add(Integer.toString(curr_num));
                }
            }

            prev_num = curr_num;
            i++;
        }
        
        return result.toString().substring(1, result.toString().length() - 1);
        
    }
}