package com.multiplex.model;

import java.util.Arrays;

public class Hall {
private int hallId;
private String hallName;
private String seatType;
private int standardNum;
private int goldNum;
private int premiumNum;
public int getStandardNum() {
	return standardNum;
}
public void setStandardNum(int standardNum) {
	this.standardNum = standardNum;
}
public int getGoldNum() {
	return goldNum;
}
public void setGoldNum(int goldNum) {
	this.goldNum = goldNum;
}
public int getPremiumNum() {
	return premiumNum;
}
public void setPremiumNum(int premiumNum) {
	this.premiumNum = premiumNum;
}
private static float standardFare=200;
private static float goldFare=300;
private static float premiumFare=500;
private static float mornFare=100;
private static float noonFare=50;
private static float nightFare=200;

public int getHallId() {
	return hallId;
}
public void setHallId(int hallId) {
	this.hallId = hallId;
}
public String getHallName() {
	return hallName;
}
public void setHallName(String hallName) {
	this.hallName = hallName;
}
public static float getStandardFare() {
	return standardFare;
}
public static float getGoldFare() {
	return goldFare;
}
public static float getPremiumFare() {
	return premiumFare;
}


public static float getMornFare() {
	return mornFare;
}

public static float getNoonFare() {
	return noonFare;
}

public static float getNightFare() {
	return nightFare;
}


public String getSeatType() {
	return seatType;
}
public void setSeatType(String seatType) {
	this.seatType = seatType;
}

}