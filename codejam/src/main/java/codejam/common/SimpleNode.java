/**
 * 
 */
package codejam.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author david
 *
 */
public class SimpleNode implements Node<SimpleItem> {

	private SimpleItem item;
	private List<DirectedEdge<SimpleItem>> edges;
	
	public SimpleNode(SimpleItem item){
		this.item = item;
	}
	
	@Override
	public SimpleItem getItem() {
		return item;
	}

	@Override
	public void setItem(SimpleItem item) {
		this.item = item;
	}

	@Override
	public List<DirectedEdge<SimpleItem>> getEdges() {
		return edges;
	}

	@Override
	public void addEdge(DirectedEdge<SimpleItem> edge) {
		if (edges == null){
			edges = new ArrayList<DirectedEdge<SimpleItem>>();
		}
		edges.add(edge);
	}
	
	@Override
	public void addEdge(Node<SimpleItem> to, int weight){
		DirectedEdge<SimpleItem> edge = new DirectedEdge<SimpleItem>(this, to, weight);
		addEdge(edge);
	}
}
