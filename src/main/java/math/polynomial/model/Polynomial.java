package math.polynomial.model;

import org.springframework.stereotype.Component;

import java.util.List;

public class Polynomial {

    private String equation;
    private List<Number> coefficients;

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public List<Number> getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(List<Number> coefficients) {
        this.coefficients = coefficients;
    }



}
