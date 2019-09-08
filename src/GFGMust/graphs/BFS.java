package GFGMust.graphs;

import java.util.*;
/*
For BFS Queue is required.Pop Element from Queue and put all its neighbours
in queue.
 */

public class BFS {

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();

            for(int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());

            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            boolean vis[] = new boolean[nov];
            for(int i = 0; i < nov; i++)
                vis[i] = false;
           bfs(0, list, vis, nov
           );
            System.out.println();
        }
    }


    static void bfs(int s, ArrayList<ArrayList<Integer>> list, boolean vis[], int nov)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        vis[s]=true;

        while(!queue.isEmpty()) {
            int element = queue.poll();
            System.out.print(element + " ");
            vis[element]= true;
            List<Integer> neigh = list.get(element);;
            for(int i : neigh) {
                queue.add(i);
            }
        }


    }
}
