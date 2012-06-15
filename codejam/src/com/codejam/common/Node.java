/**
 * 
 */
package com.codejam.common;

import java.util.List;

/**
 * @author dgamez
 *
 */
public interface Node<T extends Labeled> {

    T getItem();
    
    void setItem(T item);
    
    void addEdge(DirectedEdge<T> edge);
    
    void addEdge(Node<T> to, int weight);
    
    List<DirectedEdge<T>> getEdges();
}
