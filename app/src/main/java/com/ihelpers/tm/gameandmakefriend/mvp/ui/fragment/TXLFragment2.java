package com.ihelpers.tm.gameandmakefriend.mvp.ui.fragment;

public class TXLFragment2 extends BaseTXLFragment{
    private boolean isFirst = true;
    @Override
    protected int setLayoutResourceID() {
        setClueType(1);
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
