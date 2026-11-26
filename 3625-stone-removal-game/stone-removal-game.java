class Solution {
    public boolean canAliceWin(int n) {
        boolean isAlice = true;
        int stones = 10;
        while(stones > 0 && n > 0) {
            n -= stones;
            stones--;
            isAlice = !isAlice;
        }
        return n == 0 ? !isAlice : isAlice;
    }
}