package com.bamdevelopers.balaji.whatson.View;

import com.bamdevelopers.balaji.whatson.Adapter.EventAdapter;
import com.bamdevelopers.balaji.whatson.Presenter.EventPresenter;

/**
 * Created by Balaji on 31-12-2017.
 */

public interface EventView extends BaseView<EventPresenter>{
    void showNetworkError();
    void setAdapter(EventAdapter eventAdapter);
}
