package com.gloomy.fastfood.ui.views.main.topic;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.gloomy.fastfood.R;
import com.gloomy.fastfood.ui.BaseFragment;
import com.gloomy.fastfood.ui.presenters.main.topic.TopicPresenter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Copyright © 2017 Gloomy
 * Created by HungTQB on 27-Mar-17.
 */
@EFragment(R.layout.fragment_post)
public class PostFragment extends BaseFragment implements IViewPost {

    @ViewById(R.id.viewPager)
    ViewPager mViewPager;

    @ViewById(R.id.tabLayout)
    TabLayout mTabLayout;

    @Bean
    TopicPresenter mPresenter;

    @AfterViews
    void afterViews() {
        mPresenter.setView(this);
        mPresenter.initViewPager(mViewPager, mTabLayout, getChildFragmentManager());
    }

    @Click(R.id.btnPost)
    void onPostClick() {
        mPresenter.onPostClick();
    }
}
