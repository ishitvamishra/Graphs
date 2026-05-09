class Solution {

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        Stack<Integer> st = new Stack<>();

        int maxArea = 0;

        for (int i = 0; i <= n; i++) {

            while (!st.isEmpty() &&
                   (i == n || heights[st.peek()] >= heights[i])) {

                int height = heights[st.pop()];

                int nse = i;

                int pse = st.isEmpty() ? -1 : st.peek();

                int width = nse - pse - 1;

                maxArea = Math.max(maxArea, height * width);
            }

            st.push(i);
        }

        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxArea = 0;

        int[] heights = new int[m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == '1') heights[j]++;
                else heights[j] = 0;
            }

            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }
}