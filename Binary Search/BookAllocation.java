class BookAllocation {
    public int findPages(int[] arr, int k) {
        if (arr.length < k) {
            return -1;
        }

        int low = 0;
        int high = 0;

        for (int pages : arr) {
            low = Math.max(low, pages);
            high += pages;
        }

        int minimumMaxPageLimit = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            boolean isPossible = areAllStudentsAllocatedBook(k, mid, arr);

            if (isPossible) {
                minimumMaxPageLimit = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return minimumMaxPageLimit;

    }

    boolean areAllStudentsAllocatedBook(int totalStudents, int maxPageLimit, int[] books) {
        int noOfstudentAllocatedBook = 1;
        int totalPagesGiven = books[0];

        for (int i = 1; i <= books.length - 1; i++) {
            if (books[i] + totalPagesGiven <= maxPageLimit) {
                totalPagesGiven += books[i];
            } else {
                noOfstudentAllocatedBook++;
                totalPagesGiven = books[i];

                if (noOfstudentAllocatedBook > totalStudents) {
                    return false;
                }
            }
        }

        return true;
    }
}