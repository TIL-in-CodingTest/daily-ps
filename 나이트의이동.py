from collections import deque

T = int(input())
dr = [-2, -2, -1, -1, 1, 1, 2, 2]
dc = [-1, 1, -2, 2, -2, 2, -1, 1]

for _ in range(T):
    I = int(input())
    startR, startC = map(int, input().split())
    endR, endC = map(int, input().split())
    
    visited = [[False] * I for _ in range(I)]
    queue = deque()
    
    queue.append((startR, startC, 0))
    visited[startR][startC] = True

    while queue:
        r, c, cnt = queue.popleft()
        
        if r == endR and c == endC:
            print(cnt)
            break
        
        for d in range(8):
            nr = r + dr[d]
            nc = c + dc[d]

            if(nr < 0 or nr >= I or nc < 0 or nc >= I):
                continue

            if visited[nr][nc]:
                continue

            queue.append((nr, nc, cnt + 1))
            visited[nr][nc] = True
    
