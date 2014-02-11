package lists;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class Adapter extends BaseAdapter
{ 
	private ArrayList<Items> listItems;
	
	public Adapter(Context context, ArrayList<Items> arrayList){
		listItems = arrayList;
	}

	@Override
	public int getCount(){
		return listItems.size();
	}

	@Override
	// get the data of an item from a specific position
	// it represents the position of the item in the list
	public Object getItem(int i){
		return listItems.get(i);
	}

	@Override
	// get the position id of the item from the list
	public long getItemId(int i){
		return 0;
	}

	@Override
	public View getView(int position, View view, ViewGroup viewGroup)
	{
		view = (ConcertItem)listItems.get(position);
		return view;
	}
}
