package Zurl.Graph.ShortestPath;

/**
 * Created by zcy on 4/8/2016.
 */
public class Floyd {
    public static int shortest(int[][] map,int st,int ed){
        int n = map.length;
        for(int k = 0;k<=n;k++)
            for(int i = 0;i<=n;i++)
                for(int j= 0;j<=n;j++)
                    if(map[i][j] > map[i][k] + map[k][j])
                        map[i][j] = map[i][k] + map[k][j];
        return map[st][ed];
    }
}
