package app.domain.model;


public class MultipleLinearRegression {


    private double R2;
    private double R2adj;
    private double R;
    private double[][] intervals;
    private String regmod;

    public MultipleLinearRegression(double[][]x, double[]y) {
        boolean temp=false;

        if (x.length != y.length) {
            throw new IllegalArgumentException("array lengths are not equal");
        }

        int n= y.length;
        double xTx[][];
        double xT[][]=new double[x[0].length][x.length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                xT[j][i]=x[i][j];
            }
        }

        xTx= multiplyMatrices(xT, x);

        double[][]xtx_1=inverse(xTx);
        double[][] tempy=new double[y.length][1];
        for (int i = 0; i < y.length; i++) {
            tempy[i][0]=y[i];
        }
        double[][] xTy=multiplyMatrices(xT, tempy);
        double[][]b=multiplyMatrices(xtx_1,xTy);
        int a=0;
        regmod="^y=";
        for (int i = 0; i < b.length; i++) {
            for (int j=0; j<b[i].length;j++){
                if (a==0){
                    regmod+=b[i][j]+" ";
                }else {
                    regmod+="+"+b[i][j]+"x"+a+" ";
                }
                a++;
            }
        }
        System.out.println(regmod);
        double yT[][]=new double[1][y.length];
        for (int i = 0; i < y.length; i++) {
            yT[0][i]=y[i];
        }

        double yty[][]=multiplyMatrices(yT, tempy);

        double sumy=0.0;
        int cont=0;
        for (int i = 0; i < y.length; i++) {
            sumy+=y[i];
            cont++;
        }

        double Sqt=yty[0][0] +(-(sumy*sumy)/cont);
        double bt[][]=new double[b[0].length][b.length];
        for (int i = 0; i < b.length; i++) {
            bt[0][i]=b[i][0];

        }

        double btxty[][]=multiplyMatrices(bt,xTy);
        double SQR=btxty[0][0]-(sumy/cont)*(sumy/cont)*cont;
        this.R2=SQR/Sqt;

        int k=2;

        double partthree=(cont-(k+1));
        double partetwo=cont-1;
        R2adj=1-(partetwo/partthree)*(1-R2);
        R = Math.sqrt(R2);


        double SQE=Sqt-SQR;

        double variancia_2=SQE /(cont-(k+1));


        for (int i = 0; i < x.length; i++) {
            double delta= SQE/(n-(k+1));
            double bj=b[2][0];
            double Cjj=xtx_1[2][2];
            double raizde=delta*Cjj;
            double raiz1 = Math.pow(raizde, 1/2);
            double ychapeu=0;
            for (int j = 0; j < b.length; j++) {
                ychapeu+=b[j][0];
            }
            double t=(ychapeu-y[i])/(raiz1);
                    System.out.println(delta);

        }

    }
    double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {
        double[][] result = new double[firstMatrix.length][secondMatrix[0].length];

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = multiplyMatricesCell(firstMatrix, secondMatrix, row, col);
            }
        }

        return result;
    }
    double multiplyMatricesCell(double[][] firstMatrix, double[][] secondMatrix, int row, int col) {
        double cell = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            if (firstMatrix[row].length<=i){

            }else {
                cell += firstMatrix[row][i] * secondMatrix[i][col];
            }
        }
        return cell;
    }
    private static double determinant(double[][] matrix) {
        if (matrix.length != matrix[0].length)
            throw new IllegalStateException("invalid dimensions");

        if (matrix.length == 2)
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        double det = 0;
        for (int i = 0; i < matrix[0].length; i++)
            det += Math.pow(-1, i) * matrix[0][i]
                    * determinant(minor(matrix, 0, i));
        return det;
    }

    private static double[][] inverse(double[][] matrix) {
        double[][] inverse = new double[matrix.length][matrix.length];

        // minors and cofactors
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                inverse[i][j] = Math.pow(-1, i + j)
                        * determinant(minor(matrix, i, j));

        // adjugate and determinant
        double det = 1.0 / determinant(matrix);
        for (int i = 0; i < inverse.length; i++) {
            for (int j = 0; j <= i; j++) {
                double temp = inverse[i][j];
                inverse[i][j] = inverse[j][i] * det;
                inverse[j][i] = temp * det;
            }
        }

        return inverse;
    }
    private static double[][] minor(double[][] matrix, int row, int column) {
        double[][] minor = new double[matrix.length - 1][matrix.length - 1];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; i != row && j < matrix[i].length; j++)
                if (j != column)
                    minor[i < row ? i : i - 1][j < column ? j : j - 1] = matrix[i][j];
        return minor;
    }

    public double getR2() {
        return R2;
    }

    public void setR2(double r2) {
        R2 = r2;
    }

    public double getR2adjusted() {
        return R2adj;
    }

    public void setR2adjusted(double r2adj) {
        R2adj = r2adj;
    }

    public double getR() {
        return R;
    }

    public void setR(double r) {
        R = r;
    }

    public String getRegressionmodel() {
        return regmod;
    }

    public void setRegressionmodel(String regmod) {
        this.regmod = regmod;
    }
}