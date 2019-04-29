package hibernate;

import java.io.Serializable;

import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentityGenerator;

public class Mygenerator extends IdentityGenerator {

	
	@Override
	public Serializable generate(SessionImplementor s, Object obj) {
		
		return super.generate(s, obj);
	}
}
