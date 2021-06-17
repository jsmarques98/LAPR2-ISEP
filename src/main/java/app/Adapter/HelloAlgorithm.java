package app.Adapter;

import java.util.Random;

public class HelloAlgorithm implements AlgorithmInterface {

    @Override
    public double[][] calculate() {
        int i;

        double[][] matrix = new double[2][100];

        Random rand = new Random();

        for(i = 0; i < 100; i ++){
            matrix[0][i] = i;
            matrix[1][99-i] = i;
        }

        matrix[1] = rand.doubles(100, 0, 100).toArray();

        return matrix;
    }
}
