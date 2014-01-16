/**
 * 
 */
package codejam.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import codejam.common.DirectedEdge;
import codejam.common.Labeled;
import codejam.common.Node;

/**
 * This class implements the Dijkstra algorithm.
 * 
 * @author dgamez
 * 
 */
public class Dijkstra<T extends Labeled> {

	Set<Node<T>> settledNodes;
	Set<Node<T>> unSettledNodes;
	Map<Node<T>, Integer> distanceMap;
	private Map<Node<T>, DirectedEdge<T>> predecessors;

	/**
	 * 
	 * This method
	 * 
	 * @param startNode
	 *            start Node
	 * @param endNode
	 *            End Node
	 * @return the List of DirectedEdge of the shortest path or null if there is
	 *         no path
	 */
	public synchronized List<DirectedEdge<T>> getShortestPath(
			Node<T> startNode, Node<T> endNode) {
		List<DirectedEdge<T>> result = null;
		// Init data structures
		settledNodes = new LinkedHashSet<Node<T>>();
		unSettledNodes = new LinkedHashSet<Node<T>>();
		predecessors = new HashMap<Node<T>, DirectedEdge<T>>();
		distanceMap = new HashMap<Node<T>, Integer>();

		// Add start node and set the distance to 0
		unSettledNodes.add(startNode);
		distanceMap.put(startNode, 0);

		while (!unSettledNodes.isEmpty()) {
			Node<T> node = extractMinimumDistanceNode(unSettledNodes);
			settledNodes.add(node);
			relaxNeighbors(node);
		}

		// Create the path if it exists
		if (!predecessors.isEmpty()) {
			List<DirectedEdge<T>> path = new ArrayList<DirectedEdge<T>>();
			Node<T> currentNode = startNode;
			while (predecessors.get(currentNode) != null) {
				DirectedEdge<T> edge = predecessors.get(currentNode);
				path.add(edge);
				currentNode = edge.getTo();
			}
			if (currentNode == endNode) {
				result = path;
			}
		}

		return result;
	}

	/**
	 * This method return the node with the shortest distance that is in the Set
	 * nodeSet and remove it from the Set
	 * 
	 * @param nodeSet
	 *            Set of nodes
	 * @return the node with the shortest distance in nodeSet
	 */
	private Node<T> extractMinimumDistanceNode(Set<Node<T>> nodeSet) {
//		This method could use a Priority Queue to improve it performance
		Node<T> result = null;
		int minimumDistance = Integer.MIN_VALUE;
		for (Node<T> node : nodeSet) {
			Integer distance = distanceMap.get(node);
			if (distance != null
					&& (result == null || minimumDistance > distance)) {
				result = node;
				minimumDistance = distance;
			}
		}
		if (result != null) {
			nodeSet.remove(result);
		}
		return result;
	}

	/**
	 * This method review the distance of all neighbors vertices of node that
	 * are not in settled set. If the distance to the neighbor node(already
	 * calculated) is greater than the distance of the node +
	 * distance(node,neighbor) then new shortest distance will be assigned and
	 * the neighbor will be added to unsettled set
	 * 
	 * @param node
	 *            to relax their neighbors
	 */
	private void relaxNeighbors(Node<T> node) {
		if (node.getEdges() != null) {
			for (DirectedEdge<T> neighbour : node.getEdges()) {
				if (!settledNodes.contains(neighbour.getTo())) {
					// Compute the distance to the neighbour having node in the
					// path
					int distanceToNeighbour = distanceMap.get(node)
							+ neighbour.getWeight();
					Integer distanceComputedNeighbour = distanceMap
							.get(neighbour.getTo());

					if (distanceComputedNeighbour == null
							|| distanceToNeighbour < distanceComputedNeighbour) {
						predecessors.put(node, neighbour);
						distanceMap.put(neighbour.getTo(), distanceToNeighbour);
						unSettledNodes.add(neighbour.getTo());
					}
				}
			}
		}
	}

}
