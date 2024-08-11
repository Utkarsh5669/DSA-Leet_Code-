class Solution {
    public String intToRoman(int num) {
        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] notation={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int i=0;
        StringBuilder str=new StringBuilder("");
        while( num>0){
            if(num>=values[i]){
                num=num-values[i];
                str.append(notation[i]);
            }
            else{
                i++;
            }
        }
        return str.toString();
    }
}