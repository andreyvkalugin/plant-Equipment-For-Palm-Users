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

public class TodoFragment extends AbstractTabFragment {
    private static final int LAYOUT_fr = R.layout.zd_setting_list;
    private Context context;
    private View view;
    public static ZdAdapter pageAdapter;

    public static TodoFragment getInstance(Context context) {
        Bundle args = new Bundle();
        TodoFragment fragment = new TodoFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.menu_item_todo));
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT_fr, container, false);
        ListView listView = (ListView) view.findViewById (R.id.list);
        pageAdapter = new ZdAdapter(context, List_for_zd.zdPdfInfo);
        listView.setAdapter(pageAdapter);
        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
