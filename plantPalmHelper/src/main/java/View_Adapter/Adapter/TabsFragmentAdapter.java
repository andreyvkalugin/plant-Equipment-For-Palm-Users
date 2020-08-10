package View_Adapter.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import View_Adapter.fragment.AbstractTabFragment;
import View_Adapter.fragment.BirthdayFragment;
import View_Adapter.fragment.HistoryFragment;
import View_Adapter.fragment.IdeasFragment;
import View_Adapter.fragment.TodoFragment;

import java.util.HashMap;
import java.util.Map;

public class TabsFragmentAdapter extends FragmentPagerAdapter {
    private Map<Integer, AbstractTabFragment> tabs;
    Context context;

    public TabsFragmentAdapter(Context context, FragmentManager fm, ViewPager viewPager) {
        super(fm);
        this.context = context;
        initTabsMap(context, viewPager);
    }

    private void initTabsMap(Context context, ViewPager viewPager) {
        tabs = new HashMap<>();
        tabs.put(0, HistoryFragment.getInstance(context, viewPager));
        tabs.put(1, IdeasFragment.getInstance(context));
        tabs.put(2, TodoFragment.getInstance(context));
        tabs.put(3, BirthdayFragment.getInstance(context));
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
        }

    @Override
    public int getCount() {
        return tabs.size();
    }
}
