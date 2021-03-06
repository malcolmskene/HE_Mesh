/*
 * This file is part of HE_Mesh, a library for creating and manipulating meshes.
 * It is dedicated to the public domain. To the extent possible under law,
 * I , Frederik Vanhoutte, have waived all copyright and related or neighboring
 * rights.
 * 
 * This work is published from Belgium. (http://creativecommons.org/publicdomain/zero/1.0/)
 * 
 */
package wblut.nurbs;

import wblut.geom.WB_Point;
import wblut.geom.WB_PointHomogeneous;

/**
 * 
 */
public class WB_NurbsRuledSurface {

	/**
	 * 
	 *
	 * @param CA
	 * @param CB
	 * @return
	 */
	public static WB_BSplineSurface getRuledSurface(WB_BSpline CA, WB_BSpline CB) {
		if ((CA.getLowerU() != CB.getLowerU()) || (CA.getUpperU() != CB.getUpperU())) {
			throw new IllegalArgumentException("Curves not defined on same parameter range.");
		}
		;
		final int degreeA = CA.p();
		final int degreeB = CB.p();
		if (degreeA < degreeB) {
			CA = CA.elevateDegree(degreeB - degreeA);
		} else if (degreeB < degreeA) {
			CB = CB.elevateDegree(degreeA - degreeB);
		} else {
		}
		final WB_NurbsKnot mergedKnot = WB_NurbsKnot.merge(CA.knot(), CB.knot());
		CA = CA.refineKnot(mergedKnot);
		CB = CB.refineKnot(mergedKnot);
		final WB_NurbsKnot VKnot = new WB_NurbsKnot(2, 1);
		final int nocp = mergedKnot.n() + 1;
		final WB_Point[][] controlPoints = new WB_Point[nocp][2];
		for (int i = 0; i < nocp; i++) {
			controlPoints[i][0] = CA.points()[i];
			controlPoints[i][1] = CB.points()[i];
		}
		return new WB_BSplineSurface(controlPoints, mergedKnot, VKnot);
	}

	/**
	 * 
	 *
	 * @param CA
	 * @param CB
	 * @return
	 */
	public static WB_RBSplineSurface getRuledSurface(WB_RBSpline CA, WB_RBSpline CB) {
		if ((CA.getLowerU() != CB.getLowerU()) || (CA.getUpperU() != CB.getUpperU())) {
			throw new IllegalArgumentException("Curves not defined on same parameter range.");
		}
		final int degreeA = CA.p();
		final int degreeB = CB.p();
		if (degreeA < degreeB) {
			CA = CA.elevateDegree(degreeB - degreeA);
		} else if (degreeB < degreeA) {
			CB = CB.elevateDegree(degreeA - degreeB);
		} else {
		}
		final WB_NurbsKnot mergedKnot = WB_NurbsKnot.merge(CA.knot(), CB.knot());
		CA = CA.refineKnot(mergedKnot);
		CB = CB.refineKnot(mergedKnot);
		final WB_NurbsKnot VKnot = new WB_NurbsKnot(2, 1);
		final int nocp = mergedKnot.n() + 1;
		final WB_PointHomogeneous[][] controlPoints = new WB_PointHomogeneous[nocp][2];
		for (int i = 0; i < nocp; i++) {
			controlPoints[i][0] = CA.wpoints[i];
			controlPoints[i][1] = CB.wpoints[i];
		}
		return new WB_RBSplineSurface(controlPoints, mergedKnot, VKnot);
	}
}
