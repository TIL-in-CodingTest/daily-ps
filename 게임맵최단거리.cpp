#include<vector>
#include<queue>
#include<iostream>
using namespace std;

struct Node {
    int r;
    int c;
    int cnt;
};

int dr[] = {1, -1, 0, 0};
int dc[] = {0, 0, 1, -1};
bool visited[101][101];
queue<Node> q;

// bfs
int solution(vector<vector<int>> maps)
{
    int n = maps.size();
    int m = maps[0].size();
    
    Node node;
    node.r = 0;
    node.c = 0;
    node.cnt = 1;
    
    q.push(node);
    visited[0][0] = true;
    
    while(!q.empty()) {
        Node node = q.front();
        q.pop();
        
        if(node.r == n - 1 && node.c == m - 1) {
            return node.cnt;
        }
        
        for(int d = 0; d < 4; d++) {
            int nr = node.r + dr[d];
            int nc = node.c + dc[d];
            
            if(nr < 0 || nr >= n || nc < 0 || nc >= m) {
                continue;
            }
            
            if(visited[nr][nc]) {
                continue;
            }
            
            if(maps[nr][nc] == 0) {
                continue;
            }
            
            Node next;
            next.r = nr;
            next.c = nc;
            next.cnt = node.cnt + 1;
            
            q.push(next);
            visited[nr][nc] = true;
        }
    }
    
    return -1;
}
