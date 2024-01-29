import java.util.Arrays;
import java.util.Random;

public class ArrayStatistics {
    private int[] array;

    public ArrayStatistics(int[] array){
        this.array = new int[array.length];
        for (int i = 0; i < array.length; i++){
            this.array[i] = array[i];
        }
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = new int[array.length];
        for (int i = 0; 0 < array.length; i++){
            this.array[i] = array[i];
        }
    }

    public int getMode(){
        int mode = 0;
        if(array.length != 0){
            mode = array[0];
            int maxCount = 1;
            int count = 1;
            array = Arrays.stream(array).sorted().toArray();
            for (int i = 1; i < array.length; i++){
                if (array[i] == array[i - 1]){
                    count++;
                }else if(maxCount < count){
                    maxCount = count;
                    count = 1;
                    mode = array[i - 1];
                }
            }
        }
        return mode;
    }
    public double getMedian(){
        if(array.length != 0) {
            array = Arrays.stream(array).sorted().toArray();
            if (array.length % 2 == 0) {
                return (array[array.length / 2 - 1] + array[array.length / 2]) / 2;
            } else {
                return array[array.length / 2];
            }
        }
        return 0;
    }
    public double getAverage(){
        double average = 0;
        if (array.length != 0){
            for(int i = 0; i < array.length; i++){
                average += array[i];
            }
            average /= array.length;
        }
        return average;
    }

    public double getVariance(){
        double average = this.getAverage();
        double variance = 0;
        if (array.length != 0){
            for(int i = 0; i < array.length; i++){
                variance += Math.pow((average - array[i]), 2);
            }
        }
        return variance;
    }

    public double getGeometricMean() {
        double geometricMean = 1;
        if (array.length != 0){
            for(int i = 0; i < array.length; i++){
                geometricMean *= array[i];
            }
            if (geometricMean == 0)
                return 0;
            return Math.pow(geometricMean, 1/array.length);
        }else
            return 0;
    }

    public int[] deleteElement(int[] originalArray, int index){
        int[] newArrray = new int[originalArray.length - 1];
        System.arraycopy(originalArray, 0, newArrray, 0, index);
        System.arraycopy(originalArray, index + 1, newArrray, index, originalArray.length - index - 1);
        return newArrray;
    }

    public int[] getShuffleArray(){
        if (array.length > 0){
            int[] newArray = new int[array.length];
            int[] copyArray;
            copyArray = Arrays.copyOf(array, array.length);
            Random random = new Random();
            int index;
            for (int i = 0; i < newArray.length; i++){
                index = random.nextInt(0,copyArray.length);
                newArray[i] = copyArray[index];
                copyArray = deleteElement(copyArray, index);
            }
            return newArray;
        }
        return new int[0];
    }

    public int[] getSample(int len){
        if(array.length != 0 & len != 0){
            int[] newArray = new int[len];
            int index;
            Random random = new Random();
            for(int i = 0; i < newArray.length; i++){
                index = random.nextInt(0, array.length);
                newArray[i] = array[index];
            }
            return newArray;
        }
        else{
            return new int[0];
        }
    }
}
