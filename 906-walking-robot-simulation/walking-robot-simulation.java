class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int n = commands.length;
        int x=0,y=0,i=0,d=0,max=0;
        HashSet<List<Integer>> set = new HashSet<>();
        for(int k=0;k<obstacles.length;k++){
            List<Integer> list = new ArrayList<>();
            list.add(obstacles[k][0]);
            list.add(obstacles[k][1]);
            set.add(list);
        }
        for(;i<n;i++){
            if(commands[i]==-2){
                d--;
                if(d==-1){
                    d=3;
                }
            }
            else if (commands[i]==-1){
                d++;
                if(d==4){
                    d=0;
                }
            }
            else{
                int sum = commands[i];
                if(d==0){
                    while(sum!=0){
                        y++;
                        List<Integer> list = new ArrayList<>();
                        list.add(x);
                        list.add(y);
                        if(set.contains(list)){
                            y--;
                            break;
                        }
                        sum--;
                    }
                }
                else if(d==1){
                    while(sum!=0){
                        x++;
                        List<Integer> list = new ArrayList<>();
                        list.add(x);
                        list.add(y);
                        if(set.contains(list)){
                            x--;
                            break;
                        }
                        sum--;
                    }
                }
                else if(d==2){
                    while(sum!=0){
                        y--;
                        List<Integer> list = new ArrayList<>();
                        list.add(x);
                        list.add(y);
                        if(set.contains(list)){
                            y++;
                            break;
                        }
                        sum--;
                    }
                }
                else{
                    while(sum!=0){
                        x--;
                        List<Integer> list = new ArrayList<>();
                        list.add(x);
                        list.add(y);
                        if(set.contains(list)){
                            x++;
                            break;
                        }
                        sum--;
                    }
                }
            }
            if(max<((x*x)+(y*y))){
                max = (x*x)+(y*y);
            }
        }
        return max;
    }
}