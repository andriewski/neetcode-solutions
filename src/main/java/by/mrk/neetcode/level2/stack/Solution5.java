package by.mrk.neetcode.level2.stack;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://neetcode.io/problems/car-fleet/question">Car Fleet</a>
 */
public class Solution5 {

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

    class Car {

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
