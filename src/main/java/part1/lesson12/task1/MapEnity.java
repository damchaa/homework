package part1.lesson12.task1;


import java.math.BigInteger;


public class MapEnity   {
    private int count;
    private BigInteger number;

    public MapEnity(int count,BigInteger number){
        this.count = count;
        this.number = number;

    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigInteger getNumber() {
        return number;
    }

    public void setNumber(BigInteger number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "MapEnity{" +
                "count=" + count +
                ", number=" + number +
                '}';
    }
}
