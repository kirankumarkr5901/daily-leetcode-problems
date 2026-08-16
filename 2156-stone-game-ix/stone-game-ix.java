class Solution {
    public boolean stoneGameIX(int[] stones) {
        int type0 = 0;
        int type1 = 0;
        int type2 = 0;
        for(int stone: stones) {
            int rem = stone % 3;
            switch(rem) {
                case 0: {
                    type0++;
                    break;
                }
                case 1: {
                    type1++;
                    break;
                }
                case 2: {
                    type2++;
                    break;
                }
            }
        }
        if(type0%2 == 0)
            return type1 >= 1 && type2 >= 1;
        return Math.abs(type1 - type2) > 2;
    }
}