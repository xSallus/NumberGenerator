package regradenegocio;

import java.util.Arrays;
import java.util.Random;

public class NGenerator {
    Random rd = new Random();

    private int set;
    private int seed;

    Integer[] numset;

    public NGenerator(int x, int y){
        this.set = x;
        this.seed = y;
        ngenerate(set, seed);
    }

    public void ngenerate(int x, int y) {
        for(int i=0;i<x;i++) {
            numset[i] = rd.nextInt(y);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(numset);
    }
}