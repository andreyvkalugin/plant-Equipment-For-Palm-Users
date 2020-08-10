package SQLite_Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.github.barteksc.sample.List_for_zd;
import com.github.barteksc.sample.PDFViewActivity;
import com.github.barteksc.sample.PDFViewActivity_;
import com.github.barteksc.sample.R;

import View_Adapter.Constants;
import View_Adapter.ViewAdapterActivity;

public class ZdAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private String[] zdSettingList;
    public EditText edit_item;
    public Context forToast;

    public ZdAdapter(Context context, String[] zdSettingList) {
        this.zdSettingList = zdSettingList;
        forToast = context;
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return zdSettingList.length;
    }

    @Override
    public Object getItem(int position) {
        return zdSettingList[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = layoutInflater.inflate(R.layout.item_layout, parent, false);
            holder.caption = (EditText) view.findViewById(R.id.edit_item);
            holder.btnToPdf = (Button) view.findViewById(R.id.btnPdf);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.caption.setText(List_for_zd.zdMyInfo[position]);
        holder.caption.setId(position);
        if (position == 2) {
            holder.btnToPdf.setVisibility(view.INVISIBLE);
        } else {
            holder.btnToPdf.setVisibility(view.VISIBLE);
        }
        holder.caption.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    final int position = v.getId();
                    final EditText Caption = (EditText) v;
                    List_for_zd.zdMyInfo[position] = Caption.getText().toString();
                }
            }
        });
        final String text = Integer.toString(position);

        /**switch (ViewAdapterActivity.CurrentTab){
           case Constants.TAB_ZD_LIST:
            holder.btnToPdf.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = forToast;
                    Toast.makeText(context, Integer.toString(position), Toast.LENGTH_SHORT).show();
                }
            });
            case Constants.TAB_PAGE_LIST:
                holder.btnToPdf.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //if (position == 0) {};
                        Context context = forToast;
                        Intent intent = new Intent(context, PDFViewActivity_.class);
                        PDFViewActivity.DymX = Integer.parseInt(List_for_zd.zdMyInfo[20]);
                        PDFViewActivity.DymY = Integer.parseInt(List_for_zd.zdMyInfo[21]);
                        context.startActivity(intent);
                    }
                });
        }**/





        holder.btnToPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = forToast;
                switch (ViewAdapterActivity.CurrentTab) {
                    case Constants.TAB_ZD_LIST:
                        Toast.makeText(context, Integer.toString(position), Toast.LENGTH_SHORT).show();
                        break;
                    case Constants.TAB_PAGE_LIST:
                        Intent intent = new Intent(context, PDFViewActivity_.class);
                        PDFViewActivity.DymX = Integer.parseInt(List_for_zd.zdMyInfo[20]);
                        PDFViewActivity.DymY = Integer.parseInt(List_for_zd.zdMyInfo[21]);
                        context.startActivity(intent);
                        break;
                }
            }
        });


        String item = (String) getItem(position);
        TextView set_item = (TextView) view.findViewById(R.id.set_item);
        set_item.setText(item);

        return view;
    }
    class ViewHolder{
        EditText caption;
        Button btnToPdf;
    }

    /**

    private LayoutInflater layoutInflater;
    private ArrayList<String> zdSettingList;

    public ZdAdapter(Context context, ArrayList<String> zdSettingList) {
        this.zdSettingList = zdSettingList;
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return zdSettingList.size();
    }

    @Override
    public Object getItem(int position) {
        return zdSettingList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       View view = convertView;
       if (view == null){
           view = layoutInflater.inflate(R.layout.item_layout, parent, false);
       }
         EditText edit_item = (EditText) view.findViewById(R.id.edit_item);
         List_for_zd2.zdMyInfo[position] = edit_item.getText().toString();

         String item = (String) getItem(position);
         TextView set_item = (TextView) view.findViewById(R.id.set_item);
         set_item.setText(item);

        return view;
    }

    private String getListItem (int position){
        return (String) getItem(position);
    }
*/
}
