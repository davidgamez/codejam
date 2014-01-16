/**
 * 
 */
package codejam.traveling_salesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import codejam.common.DirectedEdge;
import codejam.common.DirectedEdgeUtils;
import codejam.common.Labeled;
import codejam.common.Node;

/**
 * This class represents the implementation of the Traveling Salesman Problem.
 * This solution is the most trivial one done by permutation. 
 * 
 * @author dgamez
 * 
 */
public class PermutationTSP<T extends Labeled> {

	
	public List<DirectedEdge<T>> getShortestPath(Node<T> startCity){
		List<DirectedEdge<T>> route = new ArrayList<DirectedEdge<T>>();
		List<Node<T>> visitedCities = new ArrayList<Node<T>>();
		int citiesTotal = getCitiesTotal(startCity);
		return getShortestPath(startCity, startCity, route, visitedCities, 0, citiesTotal, null);
	}

	private List<DirectedEdge<T>> getShortestPath(Node<T> startCity, Node<T> currentCity,
			List<DirectedEdge<T>> route, List<Node<T>> visitedCities, int currentCost, int citiesTotal, Integer minimumCost) {
		List<DirectedEdge<T>> result = null;
		if (currentCost != 0){
			if (startCity == currentCity){
				if (visitedCities.size() == citiesTotal && 
						(minimumCost == null || currentCost < minimumCost)){
					result = route;
				}
				return result;
			}
		}
		if (currentCity.getEdges() != null){
			for(DirectedEdge<T> edge: currentCity.getEdges()){
				if (!visitedCities.contains(edge.getTo())){
					int tempCost = currentCost + edge.getWeight();
					List <Node<T>> tempVisited = new ArrayList<Node<T>>();
					tempVisited.addAll(visitedCities);
					tempVisited.add(edge.getTo());
					List<DirectedEdge<T>> tempRoute = new ArrayList<DirectedEdge<T>>();
					tempRoute.addAll(route);
					tempRoute.add(edge);
					List<DirectedEdge<T>> tempResult = getShortestPath(startCity, edge.getTo(), tempRoute, tempVisited, tempCost,citiesTotal, minimumCost);
					if (tempResult != null && (minimumCost == null || tempCost < minimumCost)){
						result = tempResult;
						minimumCost = DirectedEdgeUtils.instance().computeDistance(tempResult);
					}
				}
			}
		}
		return result;
	}

	private int getCitiesTotal(Node<T> startCity) {
		int result = 0;
		List<Node<T>> visitedNodes = new ArrayList<Node<T>>();
		Stack<Node<T>> stack = new Stack<Node<T>>();
		stack.push(startCity);
		while(!stack.isEmpty()){
			Node<T> currentNode = stack.pop();
			if (!visitedNodes.contains(currentNode)){
				visitedNodes.add(currentNode);
				result++;
				if (currentNode.getEdges() != null){
					for(DirectedEdge<T> edge: currentNode.getEdges()){
						if (!visitedNodes.contains(edge.getTo())){
							stack.push(edge.getTo());
						}
					}
				}	
			}
		}
		return result;
	}
}
