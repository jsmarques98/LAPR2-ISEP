package app.controller.utils;

public class LinearRegression {
    /**
     *  The code LinearRegression class performs a simple linear regression
     *  on an set of n data points (y_i, x_i).
     *  That is, it fits a straight line y = alpha + beta * x,
     *  (where y is the response variable, x is the predictor variable,
     *  alpha is the y-intercept, and beta is the slope)
     *  that minimizes the sum of squared residuals of the linear regression model.
     *  It also computes associated statistics, including the coefficient of
     *  determination R^2 and the standard deviation of the
     *  estimates for the slope and y-intercept.
     *
     */
        private final double intercept, slope;
        private final double r2;
        private final double svar0, svar1;
        private final double xbar, ybar;
        private final double xxbar, yybar;

        /**
         * Performs a linear regression on the data points (y[i], x[i]).
         *
         * @param  x the values of the predictor variable
         * @param  y the corresponding values of the response variable
         * @throws IllegalArgumentException if the lengths of the two arrays are not equal
         */
        public LinearRegression(double[] x, double[] y) {
            if (x.length != y.length) {
                throw new IllegalArgumentException("array lengths are not equal");
            }
            int n = x.length;

            // first pass
            double sumx = 0.0, sumy = 0.0, sumx2 = 0.0;
            for (int i = 0; i < n; i++) {
                sumx  += x[i];
                sumx2 += x[i]*x[i];
                sumy  += y[i];
            }
            xbar = sumx / n;
            ybar = sumy / n;

            // second pass: compute summary statistics
            double xxbar1 = 0.0, yybar1 = 0.0;
            double xybar = 0.0;
            for (int i = 0; i < n; i++) {
                xxbar1 += (x[i] - xbar) * (x[i] - xbar);
                yybar1 += (y[i] - ybar) * (y[i] - ybar);
                xybar += (x[i] - xbar) * (y[i] - ybar);
            }
            xxbar = xxbar1;
            yybar = yybar1;
            slope  = xybar / xxbar;
            intercept = ybar - slope * xbar;

            // more statistical analysis
            double rss = 0.0;      // residual sum of squares
            double ssr = 0.0;      // regression sum of squares
            for (int i = 0; i < n; i++) {
                double fit = slope*x[i] + intercept;
                rss += (fit - y[i]) * (fit - y[i]);
                ssr += (fit - ybar) * (fit - ybar);
            }

            int degreesOfFreedom = n-2;
            r2    = ssr / yybar;
            double svar  = rss / degreesOfFreedom;
            svar1 = svar / xxbar;
            svar0 = svar/n + xbar*xbar*svar1;
        }

        /**
         * Returns the y-intercept alpha of the best of the best-fit line y = alpha + beta * x.
         *
         * @return the y-intercept alpha of the best-fit line y = alpha + beta * x
         */
        public double intercept() {
            return intercept;
        }

        /**
         * Returns the slope beta of the best of the best-fit line y = alpha + beta * x.
         *
         * @return the slope beta of the best-fit line y = alpha + beta * x
         */
        public double slope() {
            return slope;
        }

        /**
         * Returns the coefficient of determination R^2.
         *
         * @return the coefficient of determination R^2,
         *         which is a real number between 0 and 1
         */
        public double R2() {
            return r2;
        }

        /**
         * Returns the standard error of the estimate for the intercept.
         *
         * @return the standard error of the estimate for the intercept
         */
        public double interceptStdErr() {
            return Math.sqrt(svar0);
        }

        /**
         * Returns the standard error of the estimate for the slope.
         *
         * @return the standard error of the estimate for the slope
         */
        public double slopeStdErr() {
            return Math.sqrt(svar1);
        }

        /**
         * Returns the expected response y given the value of the predictor
         * variable x.
         *
         * @param  x the value of the predictor variable
         * @return the expected response y given the value of the predictor
         *         variable x
         */
        public double predict(double x) {
            return slope*x + intercept;
        }

        public double averageX(){return xbar;}

        public double averageY(){return ybar;}

        public double sumX(){return xxbar;}

        public double sumY(){return yybar;}

        /**
         * Returns a string representation of the simple linear regression model.
         *
         * @return a string representation of the simple linear regression model,
         *         including the best-fit line and the coefficient of determination
         *         R^2
         */
        public String toString() {
            StringBuilder s = new StringBuilder();
            s.append(String.format("%.2f n + %.2f", slope(), intercept()));
            s.append("  (R^2 = " + String.format("%.3f", R2()) + ")");
            return s.toString();
        }

    }

