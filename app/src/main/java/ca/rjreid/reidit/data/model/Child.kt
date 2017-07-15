package ca.rjreid.reidit.data.model

import android.os.Parcel
import android.os.Parcelable

data class Child(
        val kind: String,
        val data: ChildData) : Parcelable {

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Child> = object : Parcelable.Creator<Child> {
            override fun createFromParcel(source: Parcel): Child = Child(source)
            override fun newArray(size: Int): Array<Child?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            source.readString(),
            source.readParcelable<ChildData>(ChildData::class.java.classLoader)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(kind)
        dest.writeParcelable(data, 0)
    }
}