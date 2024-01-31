package programmers;

class 정수삼각형 {

    // row 마다 맨 처음, 끝 인덱스는 길이 하나 뿐이니 먼저 해결
    // 이후 i row에는 i-1 까지만 판단
    // 마지막에 한바퀴 돌면서 확인
    public int solution(int[][] triangle) {

        for(int i = 1; i < triangle.length; i++) {
            triangle[i][i] = triangle[i][i] + triangle[i - 1][i - 1];
            triangle[i][0] = triangle[i][0] + triangle[i - 1][0];
        }

        for(int i = 2; i < triangle.length; i++) {
            for(int j = 1; j < i; j++) {
                triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
            }
        }

        int answer = -1;
        int[] lastArr = triangle[triangle.length - 1];
        for(int i = 0; i < lastArr.length; i++) {
            answer = Math.max(answer, lastArr[i]);
        }

        return answer;
    }
}