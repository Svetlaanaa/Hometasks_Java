import org.junit.jupiter.api.Test;

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
    }
}