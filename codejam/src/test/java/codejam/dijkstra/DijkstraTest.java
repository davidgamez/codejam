/**
 * 
 */
package codejam.dijkstra;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import codejam.common.DirectedEdge;
import codejam.common.DirectedEdgeUtils;
import codejam.common.SimpleItem;
import codejam.common.SimpleNode;

/**
 * @author dgamez
 *
 */
public class DijkstraTest {

	@Test
	public void getShortestPath(){
		
		SimpleItem itemA = new SimpleItem("A");
		SimpleNode nodeA = new SimpleNode(itemA);
		
		SimpleItem itemB = new SimpleItem("B");
		SimpleNode nodeB = new SimpleNode(itemB);
		
		SimpleItem itemC = new SimpleItem("C");
		SimpleNode nodeC = new SimpleNode(itemC);
		
		SimpleItem itemD = new SimpleItem("D");
		SimpleNode nodeD = new SimpleNode(itemD);
		
		nodeA.addEdge(nodeB, 1);
		nodeA.addEdge(nodeC, 2);
		
		nodeB.addEdge(nodeD, 3);
		nodeB.addEdge(nodeC, 8);
		
		nodeC.addEdge(nodeD, 1);
		nodeC.addEdge(nodeB, 2);
		
		Dijkstra<SimpleItem> dijkdtra = new Dijkstra<SimpleItem>();
		List<DirectedEdge<SimpleItem>> route = dijkdtra.getShortestPath(nodeA, nodeD);
		int distance = DirectedEdgeUtils.instance().computeDistance(route);
		
		Assert.assertEquals(3, distance);
		System.out.println("Shortest distance: " + distance);
	}
	
	
}
