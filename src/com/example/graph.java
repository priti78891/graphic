package com.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class graph<T> {
    private Map<T,List<T>>map=new HashMap<>();
    public void addVertex(T s)
    {
        map.put(s,new LinkedList<T>());
    }
    public void addEdge(T source ,T destination,boolean bidirectional)
    {
        if(!map.containsKey(source))
            addVertex(source);
        if (!map.containsKey(destination))
            addVertex(destination);
        map.get(source).add(destination);
        if (bidirectional==true)
            map.get(destination).add(source);
    }

    public void getVertexCount()
    {
        System.out.println("The graph has "+map.keySet()+" vertexes ");
    }


    public void getEdgesCount(boolean bidirectional)
    {
        int count=0;
        for (T v: map.keySet())
        {
            count+= map.get(v).size();
        }
        if (bidirectional==true)
        {
            count/=2;
        }

        System.out.println("The graph has "+count+" edges ");
    }

    public void hasVertex(T s){
        if (map.containsKey(s))
            System.out.println("The graph has "+s+" as a vertex");
        else
            System.out.println("The graph has not  "+s+" as a vertex");
    }

    public void hasEdge (T s,T d)
    {
        if (map.get(s).contains(d))
            System.out.println("The graph has edge between  " +s+" and "+d);

        else
            System.out.println("The graph has not edges between "+s+" and "+d);

    }

    public String toString()
    {
       StringBuilder builder= new StringBuilder();
        for (T v:map.keySet())
        {
            builder.append(v.toString()+" :");
            for (T w:map.get(v))
            {
                builder.append(w.toString()+"  ");
            }
            builder.append("\n");
        }

        return (builder.toString());
    }
    public  static void main(String[] args) {

        graph<Integer> g=new graph<Integer>();
        g.addEdge(0,1,true);
        g.addEdge(1,0,true);
        g.addEdge(2,0,true);
        g.addEdge(1,2,true);
        g.addEdge(0,2,true);

        System.out.println(g.toString());


    }
}
