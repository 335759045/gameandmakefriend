package com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment;

public class OrderFragment3 extends BaseOrderListFragment{
    private boolean isFirst = true;
    @Override
    protected int setLayoutResourceID() {
        setClueType(2);
        return super.setLayoutResourceID();
    }

    @Override
    protected void lazyLoad() {
        if (!isVisible || !isPrepared ||! isFirst) {
            return;
        }
        isFirst = false;
        getDataList();
    }
}
