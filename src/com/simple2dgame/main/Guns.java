package com.simple2dgame.main;
import java.awt.Color;

public class Guns {
		
	public int bulletSpeed, bulletWidth, bulletHeight, damage;
	public Color color;
	
	public Guns (int bulletSpeed, int bulletWidth, int bulletHeight, int damage, Color color) {
		
		this.bulletSpeed = bulletSpeed;
		this.bulletWidth = bulletWidth;
		this.bulletHeight = bulletHeight;
		this.damage = damage;
		this.color = color;
		
	}
	
	//getter 
	
	public int getBulletSpeed(){
		return bulletSpeed;
		
	}
	
	public int getBulletWidth() {
		return bulletWidth;
	}
	
	public int getBulletHeight() {
		return bulletHeight;
	}
	
	public Color getColor() {
		return color;
	}
	
	public int getDamage() {
		return damage;
	}
}
