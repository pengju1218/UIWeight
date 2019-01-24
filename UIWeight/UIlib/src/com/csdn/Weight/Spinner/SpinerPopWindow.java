package com.csdn.Weight.Spinner;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.csdn.Weight.R;



public class SpinerPopWindow<T> extends PopupWindow {
	private LayoutInflater inflater;
	private ListView mListView;
	private List<T> list;
	private MyAdapter  mAdapter;
	
	private Context context;
	public SpinerPopWindow(Context context,List<T> list,OnItemClickListener clickListener) {
		super(context);
		this.context=context;
		inflater=LayoutInflater.from(context);
		this.list=list;
		init(clickListener);
	}
	
	private void init(OnItemClickListener clickListener){
		View view = inflater.inflate(R.layout.spiner_window_layout, null);
		setContentView(view);		
		setWidth(LayoutParams.WRAP_CONTENT);
		setHeight(LayoutParams.WRAP_CONTENT);
		setFocusable(true);
    		ColorDrawable dw = new ColorDrawable(0x00);
		setBackgroundDrawable(dw);
		mListView = (ListView) view.findViewById(R.id.listview);
		mListView.setAdapter(mAdapter=new MyAdapter());
		mListView.setOnItemClickListener(clickListener);
		this.setOnDismissListener(dismissListener);
	}
	
	private class MyAdapter extends BaseAdapter{
		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder=null;
			if(convertView==null){
				holder=new ViewHolder();
				convertView=inflater.inflate(R.layout.spiner_item_layout, null);
				holder.tvName=(TextView) convertView.findViewById(R.id.tv_name);
				convertView.setTag(holder);
			}else{
				holder=(ViewHolder) convertView.getTag();
			}
			holder.tvName.setText(getItem(position).toString());
			return convertView;
		}
	}
	
	private class ViewHolder{
		private TextView tvName;
	}
	
	private TextView tvValue;
	
	public void show(TextView tvValue){
		this.tvValue=tvValue;
		this.setWidth(tvValue.getWidth());
		this.showAsDropDown(tvValue);
		setTextImage(R.drawable.icon_up, tvValue);
	
	}
	
	private OnDismissListener  dismissListener=new OnDismissListener() {
		@Override
		public void onDismiss() {
			if(tvValue!=null){
				setTextImage(R.drawable.icon_down,tvValue);
			}
		}
	};
	
	/**
	 * ��TextView�ұ�����ͼƬ
	 * @param resId
	 */
	private void setTextImage(int resId,TextView text) {
		Drawable drawable = context.getResources().getDrawable(resId);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(),drawable.getMinimumHeight());// ��������ͼƬ��С��������ʾ
		text.setCompoundDrawables(null, null, drawable, null);
	}
	
}
