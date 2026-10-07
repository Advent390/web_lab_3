package ua.edu.nuos.web_lab_3.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FunctionCalculatorTest {
    private static final double EPS = 1e-5;
    private static final double A = 2.4;

    private FunctionCalculator variant() {
        return new FunctionCalculator(A, 1.0, 5.0, 0.01);
    }

    @Test
    void testCalculateWhenXLessThanA() {
        double x = 1.0;
        FunctionCalculator c = new FunctionCalculator(A, 1, 5, 0.01);

        double expected = Math.exp(-A * x) * Math.cos(A * x);

        assertEquals(expected, c.calculate(x), EPS);
    }

    @Test
    void testCalculateWhenXEqualsA() {
        FunctionCalculator c = new FunctionCalculator(A, 1, 5, 0.01);

        double expected = A * Math.sin(A * A);

        assertEquals(expected, c.calculate(A), EPS);
    }

    @Test
    void testCalculateWhenXGreaterThanA() {
        double x = 5.0;
        FunctionCalculator c = new FunctionCalculator(A, 1, 5, 0.01);

        double expected = x * Math.sqrt(x - A);

        assertEquals(expected, c.calculate(x), EPS);
    }

    @Test
    void testCalculateSteps() {
        FunctionCalculator c = variant();

        assertEquals(401, c.calculateSteps(1.0, 5.0, 0.01));
        assertEquals(6, c.calculateSteps(1.0, 2.0, 0.2));
    }

    @Test
    void testGeneratePoints() {
        List<Point> points = variant().getPoints();

        assertEquals(401, points.size());

        // елемент 0: x = 1.0 < a
        Point p0 = points.get(0);
        assertEquals(1.0, p0.x(), EPS);
        assertEquals(Math.exp(-A * 1.0) * Math.cos(A * 1.0), p0.y(), EPS);

        // елемент 140: x = 2.4 = a
        Point p140 = points.get(140);
        assertEquals(2.4, p140.x(), EPS);
        assertEquals(2.4 * Math.sin(A * 2.4), p140.y(), EPS);

        // елемент 400: x = 5.0 > a
        Point p400 = points.get(400);
        assertEquals(5.0, p400.x(), EPS);
        assertEquals(5.0 * Math.sqrt(5.0 - A), p400.y(), EPS);
    }

    @Test
    void testFindMaxYIndex() {
        // максимум функції досягається в кінці інтервалу: 5*sqrt(2.6)
        assertEquals(400, variant().findMaxYIndex());
    }

    @Test
    void testFindMinYIndex() {
        // мінімум — у точці x = a: 2.4*sin(5.76) ≈ -1.2
        assertEquals(140, variant().findMinYIndex());
    }
}
