int width = 600, height = 400, diameter = 10;
int Speed1 = 0, Speed2 = 0, Speed3 = 0, Speed4 = 0;
int Position1 = height/5, Position2 = (2*height)/5, Position3 = (3*height)/5, Position4 = (4*height)/5;

void setup(){
  size(640, 480);
}

void Draw1(){
  ellipse(Speed1, Position1, diameter, diameter);
  Speed1++;
}

void Draw2(){
  ellipse(Speed2, Position2, diameter, diameter);
  Speed2 += 2;
}

void Draw3(){
  ellipse(Speed3, Position3, diameter, diameter);
  Speed3 += 3;
}

void Draw4(){
  ellipse(Speed4, Position4, diameter, diameter);
  Speed4 += 4;
}

void draw(){
  Draw1();
  Draw2();
  Draw3();
  Draw4();
}