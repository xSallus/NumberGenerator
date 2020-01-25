package regradenegocio;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Random;

public class NGenerator {
    Random rd = new Random();

    public Integer[] numset;

    public NGenerator(int nums, int seed){
        ngenerate(nums, seed);
    }

    public void ngenerate(int nums, int seed) {
        numset = new Integer[nums];
        for(int i=0;i<numset.length;i++) {
            numset[i] = rd.nextInt(seed);
        }
    }

    @Override @NonNull
    public String toString() {
        return Arrays.toString(numset);
    }
}