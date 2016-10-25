package fi.sjs.domore.bean;

public class TapahtumaOsallistuja {
	private int tapId;
	private int kaytId;
	
	public TapahtumaOsallistuja() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TapahtumaOsallistuja(int tap_id, int kayt_id) {
		super();
		this.tapId = tap_id;
		this.kaytId = kayt_id;
	}

	public int getTap_id() {
		return tapId;
	}

	public void setTapId(int tapId) {
		this.tapId = tapId;
	}

	public int getKaytId() {
		return kaytId;
	}

	public void setKaytId(int kaytId) {
		this.kaytId = kaytId;
	}

	@Override
	public String toString() {
		return "TapahtumaOsallistuja [tap_id=" + tapId + ", kayt_id="
				+ kaytId + "]";
	}
	
	

}
