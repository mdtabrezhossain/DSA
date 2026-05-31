class CarFleet {
    public int carFleet(int target, int[] positions, int[] speeds) {
        int[][] cars = new int[positions.length][2];

        for (int i = 0; i < cars.length; i++) {
            int position = positions[i];
            int speed = speeds[i];

            cars[i][0] = position;
            cars[i][1] = speed;

        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        int fleetCount = 1;
        int position = cars[0][0];
        int speed = cars[0][1];
        int distance = (target - position);
        double fleetArrivalTime = (double) distance / speed;

        for (int i = 1; i < positions.length; i++) {
            position = cars[i][0];
            speed = cars[i][1];
            distance = (target - position);
            double time = (double) distance / speed;

            if (time > fleetArrivalTime) {
                fleetCount++;
                fleetArrivalTime = time;
            }
        }

        return fleetCount;
    }
}