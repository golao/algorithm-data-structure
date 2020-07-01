package org.golao.com;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by golao on 2018/4/2.
 */
public class GraphAlgorithm {
    static class MGraph{
        int numVertexes;
        int[][] arc = {{1,1},{2,2}};
        int[] vexs;
        public MGraph(int nv){
            this.numVertexes = nv;
            this.arc = new int[nv][nv];
        }
    }
    static class Edge{
        int begin;
        int end;
        int weight;
    }


    private void initGraph(){}

    public static void main(String[] args) {
        //构造图
        MGraph mGraph = new MGraph(4);
        mGraph.vexs = new int[]{1,2,3,4};
        //构造边
        mGraph.arc = new int[][]{
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,1}};
        for (int[] ary:mGraph.arc) {
            System.out.println(Arrays.toString(ary));
        }
        DFSTraverse(mGraph);

    }

    public static void DFS(MGraph graph,int i,boolean[] visited){
        visited[i] = true;
        System.out.println(graph.vexs[i]);
        for (int j = 0;j < graph.numVertexes;j++){
            if (graph.arc[i][j] == 1 && !visited[j]){
                DFS(graph,j,visited);
            }
        }
    }
    public static void DFSTraverse(MGraph graph){
        boolean[] visited = new boolean[graph.numVertexes];
        for (int i = 0; i < graph.numVertexes; i++){
            if (!visited[i]){
                DFS(graph,i,visited);
            }
        }
    }

    public static void BFSTraverse(MGraph graph){
        LinkedList<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[graph.numVertexes];
        for (int i = 0; i < graph.numVertexes; i++) {
            if (!visited[i]){
                visited[i] = true;
                System.out.println(graph.vexs[i]);
                queue.addLast(i);
                while (!queue.isEmpty()){
                    i = queue.removeFirst();
                    for (int j = 0; j < graph.numVertexes; j++) {
                        if (graph.arc[i][j] == 1 && !visited[j]){
                            visited[j] = true;
                            System.out.println(graph.vexs[j]);
                            queue.addLast(j);
                        }
                    }
                }
            }
        }
    }

    public static void BFS(MGraph graph){
        boolean[] visited = new boolean[graph.numVertexes];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < graph.numVertexes; i++) {
            if (!visited[i]){
                visited[i] = true;
                System.out.println(graph.vexs[i]);
                queue.addLast(i);
                while (!queue.isEmpty()){
                    i = queue.removeFirst();
                    for (int j = 0; j < graph.numVertexes; j++) {
                        if (graph.arc[i][j] == 1 && !visited[j]){
                            queue.addLast(j);
                            System.out.println(graph.vexs[j]);
                        }
                    }
                }
            }
        }
    }

    /**
     *
     * @param graph
     */
    public static void miniSpanTreePrim(MGraph graph){
        int[] adjvex = new int[graph.numVertexes];
        int[] lowcost = new int[graph.numVertexes];
//        lowcost[0] = 0 ;
//        adjvex[0] = 0;
        for (int i = 1; i < graph.numVertexes; i++) {
            lowcost[i] = graph.arc[0][i];
//            adjvex[i] = 0;
        }
        for (int i = 1; i < graph.numVertexes; i++) {
            int min = Integer.MAX_VALUE;
            int j = 1,k = 0;
            while ( j < graph.numVertexes){
                if (lowcost[j] != 0 && lowcost[j] < min){
                    min = lowcost[j];
                    k = j;
                }
                j++;
            }
            System.out.println("TODO ---");
            lowcost[k] = 0;
            for (j = 1; j < graph.numVertexes; j++) {
                if (lowcost[j] != 0 && graph.arc[k][j] < lowcost[j]){
                    lowcost[j] = graph.arc[k][j];
                    adjvex[j] = k;
                }
            }
        }
    }

    /**
     * 克鲁斯卡尔
     * @param graph
     */
    public void miniSpanTreeKruskal(MGraph graph){
        
    }

    /**
     * 最短路径 迪杰斯特拉算法
     * @param graph
     * @param v0
     * @param patharc
     * @param shortPathTable
     */
    public void shortestPathDijkstra(MGraph graph,int v0,int[] patharc,int[] shortPathTable) {
        int v, w, k = 0, min = 0;
        boolean[] finalV = new boolean[graph.numVertexes];
        for (v = 0; v < graph.numVertexes; v++) {
//            finalV[v] = 0;
            shortPathTable[v] = graph.arc[v0][v]; //这儿隐藏的是，两个顶点间没有边，则是无穷大，编码实现是int型最大值
//            patharc[v] = 0;
        }
        shortPathTable[v0] = 0; //v0 至 v0 路径为0
        finalV[v0] = true; // v0 至 v0 不需要求路径

        for (v = 1; v < graph.numVertexes; v++) {
            min = Integer.MAX_VALUE;
            for (w = 0; w < graph.numVertexes; w++) {//每次这个循环都选出离v0顶点最近且未求得最短距离的点的一条边
                if (!finalV[w] && shortPathTable[w] < min) {
                    k = w;
                    min = shortPathTable[w];
                }
            }
            finalV[k] = true;  //
            for (w = 0; w < graph.numVertexes; w++) {
                if (!finalV[w] && (min + graph.arc[k][w] < shortPathTable[w])) {//min+graph.arc[k][w] 这段代码可以会溢出
                    shortPathTable[w] = min + graph.arc[k][w];
                    patharc[w] = k;
                }
            }
        }
    }

    public void shortPathFloyd(MGraph graph,int[][] pathMatirx,int[][] shortPathTable){
        for (int i = 0; i < graph.numVertexes; i++) {
            for (int j = 0; j < graph.numVertexes; j++) {
                shortPathTable[i][j] = graph.arc[i][j];
                pathMatirx[i][j] = j;
            }
        }
        for (int i = 0; i < graph.numVertexes; i++) {
            for (int j = 0; j < graph.numVertexes; j++) {
                for (int k = 0; k < graph.numVertexes; k++) {
                    if (shortPathTable[j][k] > shortPathTable[j][i] + shortPathTable[i][k]){
                        shortPathTable[j][k] = shortPathTable[j][i] + shortPathTable[i][k];
                        pathMatirx[j][k] = pathMatirx[j][i];
                    }
                }
            }
        }
    }
}
