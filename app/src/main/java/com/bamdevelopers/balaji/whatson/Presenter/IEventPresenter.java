package com.bamdevelopers.balaji.whatson.Presenter;

import com.bamdevelopers.balaji.whatson.Model.Event;

/**
 * Created by Balaji on 31-12-2017.
 */

public interface IEventPresenter extends BasePresenter{
    void onAddItemClicked();

    void reloadData();

    void onItemClicked(Event event);

    void onAboutClicked();
}
