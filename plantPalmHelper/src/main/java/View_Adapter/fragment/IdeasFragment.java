package View_Adapter.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.github.barteksc.sample.List_for_zd;
import com.github.barteksc.sample.R;

import SQLite_Adapter.ZdAdapter;
import View_Adapter.Constants;

public class IdeasFragment extends AbstractTabFragment{
    private static final int LAYOUT_fr = R.layout.zd_setting_list;
    private Context context;
    private View view;
    public static ZdAdapter adapter;

    public static IdeasFragment getInstance(Context context) {
        Bundle args = new Bundle();
        IdeasFragment fragment = new IdeasFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.menu_item_ideas));
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT_fr, container, false);
        ListView listView = (ListView) view.findViewById (R.id.list);
        adapter = new ZdAdapter(context, List_for_zd.zdInfo);
        listView.setAdapter(adapter);
        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }

}
