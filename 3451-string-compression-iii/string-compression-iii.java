// class Solution {
//     public String compressedString(String word) {
//         StringBuilder s = new StringBuilder();
//         int c=1;
//         int n = word.length();
//         int i=1;
//         while(i<n)
//         {
//             if(c==9|| word.charAt(i)!=word.charAt(i-1)){
//                 s.append(c).append(word.charAt(i-1));
//                 c=1;
//                 i++;
//                 continue;
//             }
//             if(word.charAt(i)==word.charAt(i-1)){
//                 c++;
//             }
//             i++;
//         }
//         return s.append(c).append(word.charAt(n-1)).toString();
//     }
// }
class Solution {
    public String compressedString(String word) {
        StringBuilder sb=new StringBuilder();
        int count=0,j=0;
        for(int i=0;i<word.length();++i){
            j=i;
            char c=word.charAt(i);
            while(j<word.length() && word.charAt(j)==c){
                ++count;
                ++j;
            }
            while(count>9){
                sb.append('9');
                sb.append(c);
                count-=9;

            }
            sb.append((char)(count+'0'));
            sb.append(c);
            count=0;
            i=j-1;

        }
        return sb.toString();
    }
}