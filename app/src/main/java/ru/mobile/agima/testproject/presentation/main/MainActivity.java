package ru.mobile.agima.testproject.presentation.main;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import com.rd.PageIndicatorView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.mobile.agima.testproject.R;

public class MainActivity extends MvpAppCompatActivity implements MainView {
    @InjectPresenter
            (type = PresenterType.GLOBAL)
    MainPresenter presenter;

    @BindView(R.id.pager)
    ViewPager galleryPager;

    @BindView(R.id.indicator)
    PageIndicatorView indicator;

    @BindView(R.id.title)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        galleryPager.addOnPageChangeListener(presenter.onPageChangeListener());
    }

    @Override
    public void updateGallery(GalleryAdapter adapter) {
        galleryPager.setAdapter(adapter);
        indicator.setCount(adapter.getCount());
    }

    @Override
    public void setTitleAlpha(float alpha) {
        title.setAlpha(alpha);
    }

    @Override
    public void setTitle(String text) {
        title.setText(text);
    }
}
