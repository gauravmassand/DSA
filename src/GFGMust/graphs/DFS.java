package GFGMust.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
Use Recursive Approach.For every call we have list containing graph Representation,
Visited , and current node.
Call all the neighbours in loop and call dfs method for every neighbour and
mark the node as visited.
Base Condition is if its already visited then return;
 */
public class DFS {

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg  =sc.nextInt();
            for(int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());

            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            boolean vis[] = new boolean[nov];
            for(int i = 0; i < nov; i++)
                vis[i] = false;
            dfs(0, list, vis);
            System.out.println();
        }
    }

    static void dfs(int src, ArrayList<ArrayList<Integer>> list, boolean vis[])
    {
        if(vis[src]) {
            return;
        }
        List<Integer> neighbourList = list.get(src);
        vis[src]=true;
        System.out.print(src +" ");
        for(int i : neighbourList) {
            dfs(i,list,vis);
        }

    }

}
