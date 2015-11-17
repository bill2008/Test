package com.bill.test;
import java.applet.*;
import java.awt.*;
public class AppletTest extends Applet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width,height;
	Image image;//声明图像变量
	Graphics draw_Curve;//声明图形绘制变量
	public void init(){//程序初始化
		setBackground(Color.black);
		this.setSize(350,310);
		width=getSize().width;
		height=getSize().height;
		image=createImage(width,height);
		draw_Curve=image.getGraphics();
	}
	
	public void paint(Graphics g){
		draw_Curve.clearRect(0, 0, width, height);
		draw_Curve.setColor(Color.blue);
		int i,j;
		double x,y,r;
		for(i=0;i<=90;i++)
		for(j=0;j<=90;j++)
		{
		r=Math.PI/45*i*(1-Math.sin(Math.PI/45*j))*18;
		x=r*Math.cos(Math.PI/45*j)*Math.sin(Math.PI/45*i)+width/2;
		y=-r*Math.sin(Math.PI/45*j)+height/4;
		draw_Curve.fillOval((int )x, (int )y, 2, 2);
		}
		g.drawImage(image,0,0,this);
	} 
}
