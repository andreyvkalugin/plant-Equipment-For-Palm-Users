package View_Adapter.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import View_Adapter.Adapter.RemindListAdapter;
import View_Adapter.ViewAdapterActivity;
import View_Adapter.dto.RemindDTO;
import com.github.barteksc.sample.R;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends AbstractTabFragment {
    private static final int LAYOUT_fr = R.layout.fragment_history;
    private Context context;
    private View view;
    public static ViewPager viewPager;

    public static HistoryFragment getInstance(Context context, ViewPager viewPager) {
        Bundle args = new Bundle();
        HistoryFragment fragment = new HistoryFragment();
        HistoryFragment.viewPager = viewPager;
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.menu_item_history));
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT_fr, container, false);
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycleView);
        rv.setLayoutManager(new LinearLayoutManager(context));
        rv.setAdapter(new RemindListAdapter(context, ViewAdapterActivity.listZdName, HistoryFragment.viewPager));

        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }

}
