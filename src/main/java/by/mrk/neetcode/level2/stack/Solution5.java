package by.mrk.neetcode.level2.stack;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://neetcode.io/problems/car-fleet/question">Car Fleet</a>
 */
public class Solution5 {

    public static void main(String[] args) {
        Solution5 s = new Solution5();
        System.out.println(s.carFleet(10, new int[] {1, 4}, new int[] {3, 2}));
        System.out.println(s.carFleet(10, new int[] {4, 1, 0, 7}, new int[] {2, 2, 1, 1}));
        System.out.println(s.carFleet(12, new int[] {10, 8, 0, 5, 3}, new int[] {2, 4, 1, 1, 3}));
    }

    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = toCars(target, position, speed);

        Arrays.sort(cars, Comparator.comparing(Car::position).reversed());

        int counter = 0;
        double time =  Double.NEGATIVE_INFINITY;

        for (Car car : cars) {
            double newTime = car.time2Ride;

            if (newTime > time) {
                counter++;
                time = newTime;
            }
        }

        return counter;
    }

    private Car[] toCars(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];

        for (int i = 0; i < position.length; i++) {
            int distance = target - position[i];
            double time = 1.0 * distance / speed[i];

            cars[i] = new Car(position[i], time);
        }

        return cars;
    }

    static class Car {

        int position;
        double time2Ride;

        public Car(int position, double time2Ride) {
            this.position = position;
            this.time2Ride = time2Ride;
        }

        public double position() {
            return position;
        }
    }
}
