package q1.extract_method.refactored;
import java.util.List;

public class A
{
   Node m1(List<Node> nodes, String p) {	return (Node) extractedMethod(nodes, p);		}

   Edge m2(List<Edge> edgeList, String p) {	return (Edge) extractedMethod(edgeList, p);		}

   <T extends GraphElement> Object extractedMethod(List<T> element, String p)
   {
	   for (T e : element)
		   if (e.contains(p))
			   System.out.println(e);
	   // other implementation
	   return null;
   }
}

class GraphElement
{
	String name;
	
	public boolean contains(String p)	{	return name.contains(p);	}
	
	public String toString() {	return name;	}
}

class Node extends GraphElement
{
   public boolean contains(String p)	{	return super.contains(p);	}
}

class Edge extends GraphElement
{
   public boolean contains(String p)	{	return super.contains(p);	}
}