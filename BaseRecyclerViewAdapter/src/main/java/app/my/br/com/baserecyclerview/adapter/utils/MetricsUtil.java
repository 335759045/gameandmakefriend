package app.my.br.com.baserecyclerview.adapter.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;

/**
 * 获取屏幕信息
 * 
 *
 */
public class MetricsUtil {
	private static DisplayMetrics mMetric;
	private static int mStatusBarHeight;

	/**
	 * 获取DisplayMetrics
	 * 
	 * @param mContext
	 * @return
	 */
	public static DisplayMetrics getMetric(Context mContext) {
		if (mMetric == null) {
			mMetric = new DisplayMetrics();
			((Activity)mContext).getWindowManager().getDefaultDisplay().getMetrics(mMetric);
		}
		return mMetric;
	}

	/**
	 * 除却下拉通知栏高度
	 * 
	 * @param mContext
	 * @return
	 */
	public static int getStatusBarHeight(Context mContext) {
		if (mStatusBarHeight == 0) {
			Rect rect = new Rect();
			((Activity) mContext).getWindow().getDecorView()
					.getWindowVisibleDisplayFrame(rect);
			mStatusBarHeight = rect.top;
		}
		return mStatusBarHeight;
	}
	
	/**
	 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
	 */
	public static int dip2px(Context context, float dpValue) {
		final float scale = getMetric(context).density;
		return (int) (dpValue * scale + 0.5f);
	}
	/**
	 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
	 * 
	 */
	public static int px2dip(Context context, float pxValue) {
		final float scale =getMetric(context).density;
		return (int) (pxValue / scale + 0.5f);
	}
	/**
	 * 获取高度
	 * @param context
	 * @return
	 */
	public static int getHeight(Context context) {
		int height = getMetric(context).heightPixels;
		return height;
	}
	/**
	 * 获取宽度
	 * @param context
	 * @return
	 */
	public static int getWidth(Context context) {
		int width = getMetric(context).widthPixels;
		return width;
	}
}
