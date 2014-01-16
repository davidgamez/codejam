/**
 * 
 */
package codejam.common;

/**
 * @author david
 *
 */
public class SimpleItem implements Labeled {

	private String label;
	
	
	public SimpleItem(String label) {
		super();
		this.label = label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}


	/* (non-Javadoc)
	 * @see com.codejam.dijkstra.Labeled#getLabel()
	 */
	@Override
	public String getLabel() {
		return label;
	}

}
