package math.polynomial.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PolynomialInput {

    @JsonProperty("deg")
    private int degree;
    @JsonProperty("min")
    private Number minCoefficient;
    @JsonProperty("max")
    private Number maxCoefficient;
    @JsonProperty("equation")
    private String equation;




    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public Number getMinCoefficient() {
        return minCoefficient;
    }

    public void setMinCoefficient(double minCoefficient) {
        this.minCoefficient = minCoefficient;
    }

    public Number getMaxCoefficient() {
        return maxCoefficient;
    }

    public void setMaxCoefficient(double maxCoefficient) {
        this.maxCoefficient = maxCoefficient;
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }
}
