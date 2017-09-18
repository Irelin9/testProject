package ru.mobile.agima.testproject.presentation.main;


import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;


@StateStrategyType(AddToEndSingleStrategy.class)
public interface MainView extends MvpView {
    void updateGallery(GalleryAdapter adapter);

    void setTitleAlpha(float alpha);

    void setTitle(String text);
}
