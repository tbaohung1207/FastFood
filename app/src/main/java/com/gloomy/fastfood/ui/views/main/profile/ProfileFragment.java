package com.gloomy.fastfood.ui.views.main.profile;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.widget.ImageView;
import android.widget.TextView;

import com.gloomy.fastfood.R;
import com.gloomy.fastfood.ui.BaseFragment;
import com.gloomy.fastfood.ui.presenters.main.profile.ProfilePresenter;
import com.gloomy.fastfood.widgets.HeaderBar;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.DimensionPixelOffsetRes;

import de.hdodenhof.circleimageview.CircleImageView;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import jp.wasabeef.picasso.transformations.GrayscaleTransformation;

/**
 * Copyright © 2017 Gloomy
 * Created by HungTQB on 27-Mar-17.
 */
@EFragment(R.layout.fragment_profile)
public class ProfileFragment extends BaseFragment implements IViewProfile {

    @Bean
    ProfilePresenter mPresenter;

    @ViewById(R.id.imgBackground)
    ImageView mImgBackground;

    @ViewById(R.id.imgAvatar)
    CircleImageView mImgAvatar;

    @ViewById(R.id.tvUsername)
    TextView mTvUserName;

    @ViewById(R.id.tvFullName)
    TextView mTvFullName;

    @ViewById(R.id.headerBar)
    HeaderBar mHeaderBar;

    @ViewById(R.id.viewPager)
    ViewPager mViewPager;

    @DimensionPixelOffsetRes(R.dimen.fragment_profile_avatar_size)
    int mAvatarSize;

    @ViewById(R.id.btnFollow)
    FloatingActionButton mBtnFollow;

    @ViewById(R.id.tabLayout)
    TabLayout mTabLayout;

    @ViewById(R.id.scrollView)
    NestedScrollView mNestedScrollView;

    @AfterViews
    void afterViews() {
        mPresenter.setView(this);
        mPresenter.initHeaderBar(mHeaderBar);
        mPresenter.getProfileData();
        mPresenter.initViewPager(mViewPager, mTabLayout, getChildFragmentManager());
        mNestedScrollView.setFillViewport(true);
    }

    @Override
    public void setUsername(String username) {
        mTvUserName.setText(username);
    }

    @Override
    public void setFullName(String fullName) {
        mTvFullName.setText(fullName);
    }

    @Override
    public void setAvatar(String avatar) {
        Picasso.with(getActivity())
                .load(avatar)
                .transform(new CropCircleTransformation())
                .resize(mAvatarSize, mAvatarSize)
                .into(mImgAvatar);
    }

    @Override
    public void setAvatar(int resId) {
        Picasso.with(getActivity())
                .load(resId)
                .resize(mAvatarSize, mAvatarSize)
                .transform(new CropCircleTransformation())
                .into(mImgAvatar);
    }

    @Override
    public void setImageBackground(String avatar) {
        Picasso.with(getActivity())
                .load(avatar)
                .into(mImgBackground);
    }

    @Override
    public void setImageBackground(int resId) {
        Picasso.with(getActivity())
                .load(resId)
                .transform(new GrayscaleTransformation())
                .into(mImgBackground);
    }

    @Click(R.id.btnFollow)
    void onFollowClick() {
        mPresenter.onFollowClick(mBtnFollow);
    }
}
