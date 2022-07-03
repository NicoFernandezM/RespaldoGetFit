package utils;

public class GetFitMath {

    private static int[] generarRutina(int numeroIngresado, int[] repsPorSeries) {
        if (numeroIngresado == 4) {
            return repsPorSeries;
        }

        for (int i = 4; i < numeroIngresado; i++) {
            if (i % 4 == 0) {
                i /= 4;
                i--;
                numeroIngresado -= 4;
            }
            repsPorSeries[i] = numeroIngresado > 4 && numeroIngresado < 9 ? repsPorSeries[i] + 1 : repsPorSeries[i] + 3;
        }

        return repsPorSeries;
    }

    public static int[] generarRutinaDominadas(int numeroIngresado) {
        int[] repsPorSeries = new int[]{2, 1, 2, 1};
        return generarRutina(numeroIngresado, repsPorSeries);
    }

    public static int[] generarRutinaFlexiones(int numeroIngresado) {
        int[] repsPorSeries = new int[]{2, 2, 1, 2};
        return generarRutina(numeroIngresado, repsPorSeries);
    }
}
