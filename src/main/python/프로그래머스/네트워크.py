from collections import deque

def solution(n, computers):
  visited = [False] * n
  queue = deque()
  answer = 0

  for i in range(n):
    if visited[i]:
      continue

    answer += 1
    queue.append(i)
    visited[i] = True

    while queue:
      num = queue.popleft()
      for j in range(n):
        if visited[j] or computers[num][j] == 0:
          continue

        queue.append(j)
        visited[j] = True

  return answer