import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStatisticsTest {
    @Test
    void getMode() {
        ArrayStatistics statistics = new ArrayStatistics(new int[]{});
        assertEquals(0, statistics.getMode());

        statistics = new ArrayStatistics(new int[]{1});
        assertEquals(1, statistics.getMode());

        statistics = new ArrayStatistics(new int[]{1, 3, 1});
        assertEquals(1, statistics.getMode());

        statistics = new ArrayStatistics(new int[]{4, 12, 4, 1, 0, 7, 1, 6, 4, 0});
        assertEquals(4, statistics.getMode());

        Random random = new Random(-7);
        int[] array = new int[100_000];
        for(int i = 0 ; i < array.length; i++){
            array[i] = random.nextInt();
        }
        statistics = new ArrayStatistics(array);
        assertEquals(658339795, statistics.getMode());
    }

    @Test
    void getMedian(){
        ArrayStatistics statistics = new ArrayStatistics(new int[]{});
        assertEquals(0, statistics.getMedian());

        statistics = new ArrayStatistics(new int[]{1});
        assertEquals(1, statistics.getMedian());

        statistics = new ArrayStatistics(new int[]{1, 3, 1});
        assertEquals(1, statistics.getMedian());

        statistics = new ArrayStatistics(new int[]{4, 12, 4, 1, 0, 7, 1, 6, 4, 0});
        assertEquals(4, statistics.getMedian());

        Random random = new Random(-7);
        int[] array = new int[100_000];
        for(int i = 0 ; i < array.length; i++){
            array[i] = random.nextInt();
        }
        statistics = new ArrayStatistics(array);
        assertEquals(2955236, statistics.getMedian());

    }

    @Test
    void getAverage(){
        ArrayStatistics statistics = new ArrayStatistics(new int[]{});
        assertEquals(0, statistics.getAverage());

        statistics = new ArrayStatistics(new int[]{1});
        assertEquals(1, statistics.getAverage());

        statistics = new ArrayStatistics(new int[]{2, 3, 1});
        assertEquals(2, statistics.getAverage());

        statistics = new ArrayStatistics(new int[]{4, 13, 4, 1, 0, 7, 1, 6, 4, 0});
        assertEquals(4, statistics.getAverage());

        Random random = new Random(-7);
        int[] array = new int[100_000];
        for(int i = 0 ; i < array.length; i++){
            array[i] = random.nextInt();
        }
        statistics = new ArrayStatistics(array);
        assertEquals(4314472.14414, statistics.getAverage());
    }

    @Test
    void getVariance(){
        ArrayStatistics statistics = new ArrayStatistics(new int[]{});
        assertEquals(0, statistics.getVariance());

        statistics = new ArrayStatistics(new int[]{1});
        assertEquals(0, statistics.getVariance());

        statistics = new ArrayStatistics(new int[]{2, 3, 1});
        assertEquals(2, statistics.getVariance());

        statistics = new ArrayStatistics(new int[]{4, 13, 4, 1, 0, 7, 1, 6, 4, 0});
        assertEquals(144, statistics.getVariance());

        Random random = new Random(-7);
        int[] array = new int[100_000];
        for(int i = 0 ; i < array.length; i++){
            array[i] = random.nextInt();
        }
        statistics = new ArrayStatistics(array);
        assertEquals(1.5394567919626832E23, statistics.getVariance());
    }

    @Test
    void getGeometricMean(){
        ArrayStatistics statistics = new ArrayStatistics(new int[]{});
        assertEquals(0, statistics.getGeometricMean());

        statistics = new ArrayStatistics(new int[]{1});
        assertEquals(1, statistics.getGeometricMean());

        statistics = new ArrayStatistics(new int[]{2, 3, 1});
        assertEquals(Math.pow(6, 1/3), statistics.getGeometricMean());

        statistics = new ArrayStatistics(new int[]{4, 13, 4, 1, 0, 7, 1, 6, 4, 0});
        assertEquals(0, statistics.getGeometricMean());

        Random random = new Random(-7);
        int[] array = new int[100_000];
        for(int i = 0 ; i < array.length; i++){
            array[i] = random.nextInt();
        }
        statistics = new ArrayStatistics(array);
        assertEquals(1, statistics.getGeometricMean());
    }

    @Test
    void getShuffleArray() {
        ArrayStatistics statistics = new ArrayStatistics(new int[]{});
        int[] array = Arrays.stream(statistics.getArray()).sorted().toArray();
        int[] newArray = Arrays.stream(statistics.getShuffleArray()).sorted().toArray();
        for (int i = 0; i < array.length; i++) {
            assertEquals(array[i], newArray[i]);
        }

        statistics = new ArrayStatistics(new int[]{1});
        int[] array2 = Arrays.stream(statistics.getArray()).sorted().toArray();
        int[] newArray2 = Arrays.stream(statistics.getShuffleArray()).sorted().toArray();
        for (int i = 0; i < array2.length; i++) {
            assertEquals(array2[i], newArray2[i]);
        }

        statistics = new ArrayStatistics(new int[]{2, 3, 1});
        int[] array3 = Arrays.stream(statistics.getArray()).sorted().toArray();
        int[] newArray3 = Arrays.stream(statistics.getShuffleArray()).sorted().toArray();
        for (int i = 0; i < array3.length; i++) {
            assertEquals(array3[i], newArray3[i]);
        }

        statistics = new ArrayStatistics(new int[]{4, 13, 4, 1, 0, 7, 1, 6, 4, 0});
        int[] array4 = Arrays.stream(statistics.getArray()).sorted().toArray();
        int[] newArray4 = Arrays.stream(statistics.getShuffleArray()).sorted().toArray();
        for (int i = 0; i < array4.length; i++) {
            assertEquals(array4[i], newArray4[i]);
        }
    }
    boolean isTrue(int[] array, int element){
        for (int i = 0; i < array.length; i++){
            if(element == array[i]){
                return true;
            }
        }
        return false;
    }
    @Test
    void getSample() {
        ArrayStatistics statistics = new ArrayStatistics(new int[]{});
        int[] array = statistics.getArray();
        int[] newArray = statistics.getSample(3);
        for (int i = 0; i < newArray.length; i++) {
            assertTrue(isTrue(array, newArray[i]));
        }

        statistics = new ArrayStatistics(new int[]{1});
        int[] array2 = statistics.getArray();
        int[] newArray2 = statistics.getSample(3);
        for (int i = 0; i < newArray2.length; i++) {
            assertTrue(isTrue(array2, newArray2[i]));
        }

        statistics = new ArrayStatistics(new int[]{2, 3, 1});
        int[] array3 = statistics.getArray();
        int[] newArray3 = statistics.getSample(3);
        for (int i = 0; i < newArray3.length; i++) {
            assertTrue(isTrue(array3, newArray3[i]));
        }

        statistics = new ArrayStatistics(new int[]{4, 13, 4, 1, 0, 7, 1, 6, 4, 0});
        int[] array4 = statistics.getArray();
        int[] newArray4 = statistics.getSample(3);
        for (int i = 0; i < newArray.length; i++) {
            assertTrue(isTrue(array4, newArray4[i]));
        }
    }
}