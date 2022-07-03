import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static utils.GetFitMath.*;

class GetFitMathTest {

    @Test
    void generarRutinaDominadasTest() {
        int[] repsPorSeries = new int[]{2, 1, 2, 1};
        assertArrayEquals(repsPorSeries,generarRutinaDominadas(4));
        repsPorSeries = new int[]{5, 1, 2, 1};

        repsPorSeries = new int[]{6, 5, 6, 2};
        assertArrayEquals(repsPorSeries,generarRutinaDominadas(11));
        repsPorSeries = new int[]{6, 5, 6, 5};

        repsPorSeries = new int[]{12, 11, 12, 11};
        assertArrayEquals(repsPorSeries,generarRutinaDominadas(20));
        repsPorSeries = new int[]{15, 11, 12, 11};

        repsPorSeries = new int[]{21, 20, 18, 17};
        assertArrayEquals(repsPorSeries,generarRutinaDominadas(30));

    }

    @Test
    void generarRutinaFlexionesTest() {
        int[] repsPorSeries = new int[]{2, 2, 1, 2};
        assertArrayEquals(repsPorSeries,generarRutinaFlexiones(4));
        repsPorSeries = new int[]{5, 2, 1, 2};

        assertArrayEquals(repsPorSeries,generarRutinaFlexiones(10));
        repsPorSeries = new int[]{6, 6, 5, 3};

        assertArrayEquals(repsPorSeries,generarRutinaFlexiones(18));
        repsPorSeries = new int[]{12, 12, 11, 9};

        assertArrayEquals(repsPorSeries,generarRutinaFlexiones(28));
        repsPorSeries = new int[]{21, 18, 17, 18};
    }
}
