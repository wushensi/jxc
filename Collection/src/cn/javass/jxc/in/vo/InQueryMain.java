package cn.javass.jxc.in.vo;

public class InQueryMain extends InMain{
	private long inQueryDate;

	public long getInQueryDate() {
		return inQueryDate;
	}

	public void setInQueryDate(long inQueryDate) {
		this.inQueryDate = inQueryDate;
	}

	@Override
	public String toString() {
		return "InQueryMain [inQueryDate=" + inQueryDate + ", getId()="
				+ getId() + ", getInUserId()=" + getInUserId()
				+ ", getInDate()=" + getInDate() + "]";
	}
}
