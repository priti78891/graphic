package graph.com;

public class grp
{
   private int[][]g = new int[10][10];
   private int n;

   grp(int x)
   {
       this.n=x;
       int i,j;
       for(i=0;i<n;i++)
       { for(j=0;j<n;j++)
           g[i][j]=0;
       }
   }
   public void displayAdjacencyMatrix()
   {
       System.out.println("adjacency matrix :");

       for(int i=0;i<n;i++)
       { System.out.println();
           for (int j=0;j<n;j++)
               System.out.print( "  "+g[i][j]+" ");
       }
   }

   public void addVertex()
   {
     n++;
     int i;
     for (i=0;i<n;i++)
     {
      g[i][n-1] =0;
      g[n-1][i]=0;
     }
   }

   public void addEdge(int x,int y)
   {
       if (x>=n||y>n)
           System.out.println("vertex doesn't exist");

       if (x==y)
           System.out.println("same vertices");
       else
           {
               g[x][y]=1;
               g[y][x]=1;
           }
   }

   public void removeVertex(int x)
   {
       if (x>n)
           System.out.println("vertex does not exist ");
       while (x<n)
       {
           for (int i=0;i<n;i++)
               g[i][x]=g[i][x+1];
           for (int i=0;i<n;i++)
               g[x][i]=g[x+1][i];
           x++;
       }
       n--;
   }
public static void main(String[] arg)
{
     grp graph=new grp( 3) ;
     graph.addVertex();
     graph.addEdge(0,1);
     graph.addEdge(0,2);
     graph.addEdge(2,3);
     graph.addEdge(3,1);
     graph.displayAdjacencyMatrix();
}
}
