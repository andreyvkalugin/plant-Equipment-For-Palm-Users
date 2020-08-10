package View_Adapter.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.sample.Entry_Activity;
import com.github.barteksc.sample.List_for_zd;
import com.github.barteksc.sample.R;

import java.util.List;

import SQLite_Adapter.Zd;
import View_Adapter.Constants;
import View_Adapter.dto.RemindDTO;
import View_Adapter.fragment.IdeasFragment;

public class RemindListAdapter extends RecyclerView.Adapter<RemindListAdapter.RemindViewHolder>{
   private List<RemindDTO> data;
   public Context forToast;
   public String zdName;
   public ViewPager viewPager;

    public RemindListAdapter(Context context, List<RemindDTO> data, ViewPager viewPager) {
        this.forToast = context;
        this.data = data;
        this.viewPager = viewPager;
    }

    @NonNull
    @Override
    public RemindViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.remind_item, parent, false);
        return new RemindViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RemindViewHolder holder, int position) {
        holder.num = position;
        RemindDTO item = data.get(position);
        holder.title.setText(item.getTitle());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = forToast;
                Toast.makeText(context, data.get(holder.num).getTitle(), Toast.LENGTH_SHORT).show();
                chooseZd(data.get(holder.num).getTitle());
            }
        });
    }

    private void chooseZd(String title) {
        zdName = title;
        Thread w = new Thread(new Runnable() {
            @Override
            public void run() {
                Zd zd = Entry_Activity.db.getZd(zdName);

                List_for_zd.zdMyInfo[0]=zd.get_zd_name();
                List_for_zd.zdMyInfo[1]=zd.get_zd_location();
                List_for_zd.zdMyInfo[2]=zd.get_zd_blok_number();
                List_for_zd.zdMyInfo[3]=zd.get_sa_name();
                List_for_zd.zdMyInfo[4]=zd.get_uso_name();
                List_for_zd.zdMyInfo[5]=zd.get_CI_number();
                List_for_zd.zdMyInfo[6]=zd.get_zd_hod();
                List_for_zd.zdMyInfo[7]=zd.get_zd_modbus_speed();
                List_for_zd.zdMyInfo[8]=zd.get_zd_modbus_number();
                List_for_zd.zdMyInfo[9]=zd.get_zd_modbus_setting();
                List_for_zd.zdMyInfo[10]=zd.get_zd_max_torque();
                List_for_zd.zdMyInfo[11]=zd.get_zd_torque_for_close();
                List_for_zd.zdMyInfo[12]=zd.get_zd_torque_for_start_open();
                List_for_zd.zdMyInfo[13]=zd.get_zd_torque_for_open();
                List_for_zd.zdMyInfo[14]=zd.get_zd_torque_for_start_close();
                List_for_zd.zdMyInfo[15]=zd.get_zd_type();
                List_for_zd.zdMyInfo[16]=zd.get_zd_time_to_sleep();
                List_for_zd.zdMyInfo[17]=zd.get_zd_discrete_command();
                List_for_zd.zdMyInfo[18]=zd.get_zd_open_position();
                List_for_zd.zdMyInfo[19]=zd.get_zd_close_position();
                List_for_zd.zdMyInfo[20]=zd.get_zd_dimens_x();
                List_for_zd.zdMyInfo[21]=zd.get_zd_dimens_y();
                List_for_zd.zdMyInfo[22]=zd.get_zd_pdf_main();
                List_for_zd.zdMyInfo[23]=zd.get_zd_pdf_uso();
                List_for_zd.zdMyInfo[24]=zd.get_zd_pdf_main_page();
                List_for_zd.zdMyInfo[25]=zd.get_zd_pdf_uso_page();
                List_for_zd.zdMyInfo[26]=zd.get_zd_redundant();
                List_for_zd.zdMyInfo[27]=zd.get_zd_redundant_2();
            }
        });
        w.start();
        IdeasFragment.adapter.notifyDataSetChanged();
        viewPager.setCurrentItem(Constants.TAB_ZD_LIST);
    }

    @Override
    public void onViewAttachedToWindow(RemindViewHolder holder) {
        super.onViewAttachedToWindow(holder);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class RemindViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView title;
        Integer num = 0;

        public RemindViewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.title);
            cardView = (CardView)itemView.findViewById(R.id.cardView);
        }
    }

}
