package dto;

public class Rest_photo_table {
	private int rest_review_no; 
	private int rest_photo_no;
	private String photo_ori_name;
	private String photo_chan_name;
	
	@Override
	public String toString() {
		return "Rest_photo_table [rest_review_no=" + rest_review_no + ", rest_photo_no=" + rest_photo_no
				+ ", photo_ori_name=" + photo_ori_name + ", photo_chan_name=" + photo_chan_name + "]";
	}
	
	public int getRest_review_no() {
		return rest_review_no;
	}
	public void setRest_review_no(int rest_review_no) {
		this.rest_review_no = rest_review_no;
	}
	public int getRest_photo_no() {
		return rest_photo_no;
	}
	public void setRest_photo_no(int rest_photo_no) {
		this.rest_photo_no = rest_photo_no;
	}
	public String getPhoto_ori_name() {
		return photo_ori_name;
	}
	public void setPhoto_ori_name(String photo_ori_name) {
		this.photo_ori_name = photo_ori_name;
	}
	public String getPhoto_chan_name() {
		return photo_chan_name;
	}
	public void setPhoto_chan_name(String photo_chan_name) {
		this.photo_chan_name = photo_chan_name;
	}
}
