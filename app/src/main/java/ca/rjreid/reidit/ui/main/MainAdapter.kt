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

class MainAdapter(
        val postClick: (Post) -> Unit,
        val upVoteClick: (Post) -> Unit,
        val downVoteClick: (Post) -> Unit,
        val commentsClick: (Post) -> Unit) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    //region Variables
    private var postHolders = mutableListOf<PostHolder>()
    //endregion

    //region Adapter Implementation
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.list_item_post, parent, false)
        return ViewHolder(view, postClick, upVoteClick, downVoteClick, commentsClick)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindPost(postHolders[position].post)
    }

    override fun getItemCount(): Int {
        return postHolders.count()
    }
    //endregion

    //region Commands
    fun replacePosts(postHolders: List<PostHolder>) {
        clearPosts()
        appendNewPosts(postHolders)
    }

    fun appendNewPosts(postHolders: List<PostHolder>) {
        this.postHolders.addAll(postHolders)
        notifyDataSetChanged()
    }

    fun clearPosts() {
        this.postHolders.clear()
        notifyDataSetChanged()
    }
    //endregion

    //region View Holder Inner Class
    class ViewHolder(
            view: View,
            val postClick: (Post) -> Unit,
            val upVoteClick: (Post) -> Unit,
            val downVoteClick: (Post) -> Unit,
            val commentsClick: (Post) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bindPost(post: Post) {
            with(post) {
                itemView.postThumbnail.image(thumbnailUrl ?: "")
                itemView.postSubreddit.text = String.format(itemView.context.getString(R.string.label_subreddit), subreddit)
                itemView.postTitle.text = title
                itemView.postAuthor.text = author
                itemView.postUpVotes.text = ups.toString()
                itemView.postDownVotes.text = downs.toString()
                itemView.postComments.text = numComments.toString()

                itemView.setOnClickListener { postClick(this) }
                itemView.postUpVotes.setOnClickListener { upVoteClick(this) }
                itemView.postDownVotes.setOnClickListener { downVoteClick(this) }
                itemView.postComments.setOnClickListener { commentsClick(this) }
            }
        }
    }
    //endregion
}
