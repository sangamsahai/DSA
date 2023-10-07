package com.dsa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingScheduler {
	//https://dev.to/clarkngo/logic-explained-meeting-scheduler-leetcode-java-using-two-pointers-4881
	
	MeetingInstance[] firstPersonAvailability;
	MeetingInstance[] secondPersonAvailability;
	
	public MeetingScheduler(MeetingInstance[] firstPersonAvailability, MeetingInstance[] secondPersonAvailability) {
		this.firstPersonAvailability = firstPersonAvailability;
		this.secondPersonAvailability = secondPersonAvailability;
	}
	
	public MeetingInstance getFirstFreeSlot(int duration) {
		
		
		Arrays.sort(firstPersonAvailability);
		Arrays.sort(secondPersonAvailability);
		
		int firstPersonAvailabilityPointer = 0;
		int secondPersonAvailabilityPointer = 0;
		
		while(firstPersonAvailabilityPointer<firstPersonAvailability.length && secondPersonAvailabilityPointer<secondPersonAvailability.length) {
			MeetingInstance m1 = firstPersonAvailability[firstPersonAvailabilityPointer];
			MeetingInstance m2 = secondPersonAvailability[secondPersonAvailabilityPointer];
			
			if(findOverlap(m1,m2) >= duration) {
				if(m1.start == m2.start && m1.end == m2.end) {
					return new MeetingInstance(m1.start,m1.start+duration);
				}
				else if(m2.start > m1.start && m2.end < m1.end){
					return new MeetingInstance(m2.start,m2.start+duration);
				}
				else if(m2.end > m1.start && m2.start < m1.start){
					return new MeetingInstance(m1.start,m1.start+duration);
				}
				else {
					return new MeetingInstance(m2.start,m2.start+duration);
				}

			}
			else {
				if(m1.end < m2.end) {
					firstPersonAvailabilityPointer++;
				}
				else {
					secondPersonAvailabilityPointer++;
				}
			}
		}
		
		return null;
	}
	
	
//	public int distanceBetweenMeetings(MeetingInstance m1, MeetingInstance m2) {
//		int distance = -99;
//		if(m1.end < m2.start) {
//			distance = m2.start - m1.end;
//		}
//		else {
//			distance = m1.start - m2.end;
//		}
//		System.out.println("dist for "+m1+" and "+m2+" is "+distance);
//		return distance;
//	}
	
	public int findOverlap(MeetingInstance m1, MeetingInstance m2) {
		int overlap = 0;
		if(m2.end>=m1.start && m2.start<=m1.end) { //overlap
			//return Math.max(m2.end, m1.start) - Math.min(m2.end, m1.start);
			if(m2.start >= m1.start && m2.end <= m1.end){
				overlap = m1.end-m1.start;
			}
			else if(m2.end > m1.start && m2.start < m1.start){
				overlap = m2.end-m1.start;
			}
			else if(m2.end > m1.end && m2.start < m1.end){
				overlap = m1.end-m2.start;
			}	
		}
		System.out.println("Overlap for "+m1+m2+"is"+overlap);
		return overlap;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MeetingInstance[] firstPersonAvailability = new MeetingInstance[] {
				new MeetingInstance(0,2),
				new MeetingInstance(7,8),
				new MeetingInstance(3,5),
		};
		MeetingInstance[] secondPersonAvailability = new MeetingInstance[] {
				new MeetingInstance(1,3),
				new MeetingInstance(4,5),
				new MeetingInstance(3,6),
		};
		
		MeetingScheduler ms = new MeetingScheduler(firstPersonAvailability, secondPersonAvailability);
		System.out.println("Slot is" + ms.getFirstFreeSlot(2));
	}
}

class MeetingInstance implements Comparable<MeetingInstance>{
	int start;
	int end;
	public MeetingInstance(int start, int end) {
		this.start = start;
		this.end = end;
	}
	@Override
	public int compareTo(MeetingInstance o) {
		// TODO Auto-generated method stub
		return this.start-o.start;
	}
	
	@Override
	public String toString() {
	return "["+	start +","+ end+"]";
	}
	
}
