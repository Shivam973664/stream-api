package test.deolitteusiOct;

public class UserRequest {
	private Long userId;
	public UserRequest(Long userId, Integer count) {
		super();
		this.userId = userId;
		this.count = count;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	private Integer count;
}
