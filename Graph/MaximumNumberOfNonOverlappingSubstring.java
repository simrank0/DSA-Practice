package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumNumberOfNonOverlappingSubstring {
    public List<String> maxNumOfSubstrings(String s) {
        List<String> result = new ArrayList<>();
        Map<Character,int[]> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                map.get(s.charAt(i))[1]=i;
            }
            else
                map.put(s.charAt(i),new int[]{i,i});
        }

        int marker = -1;
        for(int i=0;i<s.length();i++)
        {
            int start = map.get(s.charAt(i))[0];
            if(start==i)
            {
                int substringEnd = getEnd(s,map,i);
                if(substringEnd!=-1)
                {
                    if(substringEnd>marker)
                    {
                        result.add("");
                    }
                    marker = substringEnd;
                    result.set(result.size()-1,s.substring(i,marker+1));
                }
            }
        }
        return result;
    }


    public int getEnd(String s, Map<Character,int[]> map, int start)
    {
        int end = map.get(s.charAt(start))[1];
        for(int i=start;i<end;i++)
        {
            if(map.get(s.charAt(i))[0]<start) return -1;
            end = Math.max(end,map.get(s.charAt(i))[1]);
        }
        return end;
    }
}
