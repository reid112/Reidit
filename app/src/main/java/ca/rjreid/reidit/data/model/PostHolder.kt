package ca.rjreid.reidit.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PostHolder(
        val kind: String,
        @SerializedName("data") val post: Post) : Parcelable {

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<PostHolder> = object : Parcelable.Creator<PostHolder> {
            override fun createFromParcel(source: Parcel): PostHolder = PostHolder(source)
            override fun newArray(size: Int): Array<PostHolder?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            source.readString(),
            source.readParcelable<Post>(Post::class.java.classLoader)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(kind)
        dest.writeParcelable(post, 0)
    }
}