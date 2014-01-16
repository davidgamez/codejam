/**
 * 
 */
package codejam.traveling_salesman;

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
public class PermutationTSPTest {

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
		
		nodeD.addEdge(nodeA, 2);
		
		PermutationTSP<SimpleItem> permutation = new PermutationTSP<SimpleItem>();
		List<DirectedEdge<SimpleItem>> route = permutation.getShortestPath(nodeA);
		int distance = DirectedEdgeUtils.instance().computeDistance(route);
		
		Assert.assertEquals(9, distance);
		System.out.println("Shortest distance: " + distance);
		System.out.println(DirectedEdgeUtils.instance().getPrintableRoute(route));
	}
}
