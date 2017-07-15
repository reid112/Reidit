package ca.rjreid.reidit.data.model

import android.os.Parcel
import android.os.Parcelable

data class ResponseData(
        val modHash: String,
        val children: List<Child>,
        val after: String?,
        val before: String?) : Parcelable {

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<ResponseData> = object : Parcelable.Creator<ResponseData> {
            override fun createFromParcel(source: Parcel): ResponseData = ResponseData(source)
            override fun newArray(size: Int): Array<ResponseData?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            source.readString(),
            source.createTypedArrayList(Child.CREATOR),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(modHash)
        dest.writeTypedList(children)
        dest.writeString(after)
        dest.writeString(before)
    }
}