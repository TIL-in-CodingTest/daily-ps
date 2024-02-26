#include <iostream>
#include <queue>

using namespace std;

int dr[8] = {2, 2, 1, 1, -1, -1, -2, -2};
int dc[8] = {1, -1, 2, -2, 2, -2, 1, -1};

void test();
struct pos {
    int r, c, cnt;
};

int main() {
    int T;
    scanf("%d", &T);
    for(int tc = 0; tc < T; tc++) {
        test();
    }
    return 0;
}

void test() {
    int I;
    scanf("%d", &I);
    
    pos start, end;
    scanf("%d %d", &start.r, &start.c);
    scanf("%d %d", &end.r, &end.c);

    bool visited[301][301] = {false};

    queue<pos> q;
    q.push(start);
    visited[start.r][start.c] = true;

    while(!q.empty()) {
        pos cur = q.front();
        q.pop();

        if(cur.r == end.r && cur.c == end.c) {
            printf("%d\n", cur.cnt);
            return;
        }

        for(int d = 0; d < 8; d++) {
            int nr = cur.r + dr[d];
            int nc = cur.c + dc[d];

            if(nr < 0 || nr >= I || nc < 0 || nc >= I) {
                continue;
            }

            if(visited[nr][nc]) {
                continue;
            }

            pos next = {nr, nc, cur.cnt + 1};
            q.push(next);
            visited[nr][nc] = true;
        }
    }
}