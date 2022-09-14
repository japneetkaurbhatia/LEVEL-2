public final int width=600,height=400;
public final int diameter=10;

class Ball{
  public int x;
  public int y;
  public int speed;
  
  Ball(int y,int speed){
    x=0;
    this.y=y;
    this.speed=speed;
  }
  public void drawBall(){
    ellipse(x,y,diameter,diameter);
    x+=speed;
  }
}

Ball ball1,ball2,ball3,ball4;

void setup(){
  size(600,400);
  ball1 = new Ball(height/5,1);
  ball2 = new Ball(2*height/5,2);
  ball3 = new Ball(3*height/5,3);
  ball4 = new Ball(4*height/5,4);
}

void draw(){
  ball1.drawBall();
  ball2.drawBall();
  ball3.drawBall();
  ball4.drawBall();
}