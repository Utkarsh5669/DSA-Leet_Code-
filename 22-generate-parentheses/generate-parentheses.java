// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> res = new ArrayList<String>();
//         recurse(res, 0, 0, "", n);
//         return res;
//     }

//     public void recurse(List<String> res, int left, int right, String s, int n){
//         if (s.length() == n*2){
//             res.add(s);
//             return;
//         }
//         if(left<n){
//             recurse(res, left+1, right, s + "(", n);
//         }
//         if(right<left){
//             recurse(res, left, right+1, s + ")", n);
//         }
//     }
// }
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        backtracking(answer, new StringBuilder(), 0, 0, n);

        return answer;
    }

    private void backtracking (List<String> answer, StringBuilder curString, int leftCount, int rightCount, int n) {
        int l = curString.length();

        if (l == 2 *n) {
            answer.add(curString.toString());
            return;
        }

        if (leftCount< n){
            curString.append("(");
            backtracking(answer, curString, leftCount+1, rightCount, n);
            curString.deleteCharAt(curString.length() -1);
        }
        if (rightCount< leftCount){
            curString.append(")");
            backtracking(answer, curString, leftCount, rightCount+1, n);
            curString.deleteCharAt(curString.length() -1);
        }
    }
}