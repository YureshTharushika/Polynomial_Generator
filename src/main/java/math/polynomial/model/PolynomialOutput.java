package math.polynomial.model;

import java.util.List;

public class PolynomialOutput {

    private String equation;
    private List<Double> coefficients;
    private List<Point> dataPoints;

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public List<Double> getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(List<Double> coefficients) {
        this.coefficients = coefficients;
    }

    public List<Point> getDataPoints() {
        return dataPoints;
    }

    public void setDataPoints(List<Point> dataPoints) {
        this.dataPoints = dataPoints;
    }
}
