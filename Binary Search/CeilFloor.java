class CeilFloor {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 4, 4, 8, 9, 9, 10, 12, 12, 14, 15 };
        int ceil = -1;
        int floor = -1;
        int target = 6;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                ceil = mid;
                floor = mid;
                break;
            } else if (arr[mid] > target) {
                ceil = arr[mid];
                end = mid - 1;
            } else if (arr[mid] < target) {
                floor = arr[mid];
                start = mid + 1;
            }
        }

        System.out.printf("Ceil: %d \nFloor: %d", ceil, floor);

    }
}