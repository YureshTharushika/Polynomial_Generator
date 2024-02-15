package math.polynomial.util;

import math.polynomial.model.Polynomial;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PolynomialGenerator {

    public static Polynomial generatePolynomialWithDoubleCoefficients(int degree, double minCoefficient, double maxCoefficient) {
        if (degree < 0) {
            throw new IllegalArgumentException("Degree must be non-negative");
        }

        List<Number> coefficients = new ArrayList<>();
        Random random = new Random();

        // Generate random coefficients within the specified range
        for (int i = 0; i <= degree; i++) {
            double coefficient = minCoefficient + (maxCoefficient - minCoefficient) * random.nextDouble();
            coefficients.add(coefficient);
        }

        // Construct the polynomial equation
        StringBuilder equationBuilder = new StringBuilder();
        for (int i = degree; i >= 0; i--) {
            Number coefficient = coefficients.get(i);
            double coefficientValue = coefficient.doubleValue();

            if (coefficientValue != 0) {
                if (equationBuilder.length() > 0) {
                    equationBuilder.append(coefficientValue > 0 ? " + " : " - ");
                }

                // Format the coefficient to two decimal points
                equationBuilder.append(String.format("%.2f", Math.abs(coefficientValue)));

                if (i > 0) {
                    equationBuilder.append("x");
                    if (i > 1) {
                        equationBuilder.append("^").append(i);
                    }
                }
            }
        }

        // Create the Polynomial object
        Polynomial polynomial = new Polynomial();
        polynomial.setEquation(equationBuilder.toString());
        polynomial.setCoefficients(coefficients);

        return polynomial;
    }

    public static Polynomial generatePolynomialWithIntCoefficients(int degree, int minCoefficient, int maxCoefficient) {
        if (degree < 0) {
            throw new IllegalArgumentException("Degree must be non-negative");
        }

        List<Number> coefficients = new ArrayList<>();
        Random random = new Random();

        // Generate random integer coefficients within the specified range
        for (int i = 0; i <= degree; i++) {
            int coefficient = random.nextInt((maxCoefficient - minCoefficient) + 1) + minCoefficient;
            coefficients.add(coefficient);
        }

        // Construct the polynomial equation
        StringBuilder equationBuilder = new StringBuilder();
        for (int i = degree; i >= 0; i--) {
            Number coefficient = coefficients.get(i);
            if (coefficient.intValue() != 0) {
                if (equationBuilder.length() > 0) {
                    equationBuilder.append(coefficient.intValue() > 0 ? " + " : " - ");
                }
                equationBuilder.append(Math.abs(coefficient.intValue()));

                if (i > 0) {
                    equationBuilder.append("x");
                    if (i > 1) {
                        equationBuilder.append("^").append(i);
                    }
                }
            }
        }

        // Create the Polynomial object
        Polynomial polynomial = new Polynomial();
        polynomial.setEquation(equationBuilder.toString());
        polynomial.setCoefficients(coefficients);

        return polynomial;
    }


}
