package com.safonov.speedreading.reader.repository.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class BookDescription implements Parcelable {
    public static final Parcelable.Creator<BookDescription> CREATOR = new Parcelable.Creator<BookDescription>() {
        public BookDescription createFromParcel(Parcel in) {
            return new BookDescription(in);
        }

        public BookDescription[] newArray(int size) {
            return new BookDescription[size];
        }
    };
    private String author;
    private long bookOffset;
    private String coverImagePath;
    private String filePath;

    /* renamed from: id */
    private long f107id;
    private boolean isFavorite;
    private String language;
    private int progress;
    private String title;
    private String type;

    public long getId() {
        return this.f107id;
    }

    public void setId(long id) {
        this.f107id = id;
    }

    public long getBookOffset() {
        return this.bookOffset;
    }

    public void setBookOffset(long bookOffset2) {
        this.bookOffset = bookOffset2;
    }

    public int getProgress() {
        return this.progress;
    }

    public void setProgress(int progress2) {
        this.progress = progress2;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title2) {
        this.title = title2;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author2) {
        this.author = author2;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language2) {
        this.language = language2;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type2) {
        this.type = type2;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String filePath2) {
        this.filePath = filePath2;
    }

    public boolean isFavorite() {
        return this.isFavorite;
    }

    public void setFavorite(boolean favorite) {
        this.isFavorite = favorite;
    }

    public String getCoverImagePath() {
        return this.coverImagePath;
    }

    public void setCoverImagePath(String coverImagePath2) {
        this.coverImagePath = coverImagePath2;
    }

    public BookDescription() {
    }

    protected BookDescription(Parcel in) {
        this.f107id = in.readLong();
        this.bookOffset = in.readLong();
        this.progress = in.readInt();
        this.title = in.readString();
        this.author = in.readString();
        this.language = in.readString();
        this.type = in.readString();
        this.filePath = in.readString();
        this.isFavorite = in.readByte() != 0;
        this.coverImagePath = in.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.f107id);
        dest.writeLong(this.bookOffset);
        dest.writeInt(this.progress);
        dest.writeString(this.title);
        dest.writeString(this.author);
        dest.writeString(this.language);
        dest.writeString(this.type);
        dest.writeString(this.filePath);
        dest.writeByte((byte) (this.isFavorite ? 1 : 0));
        dest.writeString(this.coverImagePath);
    }
}
