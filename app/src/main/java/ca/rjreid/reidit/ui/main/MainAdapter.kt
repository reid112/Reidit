package ca.rjreid.reidit.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ca.rjreid.reidit.R
import ca.rjreid.reidit.data.model.Post
import ca.rjreid.reidit.data.model.PostHolder
import ca.rjreid.reidit.extensions.image
import kotlinx.android.synthetic.main.list_item_post.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    //region Variables
    private var postHolders: List<PostHolder>? = null
    //endregion

    //region Adapter Implementation
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.list_item_post, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindPost(postHolders?.get(position)?.post)
    }

    override fun getItemCount(): Int {
        return postHolders?.count() ?: 0
    }
    //endregion

    //region Commands
    fun updatePosts(postHolders: List<PostHolder>) {
        this.postHolders = postHolders
        notifyDataSetChanged()
    }

    fun clearPosts() {
        this.postHolders = null
        notifyDataSetChanged()
    }
    //endregion

    //region View Holder Inner Class
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindPost(post: Post?) {
            itemView.postThumbnail.image(post?.thumbnailUrl ?: "")
            itemView.postSubreddit.text = String.format(itemView.context.getString(R.string.label_subreddit), post?.subreddit)
            itemView.postTitle.text = post?.title
            itemView.postAuthor.text = post?.author
            itemView.postUpVotes.text = post?.ups?.toString()
            itemView.postDownVotes.text = post?.downs?.toString()
            itemView.postComments.text = post?.score?.toString()
        }
    }
    //endregion
}
