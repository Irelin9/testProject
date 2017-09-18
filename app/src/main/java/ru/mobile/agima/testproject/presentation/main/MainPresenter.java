package ru.mobile.agima.testproject.presentation.main;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.List;

import ru.mobile.agima.testproject.App;
import ru.mobile.agima.testproject.R;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    private static final int default_res = -1;
    private static final double screen_centre = 0.5;

    private GalleryAdapter adapter;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadGallery();
    }

    private void loadGallery() {
        getViewState().onGalleryLoaded(getGalleryItemsFromResources());
    }

    public GalleryAdapter onSetAdapter(List<GalleryItem> items, Context context) {
        adapter = new GalleryAdapter(items, context);
        return adapter;
    }

    public ViewPager.OnPageChangeListener onPageChangeListener() {
        return new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                getViewState().setTitleAlpha(calculateAlpha(positionOffset));
                getViewState().setTitle(calculateTitle(positionOffset, position));
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
    }

    private float calculateAlpha(float positionOffset) {
        return (float) (2 * Math.abs(positionOffset - screen_centre));
    }

    private String calculateTitle(float positionOffset, int position) {
        return adapter.getItemTitle(positionOffset > screen_centre
                ? position + 1 : position);
    }

    private List<GalleryItem> getGalleryItemsFromResources() {
        List<GalleryItem> items = new ArrayList<>();
        TypedArray images = App.getContext().getResources().obtainTypedArray(R.array.gallery_res);
        TypedArray titles = App.getContext().getResources().obtainTypedArray(R.array.gallery_titles);
        for (int i = 0; i < images.length(); i++) {
            items.add(new GalleryItem(images.getResourceId(i, default_res), titles.getString(i)));
        }
        return items;
    }
}
