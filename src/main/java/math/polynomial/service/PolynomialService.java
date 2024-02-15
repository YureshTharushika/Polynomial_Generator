package math.polynomial.service;

import math.polynomial.model.Polynomial;
import math.polynomial.model.PolynomialInput;
import math.polynomial.model.QuadraticEquationInfo;
import math.polynomial.model.QuadraticInput;
import math.polynomial.util.PolynomialGenerator;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PolynomialService {

    private final QuadraticEquationInfo quadraticEquationInfo;

    public PolynomialService(QuadraticEquationInfo quadraticEquationInfo) {
        this.quadraticEquationInfo = quadraticEquationInfo;
    }

    public Polynomial generatePolynomialWithDoubleCoefficients(PolynomialInput input) {
        int degree = input.getDegree();
        double minCoefficient = input.getMinCoefficient().doubleValue();
        double maxCoefficient = input.getMaxCoefficient().doubleValue();

        // Use the PolynomialGenerator to generate the polynomial
        return PolynomialGenerator.generatePolynomialWithDoubleCoefficients(degree, minCoefficient, maxCoefficient);
    }

    public Polynomial generatePolynomialWithIntCoefficients(PolynomialInput input) {
        int degree = input.getDegree();
        int minCoefficient = input.getMinCoefficient().intValue();
        int maxCoefficient = input.getMaxCoefficient().intValue();

        // Use the PolynomialGenerator to generate the polynomial
        return PolynomialGenerator.generatePolynomialWithIntCoefficients(degree, minCoefficient, maxCoefficient);
    }

    public QuadraticEquationInfo generateQuadraticEquation(double minCoefficient, double maxCoefficient) {
        double a = generateRandomCoefficient(minCoefficient, maxCoefficient);
        double b = generateRandomCoefficient(minCoefficient, maxCoefficient);
        double c = generateRandomCoefficient(minCoefficient, maxCoefficient);

        // Construct the quadratic equation
        String equation = String.format("%.2fx^2 + %.2fx + %.2f", a, b, c);

        // Determine the nature of roots
        String natureOfRoots = determineNatureOfRoots(a, b, c);


        quadraticEquationInfo.setEquation(equation);
        quadraticEquationInfo.setCoefficientA(a);
        quadraticEquationInfo.setCoefficientB(b);
        quadraticEquationInfo.setCoefficientC(c);
        quadraticEquationInfo.setNatureOfRoots(natureOfRoots);

        return quadraticEquationInfo;
    }

    public QuadraticEquationInfo generateQuadraticEquation(int minCoefficient, int maxCoefficient) {
        double a = generateRandomCoefficient(minCoefficient, maxCoefficient);
        double b = generateRandomCoefficient(minCoefficient, maxCoefficient);
        double c = generateRandomCoefficient(minCoefficient, maxCoefficient);

        // Construct the quadratic equation
        String equation = String.format("%.0fx^2 + %.0fx + %.0f", a, b, c);

        // Determine the nature of roots
        String natureOfRoots = determineNatureOfRoots(a, b, c);


        quadraticEquationInfo.setEquation(equation);
        quadraticEquationInfo.setCoefficientA(a);
        quadraticEquationInfo.setCoefficientB(b);
        quadraticEquationInfo.setCoefficientC(c);
        quadraticEquationInfo.setNatureOfRoots(natureOfRoots);

        return quadraticEquationInfo;
    }


    public QuadraticEquationInfo generateQuadraticEquationWithSeparateRangesDouble(QuadraticInput quadraticInput) {
        double minA = quadraticInput.getMinA().doubleValue();
        double maxA = quadraticInput.getMaxA().doubleValue();
        double minB = quadraticInput.getMinB().doubleValue();
        double maxB = quadraticInput.getMaxB().doubleValue();
        double minC = quadraticInput.getMinC().doubleValue();
        double maxC = quadraticInput.getMaxC().doubleValue();

        double a = generateRandomCoefficient(minA, maxA);
        double b = generateRandomCoefficient(minB, maxB);
        double c = generateRandomCoefficient(minC, maxC);

        // Construct the quadratic equation
        String equation = String.format("%.2fx^2 + %.2fx + %.2f", a, b, c);

        // Determine the nature of roots
        String natureOfRoots = determineNatureOfRoots(a, b, c);


        quadraticEquationInfo.setEquation(equation);
        quadraticEquationInfo.setCoefficientA(a);
        quadraticEquationInfo.setCoefficientB(b);
        quadraticEquationInfo.setCoefficientC(c);
        quadraticEquationInfo.setNatureOfRoots(natureOfRoots);

        return quadraticEquationInfo;
    }

    public QuadraticEquationInfo generateQuadraticEquationWithSeparateRangesInt(QuadraticInput quadraticInput) {
        int minA = quadraticInput.getMinA().intValue();
        int maxA = quadraticInput.getMaxA().intValue();
        int minB = quadraticInput.getMinB().intValue();
        int maxB = quadraticInput.getMaxB().intValue();
        int minC = quadraticInput.getMinC().intValue();
        int maxC = quadraticInput.getMaxC().intValue();

        double a = generateRandomCoefficient(minA, maxA);
        double b = generateRandomCoefficient(minB, maxB);
        double c = generateRandomCoefficient(minC, maxC);

        // Construct the quadratic equation
        String equation = String.format("%.0fx^2 + %.0fx + %.0f", a, b, c);

        // Determine the nature of roots
        String natureOfRoots = determineNatureOfRoots(a, b, c);


        quadraticEquationInfo.setEquation(equation);
        quadraticEquationInfo.setCoefficientA(a);
        quadraticEquationInfo.setCoefficientB(b);
        quadraticEquationInfo.setCoefficientC(c);
        quadraticEquationInfo.setNatureOfRoots(natureOfRoots);

        return quadraticEquationInfo;
    }

    private double generateRandomCoefficient(double min, double max) {
        return min + (max - min) * new Random().nextDouble();
    }

    private int generateRandomCoefficient(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    private String determineNatureOfRoots(double a, double b, double c) {
        // Assuming quadratic equation is of the form ax^2 + bx + c
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            return "Two real and different roots";
        } else if (discriminant == 0) {
            return "Two real and equal roots";
        } else {
            return "Two complex roots";
        }
    }


}
