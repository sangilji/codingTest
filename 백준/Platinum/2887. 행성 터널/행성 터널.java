import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    static int n;

    static class Planet {
        int num;
        int x;
        int y;
        int z;

        public Planet(int num, int x, int y, int z) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Node {
        int a;
        int b;
        int cost;

        public Node(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        List<Planet> planets = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets.add(new Planet(i, x, y, z));
        }
        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        planets.sort(Comparator.comparingInt(o -> o.x));
        for (int i = 0; i < n - 1; i++) {
            q.add(new Node(planets.get(i).num, planets.get(i + 1).num, Math.abs(planets.get(i + 1).x - planets.get(i).x)));
        }
        planets.sort(Comparator.comparingInt(o -> o.y));
        for (int i = 0; i < n - 1; i++) {
            q.add(new Node(planets.get(i).num, planets.get(i + 1).num, Math.abs(planets.get(i + 1).y - planets.get(i).y)));
        }
        planets.sort(Comparator.comparingInt(o -> o.z));
        for (int i = 0; i < n - 1; i++) {
            q.add(new Node(planets.get(i).num, planets.get(i + 1).num, Math.abs(planets.get(i + 1).z - planets.get(i).z)));
        }

        int count = 0;
        int result = 0;
        while (!q.isEmpty()) {
            Node tmpNode = q.poll();
            int findA = find(tmpNode.a);
            int findB = find(tmpNode.b);

            if (findA != findB) {
                count++;
                if (findA < findB) {
                    parent[findB] = findA;
                } else {
                    parent[findA] = findB;
                }
                result+= tmpNode.cost;
            }

            if (count == n - 1) {
                break;
            }
        }
        System.out.println(result);
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}