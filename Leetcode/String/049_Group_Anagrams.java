public class Solution {
    // new version solution
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new LinkedList<List<String>>();
        if(strs == null || strs.length == 0)
            return ret;
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(int i = 0; i < strs.length; i++){
            String str = strs[i];
            String sorted = sort(str);
            if(!map.containsKey(sorted)){
                List<String> list = new LinkedList<String>();
                map.put(sorted, list);
            }
            map.get(sorted).add(str);
        }
        for(List<String> list : map.values()){
            Collections.sort(list);
            ret.add(list);
        }
        return ret;
    }
    
    private String sort(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    // O(n) space, O(n) time
    public List<String> anagrams(String[] strs) {
        List<String> ret = new LinkedList<String>();
        if(strs == null || strs.length == 0)
            return ret;

        HashMap<String, List<String>> map = new HashMap<String, List<String>>(); 
        for(int i = 0; i < strs.length; i++){
            String str = strs[i];
            String sorted = sortString(str);
            
            if(map.containsKey(sorted)){
                List<String> list = map.get(sorted);
                list.add(str);
            }else{
                List<String> list = new LinkedList<String>();
                list.add(str);
                map.put(sorted, list);
            }
        }

        // 互为anagrams意味着最少俩str, 所以sort后的结果若只出现了一次, 就不加到ret里 
        for(List<String> list : map.values()){
            if(list.size() > 1)
                ret.addAll(list);
        }
        return ret;
    }

    //return不能是arr.toString(), 可以是Arrays.toString(arr); array不能用toString();
    private String sortString(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return Arrays.toString(arr);
    }
}