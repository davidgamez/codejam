/**
 * 
 */
package com.codejam.common;

import java.util.Iterator;
import java.util.List;

/**
 * @author dgamez
 * 
 */
public class DirectedEdgeUtils {

	private static final DirectedEdgeUtils _instance = new DirectedEdgeUtils();

	protected DirectedEdgeUtils() {
		// Do nothing
	}

	public static DirectedEdgeUtils instance() {
		return _instance;
	}

	/**
	 * 
	 * @param <T>
	 * @param route
	 *            to compute the distance
	 * @return the distance of the route computed by the summary of all weight
	 *         of the vertices
	 */
	public <T extends Labeled> int computeDistance(List<DirectedEdge<T>> route) {
		int result = 0;
		if (route != null) {
			Iterator<DirectedEdge<T>> iterator = route.iterator();
			while (iterator.hasNext()) {
				DirectedEdge<T> edge = iterator.next();
				result += edge.getWeight();
			}
		}
		return result;
	}

	public <T extends Labeled> String getPrintableRoute(
			List<DirectedEdge<T>> route) {
		StringBuffer result = new StringBuffer();
		if (route != null) {
			for (DirectedEdge<T> edge : route) {
				result.append("From: " + edge.getFrom().getItem().getLabel()
						+ " To: " + edge.getTo().getItem().getLabel()
						+ " Weight: " + edge.getWeight());
				result.append("\n");
			}
		}
		return result.toString();
	}
}
