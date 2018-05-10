/**
 * 
 */
package com.zjy.scheduled;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zjy.dao.DutyMapper;
import com.zjy.entity.Duty;
import com.zjy.util.Constants;

/**
 * 定时任务
 * @author Mervyn
 *
 */
@Component
public class ScheduledTask {
	
	@Autowired
	DutyMapper dutyMapper;
	
	/**
	 * 每天将值班表中前一天有值班的医生的剩余挂号数更新为最大可预约挂号数
	 * @author Mervyn
	 *
	 */
	@Scheduled(cron = "0 0 0 * * ? ")//每天0点执行
	public void resetDutyTable() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		Duty duty = new Duty();
		switch (dayOfWeek) {
		case 1:
			duty.setSaturdayRest(Constants.MAX_APPOINTMENT);
			break;
		case 2:
			duty.setSundayRest(Constants.MAX_APPOINTMENT);
			break;
		case 3:
			duty.setMondayRest(Constants.MAX_APPOINTMENT);
			break;
		case 4:
			duty.setTuesdayRest(Constants.MAX_APPOINTMENT);
			break;
		case 5:
			duty.setWednesdayRest(Constants.MAX_APPOINTMENT);
			break;
		case 6:
			duty.setThursdayRest(Constants.MAX_APPOINTMENT);
			break;
		case 7:
			duty.setFridayRest(Constants.MAX_APPOINTMENT);
			break;
		}
		System.out.println(dutyMapper.updateDuty(duty));
	} 
}
