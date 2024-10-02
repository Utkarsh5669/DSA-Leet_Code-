class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length,i=0;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(i=0;i<n;i++){
            map.put(arr[i],1);
        }
        i=1;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            map.put(entry.getKey(),i);
            i++;
        }
        for(i=0;i<n;i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}