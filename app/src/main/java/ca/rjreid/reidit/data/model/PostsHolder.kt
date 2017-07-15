package ca.rjreid.reidit.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PostsHolder(
        val kind: String,
        @SerializedName("data") val postsData: PostsData) : Parcelable {

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<PostsHolder> = object : Parcelable.Creator<PostsHolder> {
            override fun createFromParcel(source: Parcel): PostsHolder = PostsHolder(source)
            override fun newArray(size: Int): Array<PostsHolder?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            source.readString(),
            source.readParcelable<PostsData>(PostsData::class.java.classLoader)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(kind)
        dest.writeParcelable(postsData, 0)
    }
}
