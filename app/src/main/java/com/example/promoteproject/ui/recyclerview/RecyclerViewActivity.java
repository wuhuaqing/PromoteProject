package com.example.promoteproject.ui.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import com.example.promoteproject.R;

/***
 *  Recyclerview 内容
 *  1.基本使用 adapter/viewholder/layoutmanager
 *  2.左右滑动 item
 *  3.LayoutManager https://github.com/DingMouRen/LayoutManagerGroup
 *  4.setHasStableIds
 *  5.添加头尾/itemDecoration/itemanimation
 *  5.SnapHelper  https://github.com/zhimaochen/SnapHelperDemo
 *  6.DiffUtil
 *  7.嵌套滑动 NestedScrollingParent2  NestedScrollingChild2
 */

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        if(savedInstanceState == null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            ItemFragment itemFragment = new ItemFragment();
            fragmentTransaction.replace(R.id.layout_fragment,itemFragment);
            fragmentTransaction.commit();
        }
    }
}