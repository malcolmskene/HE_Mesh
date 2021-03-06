/*
 * This file is part of HE_Mesh, a library for creating and manipulating meshes.
 * It is dedicated to the public domain. To the extent possible under law,
 * I , Frederik Vanhoutte, have waived all copyright and related or neighboring
 * rights.
 * 
 * This work is published from Belgium. (http://creativecommons.org/publicdomain/zero/1.0/)
 * 
 */

package wblut.geom;


public enum WB_Classification {

	UNKNOWN,

	CONVEX,

	CONCAVE,

	SADDLE,

	FLAT,

	FLATCONVEX,

	FLATCONCAVE,

	FRONT,

	BACK,

	ON,

	CROSSING,

	SPANNING,

	FRONTEXCL,

	BACKEXCL,

	CROSSINGEXCL,

	INSIDE,

	OUTSIDE,

	OBLIQUE,

	INLINE,

	PARALLEL,

	ANTIPARALLEL,

	PERPENDICULAR,

	COLLINEAR,

	COPLANAR,

	SAME,

	DIFF,

	SAMEEXCL,

	DIFFEXCL,

	CLOCKWISE,

	COUNTERCLOCKWISE,

	CONTAINING,

	TANGENT
}
