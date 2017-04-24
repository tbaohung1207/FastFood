package com.gloomy.fastfood.mvp.views.main.rating.people;

import com.gloomy.fastfood.models.User;
import com.gloomy.fastfood.mvp.IBaseView;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by HungTQB on 17/04/2017.
 */
public interface IRatingPeopleView extends IBaseView {
    void onLoadDataComplete();

    void onLoadMoreComplete();

    void onLoadDataFailure();

    void onItemPeopleClick(User user);
}