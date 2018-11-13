package com.ihelpers.tm.gameandmakefriend.mvp.contract;

public interface ApplyChatRoomContract {
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
