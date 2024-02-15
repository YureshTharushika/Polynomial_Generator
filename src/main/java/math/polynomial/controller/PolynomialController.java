package math.polynomial.controller;

import math.polynomial.model.*;
import math.polynomial.service.PolynomialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/generate")
public class PolynomialController {

    private final PolynomialService polynomialService;

    public PolynomialController(PolynomialService polynomialService) {
        this.polynomialService = polynomialService;
    }

    @PostMapping("/double_coefficients")
    public ResponseEntity<Polynomial> generatePolynomialDouble(@RequestBody PolynomialInput input) {
        try {
            Polynomial output = polynomialService.generatePolynomialWithDoubleCoefficients(input);
            return new ResponseEntity<>(output, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions and return an appropriate error response
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/int_coefficients")
    public ResponseEntity<Polynomial> generatePolynomialInt(@RequestBody PolynomialInput input) {
        try {
            Polynomial output = polynomialService.generatePolynomialWithIntCoefficients(input);
            return new ResponseEntity<>(output, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions and return an appropriate error response
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/int_coefficients/multiple/{count}")
    public ResponseEntity<List<Polynomial>> generateMultiplePolynomialsInt(
            @PathVariable int count,
            @RequestBody PolynomialInput input) {

        try {
            List<Polynomial> polynomials = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                Polynomial polynomial = polynomialService.generatePolynomialWithIntCoefficients(input);
                polynomials.add(polynomial);
            }

            return new ResponseEntity<>(polynomials, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions and return an appropriate error response
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/double_coefficients/multiple/{count}")
    public ResponseEntity<List<Polynomial>> generateMultiplePolynomialsDouble(
            @PathVariable int count,
            @RequestBody PolynomialInput input) {

        try {
            List<Polynomial> polynomials = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                Polynomial polynomial = polynomialService.generatePolynomialWithDoubleCoefficients(input);
                polynomials.add(polynomial);
            }

            return new ResponseEntity<>(polynomials, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions and return an appropriate error response
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/quadratic/double")
    public ResponseEntity<QuadraticEquationInfo> generateQuadraticEquationDouble(
            @RequestParam(defaultValue = "-10") double minCoefficient,
            @RequestParam(defaultValue = "10") double maxCoefficient) {

        try {
            QuadraticEquationInfo quadraticInfo = polynomialService.generateQuadraticEquation(minCoefficient, maxCoefficient);
            return new ResponseEntity<>(quadraticInfo, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions and return an appropriate error response
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/quadratic/int")
    public ResponseEntity<QuadraticEquationInfo> generateQuadraticEquationInt(
            @RequestParam(defaultValue = "-10") int minCoefficient,
            @RequestParam(defaultValue = "10") int maxCoefficient) {

        try {
            QuadraticEquationInfo quadraticInfo = polynomialService.generateQuadraticEquation(minCoefficient, maxCoefficient);
            return new ResponseEntity<>(quadraticInfo, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions and return an appropriate error response
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/quadratic/separate_ranges/double")
    public ResponseEntity<QuadraticEquationInfo> generateQuadraticEquationWithSeparateRangesDouble(
            @RequestBody QuadraticInput quadraticInput) {

        try {
            QuadraticEquationInfo quadraticInfo = polynomialService.generateQuadraticEquationWithSeparateRangesDouble(quadraticInput);

            return new ResponseEntity<>(quadraticInfo, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions and return an appropriate error response
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/quadratic/separate_ranges/int")
    public ResponseEntity<QuadraticEquationInfo> generateQuadraticEquationWithSeparateRangesInt(
            @RequestBody QuadraticInput quadraticInput) {

        try {
            QuadraticEquationInfo quadraticInfo = polynomialService.generateQuadraticEquationWithSeparateRangesInt(quadraticInput);

            return new ResponseEntity<>(quadraticInfo, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions and return an appropriate error response
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/quadratic/multiple/int/{count}")
    public ResponseEntity<List<QuadraticEquationInfo>> generateMultipleQuadraticEquationsInt(
            @PathVariable int count,
            @RequestBody QuadraticInput quadraticInput) {

        try {
            List<QuadraticEquationInfo> equations = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                QuadraticEquationInfo equation = polynomialService.generateQuadraticEquationWithSeparateRangesInt(quadraticInput);
                equations.add(equation);
            }

            return new ResponseEntity<>(equations, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions and return an appropriate error response
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/quadratic/multiple/double/{count}")
    public ResponseEntity<List<QuadraticEquationInfo>> generateMultipleQuadraticEquationsDouble(
            @PathVariable int count,
            @RequestBody QuadraticInput quadraticInput) {

        try {
            List<QuadraticEquationInfo> equations = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                QuadraticEquationInfo equation = polynomialService.generateQuadraticEquationWithSeparateRangesDouble(quadraticInput);
                equations.add(equation);
            }

            return new ResponseEntity<>(equations, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions and return an appropriate error response
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
