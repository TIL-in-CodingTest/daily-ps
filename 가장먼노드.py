from collections import deque

# bfs에서 cnt를 세면서 기준 값과 다른 값이 나오면 초기화해주면서 다시 세준다.
def solution(n, edge):
    list = [[] for _ in range(n + 1)]
    for (first, second) in edge:
        list[first].append(second)
        list[second].append(first)
        
    visited = [False] * 7
    queue = deque()
    
    queue.append((1, 0))
    visited[1] = True
    pivotStep = 0
    cnt = 0
    
    while queue:
        num, step = queue.popleft()
        if(pivotStep != step):
            pivotStep = step
            cnt = 0
        cnt += 1
        
        for one in list[num]:
            if(visited[one]):
                continue
                
            queue.append((one, step + 1))
            visited[one] = True
            
    return cnt
        
    
    
