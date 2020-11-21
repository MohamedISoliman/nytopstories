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
    private val onBookmarkClicked: (Story) -> Unit,
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
            holder.bind(getItem(position), onBookmarkClicked)
        }
    }


    class StoryViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        fun bind(
            story: Story,
            onBookmarkClicked: (Story) -> Unit,
        ) {

            itemView.textView.text = story.title
            itemView.bookmark.isChecked = story.id != null
            itemView.bookmark.setOnClickListener { onBookmarkClicked(story) }

            story.multimedia?.let {
                if (it.isNotEmpty())
                    itemView.imageView.loadImage(it[0].url)
                else
                    itemView.imageView.loadImage()
            }


        }

    }

}