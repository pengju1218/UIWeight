package com.csdn.Weight.ImageView.util;

import android.graphics.Bitmap;

/**
 * 裁剪工具类
 * 
 * @author freeman.wu
 *
 */
public class ClipImageUtils {
	/**
	 * 对源位图进行剪裁
	 * 
	 * @param source
	 * @param x 位置
	 * @param y 位置
	 * @param width
	 *            剪裁内容的宽度
	 * @param height
	 *            剪裁内容的高度
	 * @param imWidth 最小宽度
	 * @param imHeight 最小高度
	 * @return
	 */
	public static Bitmap clipImage(Bitmap source, int x, int y, int width,
			int height, int imWidth, int imHeight) {

		int bmWidth = source.getWidth();
		int bmHeight = source.getHeight();
		float scale = Math.min((float) bmWidth / imWidth, (float) bmHeight
				/ imHeight);

		return clipImage(source, x, y, width, height, scale);
	}

	/**
	 * 对源位图进行剪裁
	 * 
	 * @param source
	 * @param x 位置
	 * @param y  位置
	 * @param width
	 *            剪裁内容的宽度
	 * @param height
	 *            剪裁内容的高度
	 * @param scale
	 *            剪裁比例
	 * @return
	 */
	public static Bitmap clipImage(Bitmap source, int x, int y, int width,
			int height, float scale) {

		int bmWidth = source.getWidth();
		int bmHeight = source.getHeight();

		x *= scale;
		y *= scale;
		width *= scale;
		height *= scale;

		/**
		 * 校正x,y的值
		 */
		x = (x + width > bmWidth) ? bmWidth - width : x;
		x = x < 0 ? 0 : x;
		y = (y + height > bmHeight) ? bmHeight - height : y;
		y = y < 0 ? 0 : y;

		return Bitmap.createBitmap(source, x, y, width, height);
	}
}
