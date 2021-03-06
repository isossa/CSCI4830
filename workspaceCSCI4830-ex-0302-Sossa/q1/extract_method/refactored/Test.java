package q1.extract_method.refactored;

import java.util.ArrayList;
import java.util.List;

public class Test
{
	public static void main(String[] args)
	{
		List<Edge> edges = new ArrayList<>();
		List<Node> nodes = new ArrayList<>();
		
		for (int i = 0; i < 5; i++)
		{
			Edge e = new Edge();
			e.name = "Edge " + i;
			edges.add(e);
			
			Node n = new Node();
			n.name = "Node " + i;
			nodes.add(n);
		}
		
		A a = new A();
		a.m1(nodes, "Node 2");
		a.m2(edges, "Edge 3");
	}

}
