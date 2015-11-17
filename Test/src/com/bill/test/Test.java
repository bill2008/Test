package com.bill.test;

import java.util.ArrayList;
import java.util.List;

public class Test {

	private Integer peopleCount = 0;
	private Integer startIndex = 0;
	private Integer step = 1;
	List<Integer> peopleList = new ArrayList<Integer>(); 
	
	public Test(Integer peopleCount) {
		assert peopleCount>0;
		this.peopleCount = peopleCount;
	}
	private void initPeopleList() {
		for (Integer i=0;i<peopleCount;i++) {
			peopleList.add(i + 1);
		}
	}
	private Integer getNextIndex(Integer index) {
		Integer nextIndex = index + step;
		return getNextIndexForCount(nextIndex);
	}
	private Integer getNextIndexForCount(Integer index) {
		if (index < peopleList.size()) {
			return index;
		} else {
			return getNextIndexForCount(index % peopleList.size());
		}
	}
	
	public void deletePeople() {
		initPeopleList();
		Integer index = startIndex;
		while (peopleList.size() > 0) {
			index = getNextIndex(index);
			System.out.println(peopleList);
			System.out.println(peopleList.get(index));
			peopleList.remove((int)index);
		}
	}
	
	public static void main(String[] args) {
	
		Test test = new Test(13);
		test.setStartIndex(2);
		test.setStep(4);
		test.deletePeople();
	}

	public void setStartIndex(Integer startIndex) {
		assert startIndex>=0;
		this.startIndex = startIndex;
	}
	public void setStep(Integer step) {
		assert step>=1;
		this.step = step;
	}
}
