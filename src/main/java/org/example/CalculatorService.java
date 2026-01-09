package org.example;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public double sqrt(double a) {
        return Math.sqrt(a);
    }

    public long factorial(int n) {
        long f = 1;
        for (int i = 1; i <= n; i++) f *= i;
        return f;
    }

    public double ln(double a) {
        return Math.log(a);
    }

    public double power(double a, double b) {
        return Math.pow(a, b);
    }
}
