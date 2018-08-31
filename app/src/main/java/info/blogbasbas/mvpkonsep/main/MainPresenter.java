package info.blogbasbas.mvpkonsep.main;

import info.blogbasbas.leranmvp.views.base.Presenter;

/**
 * Created by User on 30/08/2018.
 */

public class MainPresenter implements Presenter<MainView> {
    private MainView mainView;
    @Override
    public void onAttach(MainView view) {
        mainView = view;
    }

    @Override
    public void onDetach() {
        mainView = null;
    }


    //
    void showData(String a, String b){
           if (a.isEmpty()&&b.isEmpty()){
               mainView.showError();
           }else {
               mainView.showSukses();
               mainView.showDataInDialog();
           }

    }
}
