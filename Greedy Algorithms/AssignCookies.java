import java.util.Arrays;

class AssignCookies {
    public static void main(String[] args) {
        int[] children = { 2, 6, 8, 1, 4 };
        int[] cookies = { 4, 2, 7, 1, 2, 3 };

        Arrays.sort(children);
        Arrays.sort(cookies);

        int childPointer = 0;
        int cookiePointer = 0;
        int assignedCookiesCount = 0;

        while (childPointer < children.length && cookiePointer < cookies.length) {
            if (cookies[cookiePointer] >= children[childPointer]) {
                assignedCookiesCount++;
                childPointer++;
                cookiePointer++;
            } else {
                cookiePointer++;
            }

        }

        System.out.println("Number of cookies assigned: " + assignedCookiesCount);

    }
}