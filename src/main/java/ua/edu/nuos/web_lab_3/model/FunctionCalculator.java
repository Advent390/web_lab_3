package ua.edu.nuos.web_lab_3.model;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class FunctionCalculator {
    private final double a;
    private final double start;
    private final double end;
    private final double h;

    private List<Point> points;
    private int maxIndexY;
    private int minIndexY;

    public FunctionCalculator(double a,double start, double end, double h) {
        this.a = a;
        this.start = start;
        this.end = end;
        this.h = h;

        this.points = generatePoints();
        this.maxIndexY = findMaxYIndex();
        this.minIndexY = findMinYIndex();
    }

    private List<Point> generatePoints() {
        ArrayList<Point> p = new ArrayList<>();
        int steps = calculateSteps(start, end, h);

        for (int i = 0; i < steps; i++) {
            double x = start + i * h;
            double y = calculate(x);

            p.add(new Point(x, y));
        }

        return p;
    }

    int findMaxYIndex() {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("Points list cannot be null or empty");
        }

        int maxIndex = 0;
        double maxY = points.getFirst().y();

        for (int i = 1; i < points.size(); i++) {
            double currentY = points.get(i).y();
            if (currentY > maxY) {
                maxY = currentY;
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    int findMinYIndex() {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("Points list cannot be null or empty");
        }

        int minIndex = 0;
        double minY = points.getFirst().y();

        for (int i = 1; i < points.size(); i++) {
            double currentY = points.get(i).y();
            if (currentY < minY) {
                minY = currentY;
                minIndex = i;
            }
        }

        return minIndex;
    }

    /**
     * Варіант 6:
     *  y = x * sqrt(x - a),   x > a
     *  y = x * sin(a * x),    x = a
     *  y = e^(-a*x) * cos(a*x), x < a
     */
    double calculate(double x) {
        double EPS = 1e-7;

        if (x > a + EPS) {
            return x * Math.sqrt(x - a);
        } else if (Math.abs(x - a) <= EPS) {
            return x * Math.sin(a * x);
        } else {
            return Math.exp(-a * x) * Math.cos(a * x);
        }
    }

    int calculateSteps(double a, double b, double h) {
        return (int) (Math.round((b - a) / h) + 1);
    }
}
