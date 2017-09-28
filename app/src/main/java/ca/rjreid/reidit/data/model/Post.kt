package ca.rjreid.reidit.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Post(
        val id: String,
        val name: String,
        val subreddit: String,
        @SerializedName("thumbnail") val thumbnailUrl: String,
        val downs: Int,
        val ups: Int,
        @SerializedName("num_comments") val numComments: Int,
        @SerializedName("created_utc") val createdUtc: Long,
        val title: String,
        val url: String,
        val permalink: String,
        val author: String,
        val score: Long) : Parcelable {

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Post> = object : Parcelable.Creator<Post> {
            override fun createFromParcel(source: Parcel): Post = Post(source)
            override fun newArray(size: Int): Array<Post?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readInt(),
            source.readInt(),
            source.readInt(),
            source.readLong(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readLong()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(id)
        dest.writeString(name)
        dest.writeString(subreddit)
        dest.writeString(thumbnailUrl)
        dest.writeInt(downs)
        dest.writeInt(ups)
        dest.writeInt(numComments)
        dest.writeLong(createdUtc)
        dest.writeString(title)
        dest.writeString(url)
        dest.writeString(permalink)
        dest.writeString(author)
        dest.writeLong(score)
    }
}
