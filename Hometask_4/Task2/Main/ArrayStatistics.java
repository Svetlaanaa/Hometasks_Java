import java.util.Arrays;

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
}
