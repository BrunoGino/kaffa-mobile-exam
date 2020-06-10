package br.com.simpletodolist.ui.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.simpletodolist.model.Task;
import br.com.simpletodolist.databinding.ItemListBinding;
import br.com.simpletodolist.ui.databinding.ObservableTask;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private final List<Task> tasks = new ArrayList<>();
    private final Context context;
    private final OnItemClickListener onItemClickListener;
    private ItemListBinding itemListBinding;

    public ListAdapter(Context context, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemListBinding = ItemListBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(itemListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        itemListBinding.setLifecycleOwner(holder);
        Task task = tasks.get(position);
        holder.doMatch(task);
    }

    @Override
    public void onViewAttachedToWindow(@NonNull ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.markAsActive();
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.markAsDestroyed();
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    @Override
    public long getItemId(int position) {
        return tasks.get(position).getTaskId();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, LifecycleOwner {
        private Task task;
        private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

        ViewHolder(ItemListBinding binder) {
            super(binder.getRoot());
            lifecycleRegistry.setCurrentState(Lifecycle.State.INITIALIZED);
            itemListBinding.setItemClick(this);
        }

        private void markAsActive() {
            lifecycleRegistry.setCurrentState(Lifecycle.State.STARTED);
        }

        private void markAsDestroyed() {
            lifecycleRegistry.setCurrentState(Lifecycle.State.DESTROYED);
        }

        void doMatch(Task task) {
            this.task = task;
            ObservableTask observableTask = new ObservableTask(this.task);
            observableTask.update(this.task);
            itemListBinding.setTask(observableTask);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(task);
        }

        @NonNull
        @Override
        public Lifecycle getLifecycle() {
            return lifecycleRegistry;
        }
    }

    public void addAll(List<Task> tasks) {
        this.tasks.clear();
        notifyItemRangeRemoved(0, this.tasks.size());
        this.tasks.addAll(tasks);
        notifyItemRangeInserted(0, this.tasks.size());
    }

    public interface OnItemClickListener {
        void onItemClick(Task task);
    }

}
