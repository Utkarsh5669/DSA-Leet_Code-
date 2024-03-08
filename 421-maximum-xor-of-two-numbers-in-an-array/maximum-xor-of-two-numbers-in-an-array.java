// import java.util.*;
// class Solution {
//     public int findMaximumXOR(int[] nums) {
//        int maxXor =0;
//        int k=0;
//        for(int i=31;i>=0;i--){
//            k |= (1<<i);
//            Set<Integer> pre = new HashSet<>();
//            for(int num:nums){
//                pre.add(num & k);
//            }
//            int temp = maxXor |(1<<i);
//            for(int pr: pre){
//                if(pre.contains(temp^pr)){
//                maxXor = temp;
//                break;
//            }
//        }
//     }
//         return maxXor;
//     }
// }
class Node{
    char data;
    Node left;
    Node right;

    Node(char data){
        this.data = data;
        left = null;
        right = null;
    }
}
class Solution {
     static void insert(Node root, int num){
        Node curr = root;
        
        for(int i=31; i>=0; i--){
            int bit = (num>>i) & 1;
            if(bit==0){
                if(curr.left==null){
                    Node x = new Node('0');
                    curr.left = x;
                }
                curr = curr.left;
            }else{
                if(curr.right==null){
                    Node x = new Node('1');
                    curr.right = x;   
                }
                curr = curr.right;
            }
        }
    }

    
    static int helper(Node root, int num){
        int ans = 0;
        Node curr = root;

        for(int i=31; i>=0; i--){
            int bit = (num>>i) & 1;
            if(bit==0){
                if(curr.right!=null){
                    curr = curr.right;
                    ans += (1 << i);
                }else{
                    curr = curr.left;
                }
            }else{
                if(curr.left!=null){
                    curr = curr.left;
                    ans += (1 << i);
                }else{
                    curr = curr.right;
                }
            }
        }
        return ans;
    }


    public int findMaximumXOR(int[] arr) {
        int n = arr.length;
        int ans = 0;


        Node root = new Node('.');
        insert(root,arr[0]);
        for(int i=1; i<n; i++){
            ans = Math.max(ans,helper(root,arr[i]));
            insert(root,arr[i]);
        }
        return ans;
    }
}