package model.logic;

import java.util.Comparator;
import java.util.Date;

public class YoutubeVideo implements Comparable<YoutubeVideo> {

	private String video_id;
	private Date trending_date;
	private String title;
	private String channel_title;
	private int category_id;
	private String publish_time;
	private String[] tags;
	private int views;
	private int likes;
	private int dislikes;
	private int comment_count;
	private String thumbnail_link;
	private boolean comments_disabled;
	private boolean ratings_disabled;
	private boolean video_error_or_removed;
	private String descriptio;
	private String country;

	public YoutubeVideo(String video_id, String trending_date, String title, String channel_title, String category_id,
			String publish_time, String tags, String views, String likes, String dislikes, String comment_count,
			String thumbnail_link, String comments_disabled, String ratings_disabled, String video_error_or_removed,
			String descriptio, String country) {
		String[] trendDateRaw = trending_date.split("\\.");
		int year = Integer.parseInt("20" + trendDateRaw[0]);
		int month = Integer.parseInt(trendDateRaw[1]);
		int day = Integer.parseInt(trendDateRaw[2]);
		this.video_id = video_id;
		this.trending_date = new Date(year, month, day);
		this.title = title;
		this.channel_title = channel_title;
		this.category_id = Integer.parseInt(category_id);
		this.publish_time = publish_time;
		this.tags = tags.split("|");
		this.views = Integer.parseInt(views);
		this.likes = Integer.parseInt(likes);
		this.dislikes = Integer.parseInt(dislikes);
		this.comment_count = Integer.parseInt(comment_count);
		this.thumbnail_link = thumbnail_link;
		this.comments_disabled = Boolean.parseBoolean(comments_disabled);
		this.ratings_disabled = Boolean.parseBoolean(ratings_disabled);
		this.video_error_or_removed = Boolean.parseBoolean(video_error_or_removed);
		this.descriptio = descriptio;
		this.country = country;
	}

	@Override
	public int compareTo(YoutubeVideo video) {
		return this.trending_date.compareTo(video.trending_date);
	}

	/** Comparador alterno de 2 videos por número de likes */
	public static class ComparadorXLikes implements Comparator<YoutubeVideo> {

		/**
		 * Comparador alterno de acuerdo al número de likes
		 * 
		 * @return valor 0 si video1 y video2 tiene los mismos likes. valor negativo si
		 *         video1 tiene menos likes que video2. valor positivo si video1 tiene
		 *         más likes que video2.
		 */
		public int compare(YoutubeVideo video1, YoutubeVideo video2) {
			if (video1.likes > video2.likes) return 1;
			else if (video1.likes < video2.likes) return -1;
			else return 0;
		}
	}
	
	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}

	public Date getTrending_date() {
		return trending_date;
	}

	public void setTrending_date(Date trending_date) {
		this.trending_date = trending_date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getChannel_title() {
		return channel_title;
	}

	public void setChannel_title(String channel_title) {
		this.channel_title = channel_title;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getPublish_time() {
		return publish_time;
	}

	public void setPublish_time(String publish_time) {
		this.publish_time = publish_time;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getDislikes() {
		return dislikes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

	public int getComment_count() {
		return comment_count;
	}

	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}

	public String getThumbnail_link() {
		return thumbnail_link;
	}

	public void setThumbnail_link(String thumbnail_link) {
		this.thumbnail_link = thumbnail_link;
	}

	public boolean isComments_disabled() {
		return comments_disabled;
	}

	public void setComments_disabled(boolean comments_disabled) {
		this.comments_disabled = comments_disabled;
	}

	public boolean isRatings_disabled() {
		return ratings_disabled;
	}

	public void setRatings_disabled(boolean ratings_disabled) {
		this.ratings_disabled = ratings_disabled;
	}

	public boolean isVideo_error_or_removed() {
		return video_error_or_removed;
	}

	public void setVideo_error_or_removed(boolean video_error_or_removed) {
		this.video_error_or_removed = video_error_or_removed;
	}

	public String getDescriptio() {
		return descriptio;
	}

	public void setDescriptio(String descriptio) {
		this.descriptio = descriptio;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return video_id + title;
	}
}
