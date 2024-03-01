#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> triangle) {
    int n = triangle.size();
    
    if (n == 0) return 0;
    
    for (int i = 1; i < n; ++i) {
        triangle[i][0] += triangle[i - 1][0];
        triangle[i][i] += triangle[i - 1][i - 1];
    }
    
    for (int i = 2; i < n; ++i) {
        for (int j = 1; j < i; ++j) {
            triangle[i][j] += max(triangle[i - 1][j - 1], triangle[i - 1][j]);
        }
    }
    
    int answer = *max_element(triangle[n - 1].begin(), triangle[n - 1].end());
    
    return answer;
}
