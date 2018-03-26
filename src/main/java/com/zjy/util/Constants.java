/**
 * 
 */
package com.zjy.util;

/**
 * 常量类
 * 
 * @author Mervyn
 *
 */
public class Constants {
	//session名
	public static final String SESSION_USER = "session_user";
	
	//各实体编号随机数位数
	public static final int DEPARTMENT_NO_DIGITS = 3;
	public static final int DOCTOR_NO_DIGITS = 3;
	public static final int PATIENT_NO_DIGITS = 3;
	public static final int MEDICINE_NO_DIGITS = 3;
	public static final int REGISTRATION_NO_DIGITS = 6;
	
	//各实体编号前缀
	public static final String DEPARTMENT_NO_PREFIX = "D";
	public static final String MEDICINE_NO_PREFIX = "M";
	public static final String REGISTRATION_NO_PREFIX = "R";
	
	//是否删除：1-已删除；0-未删除
	public static final int DELETED = 1;
	public static final int NOT_DELETED = 0;
	
	//性别：1-男；0-女
	public static final int MALE = 1;
	public static final int FEMALE = 0;
	
	//医生类型：1-医生；0-管理员
	public static final int DOCTOR_TYPE = 1;
	public static final int ADMIN_TYPE = 0;
	
	//某日是否值班：1-是；0-否
	public static final int ON_DUTY = 1;
	public static final int NOT_ON_DUTY = 0;
	
	//预约挂号状态：0-取消；1-预约；2-就诊；3-未就诊；
	public static final int CANCEL_TYPE = 0;
	public static final int APPOINT_TYPE = 1;
	public static final int VISIT_TYPE = 2;
	public static final int UN_VISIT_TYPE = 3;
}
