package Exam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class exam027 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] A;
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) A[i][j] = sc.nextInt();
        }
        BFS(0, 0);
        System.out.println(A[N - 1][M - 1]);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j}); //큐에 현 위치의 좌표 삽입
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k]; // 좌우 검사
                int y = now[1] + dy[k]; // 상하 검사
                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (A[x][y] != 0 && !visited[x][y]) { // 뚫려있는 미로이고, 방문한 적이 없다면
                        visited[x][y] = true; // 방문배열 체크
                        A[x][y] += A[now[0]][now[1]]; // 깊이 카운트 ++
                        queue.add(new int[] {x, y}); // 큐에 삽입
                    }
                }
            }
        }
    }
}