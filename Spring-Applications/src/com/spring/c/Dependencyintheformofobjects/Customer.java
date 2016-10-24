package com.spring.c.Dependencyintheformofobjects;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Customer {
	private List<Object> lists;
	private Map<Object, Object> maps;
	private Set<Object> sets;

	public List<Object> getLists() {
		return lists;
	}
	public void setLists(List<Object> lists) {
		this.lists = lists;
	}

	public Map<Object, Object> getMaps() {
		return maps;
	}
	public void setMaps(Map<Object, Object> maps) {
		this.maps = maps;
	}

	public Set<Object> getSets() {
		return sets;
	}
	public void setSets(Set<Object> sets) {
		this.sets = sets;
	}

	public String toString() {
		return " " + lists;
	}
}
