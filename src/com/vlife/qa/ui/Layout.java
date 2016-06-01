package com.vlife.qa.ui;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.vlife.qa.base.UiAutomatorBase;

import android.graphics.Rect;

public class Layout extends UiAutomatorBase{
	/**
	 * 获取同行对象，可以设置上下的偏移量
	 * @param srcObject
	 * @param destClass
	 * @param upOffset
	 * @param dowmOffset
	 * @return
	 */
	public UiObject getSameLineObject(UiObject srcObject, String destClass,
			int upOffset, int dowmOffset) {
		Rect r1;
		UiCollection collection = new UiCollection(new UiSelector().index(0));
		UiObject CheckObject = null;
		try {
			r1 = srcObject.getBounds();
			int y0 = r1.top+upOffset;
			int y1 = r1.bottom + dowmOffset;
			for (int i = 0; i < 10; i++) {
				CheckObject = collection.getChildByInstance(new UiSelector().
						className(destClass), i);
				Rect rect = CheckObject.getBounds();
				int centy = rect.centerY();
				if (centy > y0 && centy < y1) {
					return CheckObject;
				}
			}

		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}
		return CheckObject;
	}
	
}
