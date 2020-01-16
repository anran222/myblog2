package lianxi;
/**
 * 弗洛伊德算法思想:
 * 	Ak(i,j)意思是i点到j点经过一系列点，但是点下标最多不超过k
 * 情况1：如果Ak(i,j)不经过k,那么Ak(i,j)=Ak-1(i,j);
 * 情况2：如果Ak(i,j)经过k，那么Ak(i,j)=Ak-1(i,k)+Ak-1(k,j);
 * 	所以Ak(i,j) = min{Ak-1(i,j),Ak-1(i,k)+Ak-1(k,j)};
 *
 * 第k层的计算依赖于k-1的结果，所以循环从k=0开始计算起
 *
 */
public class FloydAlgorithm {
    private int[][] matrix;  // 用邻接矩阵来表示图
    private char[]  nodeNames;  // 每个点的标号对应一个字符，代表点的名字
    private final int INF = Integer.MAX_VALUE;
    public FloydAlgorithm(char[] nodeNames, int[][] matrix){
        this.nodeNames = nodeNames;
        this.matrix = matrix;
    }

    public void floyd(){ // 计算出任意两点间的最短路径，只要该路径存在
        int vertexNum = nodeNames.length;
        int[][] distance = new int[vertexNum][vertexNum];// 距离矩阵
        StringBuilder[][] path = new StringBuilder[vertexNum][vertexNum];//用来存储最短路径经过的点
        // 初始化距离矩阵
        for(int i=0; i<vertexNum; i++){
            for(int j=0; j<vertexNum; j++){
                path[i][j] = new StringBuilder();
                distance[i][j] = matrix[i][j];
                if(distance[i][j]!=0) { // 权重>0代表该边存在 初始化它的路径
                    path[i][j].append(nodeNames[i]+"->"+nodeNames[j]);
                }
            }
        }
        //循环更新矩阵的值  最外层循环代表经过的点下标不超过k时的最短路径
        for(int k=0; k<vertexNum; k++){
            // 内嵌的双层循环 代表计算
            for(int i = 0;i< vertexNum;i++) {
                if(i==k) {
                    continue;
                }
                for(int j = 0;j<vertexNum;j++) {
                    //Ak(i,j) = min{Ak-1(i,j),Ak-1(i,k)+Ak-1(k,j)};Ak-1(i,j)即上一次循环计算出的disance[i][j]
                    if(j!=k&&i!=j) {
                        int ak_1ij = distance[i][j],ak_1ik_plus_ak_1kj  = INF;
                        if(distance[i][k]!=0&&distance[k][j]!=0) { // 必须保证distance[i][k]和distance[k][j]是存在的
                            ak_1ik_plus_ak_1kj = distance[i][k]+distance[k][j];
                        }
                        if(distance[i][j]==0&&ak_1ik_plus_ak_1kj==INF) { // 如果之前i和j之间没有可走的路径
                            continue;
                        }
                        distance[i][j] = ak_1ij > ak_1ik_plus_ak_1kj||ak_1ij==0?ak_1ik_plus_ak_1kj:ak_1ij;//比较求出最短ak(i,j)
                        if(distance[i][j]==ak_1ik_plus_ak_1kj) { //处理路径字符串的拼接
                            path[i][j].delete(0,path.length+1).append(path[i][k].toString().substring(0, path[i][k].length()-1)+path[k][j].toString());
                            // 之前出现C->B:BC->D->B这种状况是因为之前的Stringbuilder没有清空导致的
                        }
                    }
                }
            }
        }

        System.out.printf("原矩阵: \n");
        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++)
                System.out.printf("%02d ",matrix[i][j]);
            System.out.printf("\n");
        }
        // 打印floyd最短路径的结果
        System.out.printf("最短距离矩阵: \n");
        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++)
                System.out.printf("%02d ",distance[i][j]);
            System.out.printf("\n");
        }

        System.out.printf("最短路径: \n");
        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++)  {
                if(i==j||distance[i][j]==0) continue;
                System.out.println(nodeNames[i]+"->"+nodeNames[j]+"的最短路径为: "+path[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[][] graph = new int[6][6];
        char[] nodeNames = new char[] {'A','B','C','D','E','F'};
        graph[0][1] = 50;
        graph[0][2] = 10;
        graph[0][4] = 45;
        graph[1][2] = 15;
        graph[1][4] = 10;
        graph[2][0] = 20;
        graph[2][3] = 15;
        graph[3][1] = 20;
        graph[3][4] = 35;
        graph[4][3] = 30;
        graph[5][3] = 3;

        FloydAlgorithm floydAlgorithm = new FloydAlgorithm(nodeNames, graph);
        floydAlgorithm.floyd();
        long end = System.currentTimeMillis();
        System.out.println("程序用时:"+(end-start)/1000.0+"秒");
    }
}