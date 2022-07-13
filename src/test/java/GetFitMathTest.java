import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static utils.GetFitMath.*;

class GetFitMathTest {

    @Test
    void generarRutinaDominadasTest() {
        int[] repsPorSeries = new int[]{2, 1, 2, 1};
        assertArrayEquals(repsPorSeries,generarRutinaDominadas(4));

    }

    @Test
    void generarRutinaFlexionesTest() {
        int[] repsPorSeries = new int[]{2, 2, 1, 2};
        assertArrayEquals(repsPorSeries,generarRutinaFlexiones(4));
    }
}
