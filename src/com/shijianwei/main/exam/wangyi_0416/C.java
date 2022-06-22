package com.shijianwei.main.exam.wangyi_0416;


import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/4/16 14:51
 */
public class C {
    static int N = (int) 1e5 + 5;
    static int n ,m , tot = 0;
    static int[] fa = new int[N];
    static long[] a = new long[N];

    static class Edge{
        int u,v, w;
    }

    static class cmp implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.w - o2.w;
        }
    }

    static Edge[] edges = new Edge[N];

    public static void addEdge(int u, int v, int w) {
        edges[tot] = new Edge();
        edges[tot].u = u;
        edges[tot].v = v;
        edges[tot++].w = w;
    }

    public static int find(int u) {
        if (fa[u] == u) {
            return fa[u];
        }
        return fa[u] = find(fa[u]);
    }

    public static int calZero(long u, long v) {
        BigInteger bu = new BigInteger(Long.toString(u));
        BigInteger bv = new BigInteger(Long.toString(v));
        BigInteger mul = bu.multiply(bv);
        BigInteger TEN = new BigInteger("10");
        BigInteger ZERO = new BigInteger("0");
        int count = 0;
        while (mul.mod(TEN).equals(ZERO)) {
            count++;
            mul = mul.divide(TEN);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            fa[i] = i;
            a[i] = sc.nextLong();
        }
        int totalSum = 0;
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = calZero(a[u],a[v]);
            totalSum += w;
            addEdge(u, v, w);
        }
        Arrays.sort(edges, 0, tot, new cmp());
        int cnt = 0, sum = 0;
        for (int i = 0; i < tot; i++) {
            int u = edges[i].u;
            int v = edges[i].v;
            int w = edges[i].w;
            int fu = find(u);
            int fv = find(v);
            if (fu != fv) {
                sum += w;
                fa[fu] = fv;
                cnt++;
            }
            if (cnt == n - 1) {
                break;
            }
        }
        System.out.println(totalSum - sum);

        sc.close();

    }

}
