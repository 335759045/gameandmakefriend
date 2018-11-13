package com.ihelpers.tm.gameandmakefriend.mvp.contract;

import java.util.Map;

public interface FBDTContract {
    interface Model{
        void requestPermissions();
        interface modelListner{
            void requestPermissionsSuccess();
        }
    }
    interface View{
        void requestPermissionsSuccess();
    }
    interface Presenter{
        void requestPermissions();
    }
}
