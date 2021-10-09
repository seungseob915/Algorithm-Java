class Solution {
    public long solution(int price, int money, int count) {

        long need=(long)count*(1+count)/2*price;

        return need-money>0 ? need-money:0;
    }
}