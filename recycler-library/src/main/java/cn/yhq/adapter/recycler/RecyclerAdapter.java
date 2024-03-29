package cn.yhq.adapter.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by 杨慧强 on 2016/2/22.
 */
public abstract class RecyclerAdapter<VH extends ViewHolder> extends RecyclerView.Adapter<VH> {
  private OnRecyclerViewItemLongClickListener onRecyclerViewItemLongClickListener;
  private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;
  private static ViewHolderFactory<? extends ViewHolder> mViewHolderFactory = new ViewHolderFactoryImpl();

  @Override
  public final VH onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = onCreateView(parent, viewType);
    ViewHolder viewHolder = mViewHolderFactory.createViewHolder(itemView, viewType);
    viewHolder.setOnRecyclerViewItemClickListener(onRecyclerViewItemClickListener);
    viewHolder.setOnRecyclerViewItemLongClickListener(onRecyclerViewItemLongClickListener);
    return (VH) viewHolder;
  }

  public abstract View onCreateView(ViewGroup parent, int viewType);

  public void setOnRecyclerViewItemLongClickListener(
      OnRecyclerViewItemLongClickListener onRecyclerViewItemLongClickListener) {
    this.onRecyclerViewItemLongClickListener = onRecyclerViewItemLongClickListener;
  }

  public void setOnRecyclerViewItemClickListener(
      OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
    this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
  }

  public static <T extends ViewHolder> void setViewHolderFactory(ViewHolderFactory<T> factory) {
    mViewHolderFactory = factory;
  }

}
