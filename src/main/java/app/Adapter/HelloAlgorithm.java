package app.Adapter;

public class HelloAlgorithm implements AlgorithmInterface {

    @Override
    public double[][] calculate() {
        int i;

        double[][] matrix = new double[2][100];

        for(i = 0; i < 100; i ++){
            matrix[0][i] = i;
            matrix[1][99-i] = i;
        }

        return matrix;
    }
}
