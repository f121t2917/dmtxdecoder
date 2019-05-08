package org.libdmtx;

import android.graphics.Bitmap;

public class DMTXImage {
	static {
		System.loadLibrary("dmtx");
	}
	public int[] data;
	public int width;
	public int height;

	public DMTXImage(final int aWidth, final int aHeight, final int[] aData) {
		width = aWidth;
		height = aHeight;
		data = aData;
	}

	public DMTXImage(Bitmap aImage) {

		this.width = aImage.getWidth();
		this.height = aImage.getHeight();
		this.data = new int[width * height];
		aImage.getPixels(data, 0, width, 0, 0, width, height);
	}

	/**
	 * Construct from ID (static factory method since JNI doesn't allow native
	 * constructors).
	 */
	public static native DMTXImage createTag(String aID);

	/**
	 * Decode the image, returning tags found (as DMTXTag objects)
	 */
	public native DMTXTag[] getTags(int aMaxTagCount, int searchTimeout);


	public Bitmap toBitmap() {
		return Bitmap.createBitmap(data, width, height, Bitmap.Config.RGB_565);
	}
}
