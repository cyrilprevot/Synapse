package fr.synapsegaming.stats.entity;

import org.hibernate.annotations.Entity;

@Entity
public class Stats<T> {

	private long id;
	
	private long nb;
	
	private T object;
	
	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public long getNb() {
        return nb;
    }

    public void setNb(long nb) {
        this.nb = nb;
    }

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}
    
    
}
