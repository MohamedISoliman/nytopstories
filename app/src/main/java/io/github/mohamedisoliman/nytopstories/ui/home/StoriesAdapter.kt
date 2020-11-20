package io.github.mohamedisoliman.nytopstories.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.github.mohamedisoliman.nytopstories.R
import io.github.mohamedisoliman.nytopstories.data.model.Story
import io.github.mohamedisoliman.nytopstories.ui.loadImage
import kotlinx.android.synthetic.main.item_story.view.*

class StoriesAdapter(
    private val onSave: (Story) -> Unit,
    private val onDelete: (Story) -> Unit,
) : ListAdapter<Story, RecyclerView.ViewHolder>(diffCallback) {


    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Story>() {
            override fun areItemsTheSame(oldItem: Story, newItem: Story) = oldItem == newItem
            override fun areContentsTheSame(oldItem: Story, newItem: Story) = oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_story, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is StoryViewHolder) {
            holder.bind(getItem(position), onSave, onDelete)
        }
    }


    class StoryViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        fun bind(
            story: Story,
            onSave: (Story) -> Unit,
            onDelete: (Story) -> Unit,
        ) {

            itemView.textView.text = story.title
//            if (itemView.bookmark.isChecked) {
//                itemView.bookmark.isChecked = false
//                onDelete(story)
//            } else {
//                itemView.bookmark.isChecked = true
//                onSave(story)
//            }

            story.multimedia?.let {
                if (it.isNotEmpty())
                    itemView.imageView.loadImage(it[0].url)
                else
                    itemView.imageView.loadImage()
            }


        }

    }

}