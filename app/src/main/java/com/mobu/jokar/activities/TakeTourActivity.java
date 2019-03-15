package com.mobu.jokar.activities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mobu.jokar.R;

import butterknife.ButterKnife;

public class TakeTourActivity extends AppCompatActivity {

    private LinearLayout dotLayout;
    private TextView btnSkip;
    private ImageView left_nav;
    private ImageView right_nav;
    private int[] layouts;
    private boolean isSelectedLag=false;
    private String selectedLanguage="en";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_tour);
        ButterKnife.bind(this);

        final ViewPager viewPager = findViewById(R.id.viewPager);
        dotLayout = findViewById(R.id.viewDots);
        btnSkip = findViewById(R.id.textSkip);

        left_nav = findViewById(R.id.left_nav);
        right_nav = findViewById(R.id.right_nav);

        right_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
            }
        });

        left_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() -1, true);
            }
        });

       btnSkip.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               onSkip();
           }
       });
        // layouts of all welcome sliders
        // add few more layouts if you want
        layouts = new int[]{
                R.layout.slide_a_layout,
                R.layout.slide_b_layout,
                R.layout.slide_c_layout};

        //adding bottom dots
        addBottomDots(0);
        SectionPagerAdapter sectionPagerAdapter = new SectionPagerAdapter();
        viewPager.setAdapter(sectionPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
    }






    void onSkip() {
        //  startActivity(AddTicketActivity.getIntent(this, "3"));
        startActivity(TermsConditionActivity.getIntent(this,""));
        finish();
//        startActivity(MoreActivity.getIntent(this));
    }
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }
        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private void addBottomDots(int currentPage) {
        if(currentPage==0){
            left_nav.setVisibility(View.INVISIBLE);
        }else {
            left_nav.setVisibility(View.VISIBLE);

        }

        if(currentPage==2){
            right_nav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onSkip();
                }
            });

        }




        TextView[] dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("•"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    class SectionPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        SectionPagerAdapter() {

        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert layoutInflater != null;
            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);
            return view;
        }
        @Override
        public int getCount() {
            return layouts.length;
        }
        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}
