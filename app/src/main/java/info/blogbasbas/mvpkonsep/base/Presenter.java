package info.blogbasbas.mvpkonsep.base;

/**
 * Created by User on 30/08/2018.
 */

public interface Presenter <T extends View> {
    void onAttach(T view);
    void onDetach();
}
