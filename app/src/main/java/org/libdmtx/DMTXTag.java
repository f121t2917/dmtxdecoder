package org.libdmtx;

import org.libdmtx.DMTXPoint;

public class DMTXTag {
	public String id;

	public DMTXPoint corner1;
	public DMTXPoint corner2;
	public DMTXPoint corner3;
	public DMTXPoint corner4;

	public DMTXTag(final String aID, final DMTXPoint aCorner1, final DMTXPoint aCorner2, final DMTXPoint aCorner3, final DMTXPoint aCorner4) {
		id = aID;
		corner1 = aCorner1;
		corner2 = aCorner2;
		corner3 = aCorner3;
		corner4 = aCorner4;
	}
}
