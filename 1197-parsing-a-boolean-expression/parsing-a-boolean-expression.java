class Solution {
    int idx = 0;
    public boolean parseBoolExpr(String e) {
        char op = e.charAt(idx++);
        if (op == 't') return true; 
        if (op == 'f') return false; 
        idx++; 
        List<Boolean> vals = new ArrayList<>();
        while (e.charAt(idx) != ')') {
            if (e.charAt(idx) != ',') vals.add(parseBoolExpr(e)); 
            else idx++; 
        }
        idx++;
        return op == '!' ? !vals.get(0) : op == '&' ? vals.stream().allMatch(v -> v) : vals.stream().anyMatch(v -> v);
    }
}