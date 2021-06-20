package app.domain.model;
import Jama.Matrix;
import Jama.QRDecomposition;

import java.io.Console;

public class MultipleLinearRegression {
    private static Console StdOut;
    private final Matrix beta;  // regression coefficients
    private double sse;         // sum of squared
    private double sst;         // sum of squared


    public MultipleLinearRegression(double[][] x, double[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("matrix dimensions don't agree");
        }


        int n = y.length;

        Matrix matrixX = new Matrix(x);

        // criar matriz do vetor
        Matrix matrixY = new Matrix(y, n);


        QRDecomposition qr = new QRDecomposition(matrixX);
        beta = qr.solve(matrixY);



        double sum = 0.0;
        for (int i = 0; i < n; i++)
            sum += y[i];
        double mean = sum / n;


        for (int i = 0; i < n; i++) {
            double dev = y[i] - mean;
            sst += dev*dev;
        }


        Matrix residuals = matrixX.times(beta).minus(matrixY);
        sse = residuals.norm2() * residuals.norm2();

    }


    public double beta(int j) {
        return beta.get(j, 0);
    }


    public double R2() {
        return 1.0 - sse/sst;
    }


    public static void main(String[] args) {
        double[][] x = { {  1,  10,  20 },
                {  1,  20,  40 },
                {  1,  40,  15 },
                {  1,  80, 100 },
                {  1, 160,  23 },
                {  1, 200,  18 } };
        double[] y = { 243, 483, 508, 1503, 1764, 2129 };
        MultipleLinearRegression regression = new MultipleLinearRegression(x, y);

        System.out.println(regression.beta(0)+ " + " + regression.beta(1)+ " beta1"+ " + " + regression.beta(2)+ " beta2 "+ "(R^2 = "+ regression.R2()+ ")\n");
    }
}