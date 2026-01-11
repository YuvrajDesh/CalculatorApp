package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    // Define the logger instance for this class
    private static final Logger logger = LoggerFactory.getLogger(CalculatorService.class);

    public double sqrt(double a) {
        double result = Math.sqrt(a);
        logger.info("Calculating square root of {}: result = {}", a, result);
        return result;
    }

    public long factorial(int n) {
        logger.info("Calculating factorial for n = {}", n);
        long f = 1;
        for (int i = 1; i <= n; i++) f *= i;
        logger.info("Factorial of {} is {}", n, f);
        return f;
    }

    public double ln(double a) {
        double result = Math.log(a);
        logger.info("Calculating natural log of {}: result = {}", a, result);
        return result;
    }

    public double power(double a, double b) {
        double result = Math.pow(a, b);
        logger.info("Calculating {} raised to the power of {}: result = {}", a, b, result);
        return result;
    }
}