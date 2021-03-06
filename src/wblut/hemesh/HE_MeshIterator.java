/*
 * This file is part of HE_Mesh, a library for creating and manipulating meshes.
 * It is dedicated to the public domain. To the extent possible under law,
 * I , Frederik Vanhoutte, have waived all copyright and related or neighboring
 * rights.
 * 
 * This work is published from Belgium. (http://creativecommons.org/publicdomain/zero/1.0/)
 * 
 */
package wblut.hemesh;

import java.util.Iterator;

public class HE_MeshIterator implements Iterator<HE_Mesh> {
    /**
     *
     */
    Iterator<HE_Mesh> _itr;

    /**
     *
     *
     * @param object
     */
    public HE_MeshIterator(final HE_MeshCollection object) {
	_itr = object.meshes.iterator();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Iterator#hasNext()
     */
    @Override
    public boolean hasNext() {
	return _itr.hasNext();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Iterator#next()
     */
    @Override
    public HE_Mesh next() {
	return _itr.next();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Iterator#remove()
     */
    @Override
    public void remove() {
	_itr.remove();
    }
}
