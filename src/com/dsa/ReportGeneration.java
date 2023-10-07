package com.dsa;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;

public class ReportGeneration {
	
	
	TreeSet monthlyReportSchedule;
	TreeSet quarterlyReportSchedule;
	
	public ReportGeneration(TreeSet monthlyReportSchedule, TreeSet quarterlyReportSchedule) {
		this.monthlyReportSchedule = monthlyReportSchedule;
		this.quarterlyReportSchedule = quarterlyReportSchedule;
	}
	
	public Date getNextMonthlyReportDate(Date d)  {	
		Iterator<Date> it= monthlyReportSchedule.iterator();
		while(it.hasNext()) {
			Date temp = it.next();
			if(temp.after(d)) {
				return getNextBusinessDate(temp); 
			}
		}
		return null;
	}
	
	public Date getNextQuarterlyReportDate(Date d)  {
		
		Iterator<Date> it= quarterlyReportSchedule.iterator();
		while(it.hasNext()) {
			Date temp = it.next();
			if(temp.after(d)) {
				return getNextBusinessDate(temp);
			}
		}
		return null;
	}
	
	public Date getNextBusinessDate(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		if(d.getDay()==0) {//SUNDAY
			c.add(Calendar.DATE, 1);
			return c.getTime();
		}
		else if(d.getDay()==6) {//SATURDAY
			c.add(Calendar.DATE, 2);
			return c.getTime();
		}
		else {
			return d;
		}
	}
	
	

	public static void main(String[] args) {
		
		//Setting up data
		TreeSet quarterlyReportSchedule = new TreeSet<Date>();
		quarterlyReportSchedule.add(new Date(2023, 2, 15));//Using year, month, day
		quarterlyReportSchedule.add(new Date(2023, 5, 15));
		quarterlyReportSchedule.add(new Date(2023, 8, 15));
		quarterlyReportSchedule.add(new Date(2023, 11, 15));
//		
//		Iterator<Date> it= quarterlyReportSchedule.iterator();
//		while(it.hasNext()) {
//			System.out.println("\n\n Value is "+it.next().toString());
//		}
//		
        
        TreeSet monthlyReportSchedule = new TreeSet<Date>();
		for(int i=0;i<=11;i++) {
			monthlyReportSchedule.add(new Date(2023, i, 17));
		}
		
		ReportGeneration rg = new ReportGeneration(monthlyReportSchedule, quarterlyReportSchedule);
		
		System.out.println(rg.getNextQuarterlyReportDate(new Date(2023, 7, 16)).toString());
		
		//System.out.println(rg.getNextMonthlyReportDate(new Date(2023, 7, 16)).toString());

	}

}
