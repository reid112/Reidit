package ca.rjreid.reidit.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PostsData(
        val modHash: String,
        @SerializedName("children") val postHolders: List<PostHolder>,
        val after: String?,
        val before: String?) : Parcelable {

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<PostsData> = object : Parcelable.Creator<PostsData> {
            override fun createFromParcel(source: Parcel): PostsData = PostsData(source)
            override fun newArray(size: Int): Array<PostsData?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            source.readString(),
            source.createTypedArrayList(PostHolder.CREATOR),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(modHash)
        dest.writeTypedList(postHolders)
        dest.writeString(after)
        dest.writeString(before)
    }
}