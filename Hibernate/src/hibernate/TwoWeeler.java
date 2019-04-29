package hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2wh")
public class TwoWeeler extends Vehicle {

	
	public String getHandleBar() {
		return handleBar;
	}

	public void setHandleBar(String handleBar) {
		this.handleBar = handleBar;
	}

	private String handleBar;
}
