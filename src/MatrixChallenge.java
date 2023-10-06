public class MatrixChallenge {
    public static void main(String[] args) {
        String[] input1 = {"10100", "10111", "11111", "10010"};
        String[] input2 = {"1011", "0011", "0111", "1111"};
        String[] input3 = {"101", "111", "001"};

        System.out.println(matrixChallenge(input1));
        System.out.println(matrixChallenge(input2));
        System.out.println(matrixChallenge(input3));
    }

    public static int matrixChallenge(String[] strArr) {
        int maxArea = 0;
        int columns = strArr[0].length();

        int[] heights = new int[columns];

        for (String row : strArr) {
            for (int i = 0; i < columns; i++) {
                heights[i] = row.charAt(i) == '1' ? heights[i] + 1 : 0;
            }
            maxArea = Math.max(maxArea, findMaxRectangleArea(heights));
        }

        return maxArea;
    }

    public static int findMaxRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int minHeight = findMinHeight(heights, i, j);
                int width = j - i + 1;
                int area = minHeight * width;
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    private static int findMinHeight(int[] heights, int start, int end) {
        int minHeight = heights[start];
        for (int i = start + 1; i <= end; i++) {
            minHeight = Math.min(minHeight, heights[i]);
        }
        return minHeight;
    }
}