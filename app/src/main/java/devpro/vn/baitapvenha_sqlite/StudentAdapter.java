package devpro.vn.baitapvenha_sqlite;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nguye on 5/11/2018.
 */

public class StudentAdapter  extends  RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<StudentModel> studentModels;

    public StudentAdapter(Context mContext, ArrayList<StudentModel> studentModels) {
        this.mContext = mContext;
        this.studentModels = studentModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.item_student, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        StudentModel model = studentModels.get(position);
        holder.tvId.setText(model.getId());
        holder.tvName.setText(model.getName());
        holder.tvOld.setText(model.getOld());
        holder.tvAddrres.setText(model.getAdd());


    }

    @Override
    public int getItemCount() {
        return studentModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvId;
        TextView tvName;
        TextView tvOld;
        TextView tvAddrres;


        public ViewHolder(View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvID);
            tvName = itemView.findViewById(R.id.tvName);
            tvOld = itemView.findViewById(R.id.tvOld);
            tvAddrres = itemView.findViewById(R.id.tvAddrres);}

    }
}



