/**
 * 
 */
package com.codejam.common;

/**
 * @author dgamez
 * 
 */
public class DirectedEdge<T extends Labeled> {

	private Node<T> from;
	private Node<T> to;
	private int weight;

	/**
	 * @param from
	 * @param to
	 * @param weight
	 */
	public DirectedEdge(Node<T> from, Node<T> to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	/**
	 * @return the from
	 */
	public Node<T> getFrom() {
		return from;
	}

	/**
	 * @param from
	 *            the from to set
	 */
	public void setFrom(Node<T> from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public Node<T> getTo() {
		return to;
	}

	/**
	 * @param to
	 *            the to to set
	 */
	public void setTo(Node<T> to) {
		this.to = to;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

}
