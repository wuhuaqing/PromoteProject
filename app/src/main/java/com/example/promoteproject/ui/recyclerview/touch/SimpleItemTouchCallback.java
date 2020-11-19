package com.example.promoteproject.ui.recyclerview.touch;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.promoteproject.ui.recyclerview.MyItemRecyclerViewAdapter;

import java.util.Collections;
import java.util.List;

/**
 * description ： TODO:简单的拖动与滑动删除 效果
 * author : 姓名
 * date : 2020/11/12 16:57
 *
 *             ItemTouchHelper helper =  new ItemTouchHelper(new SimpleItemTouchCallback<>(berthAdapter,berthDataList));
 *             helper.attachToRecyclerView(rvComment);
 */
public class SimpleItemTouchCallback<T> extends ItemTouchHelper.Callback  {

    private MyItemRecyclerViewAdapter mRecycleViewAdapter;
    private List<T> mDatas ;

    public SimpleItemTouchCallback(MyItemRecyclerViewAdapter adapter, List<T> data) {
        this.mRecycleViewAdapter =  adapter;
        this.mDatas =  data;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        int dragFlag = ItemTouchHelper.UP |ItemTouchHelper.DOWN;
        int swipeFlag =  ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(dragFlag,swipeFlag);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
        int fromPosition = viewHolder.getAdapterPosition();
        int toPosition = viewHolder1.getAdapterPosition();
        Collections.swap(mDatas,fromPosition,toPosition);
        mRecycleViewAdapter.notifyItemMoved(fromPosition,toPosition);
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int needSwipePosition = viewHolder.getAdapterPosition();
        mDatas.remove(needSwipePosition);
        mRecycleViewAdapter.notifyItemRemoved(needSwipePosition);

    }

    @Override
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
        if(actionState != ItemTouchHelper.ACTION_STATE_IDLE){
            MyItemRecyclerViewAdapter.ViewHolder vH = (MyItemRecyclerViewAdapter.ViewHolder) viewHolder;
            vH.itemView.setBackgroundColor(0xffbcbcbc);
        }
    }

    @Override
    public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        MyItemRecyclerViewAdapter.ViewHolder vH = (MyItemRecyclerViewAdapter.ViewHolder) viewHolder;
        vH.itemView.setBackgroundColor(0xffeeeeee);
    }
}
