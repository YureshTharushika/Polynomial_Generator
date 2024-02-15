package math.polynomial.model;

import org.springframework.stereotype.Component;

@Component
public class QuadraticEquationInfo {

    private String equation;
    private double coefficientA;
    private double coefficientB;
    private double coefficientC;
    private String natureOfRoots;

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public double getCoefficientA() {
        return coefficientA;
    }

    public void setCoefficientA(double coefficientA) {
        this.coefficientA = coefficientA;
    }

    public double getCoefficientB() {
        return coefficientB;
    }

    public void setCoefficientB(double coefficientB) {
        this.coefficientB = coefficientB;
    }

    public double getCoefficientC() {
        return coefficientC;
    }

    public void setCoefficientC(double coefficientC) {
        this.coefficientC = coefficientC;
    }

    public String getNatureOfRoots() {
        return natureOfRoots;
    }

    public void setNatureOfRoots(String natureOfRoots) {
        this.natureOfRoots = natureOfRoots;
    }
}
