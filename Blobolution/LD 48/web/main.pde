/** all code is the property of Polyhedron Design Studios and is licensed under the zlib license **/
//thanks to SteelRaven7, Helzibah, adventureloop, gabeochoa_, vede, agersant, <fr_automatik and others I have forgotten :( , for the help with everything :)

int endgame = 0;

orb orb1;
orb orb2;
orb orb3;
orb orb4;
orb orb5;
orb orb6;
orb orb7;
orb orb8;
orb orb9;
orb orb10;

PImage img;

void setup() {
  frame.setTitle("Blobolution");
  
  img = loadImage("data/background.jpg");
  PFont myFont;
  myFont = loadFont("EurasiaBold-30.vlw");
  textFont(myFont, 30);
  textAlign(CENTER);
  
  size(800, 600);
  frameRate(24);
  smooth();    // X      Y    Xsize  Ysize R   G   B 
  
  orb1 = new orb(600.0, 400.0, 20.0, 20.0, 209, 144, 74);
  orb2 = new orb(480.0, 500.0, 35.0, 35.0, 128, 15, 100);
  orb3 = new orb(500.0, 250.0, 30.0, 30.0, 290, 104, 407); 
  orb4 = new orb(290.0, 450.0, 50.0, 50.0, 240, 100, 25); // 50 + 80 = 135 | size needed = 200
  orb5 = new orb(301.0, 241.0, 40.0, 40.0, 50, 150, 250); 
  orb6 = new orb(200.0, 700.0, 50.0, 50.0, 100, 5, 280);
  orb7 = new orb(350.0, 300.0, 25.0, 25.0, 120, 182, 298);
  orb8 = new orb(128.0, 340.0, 29.0, 29.0, 241, 482, 120);
  orb9 = new orb(228.0, 134.8, 10.0, 10.0, 728, 0, 224);
  orb10 = new orb(482.1, 325.0, 55.0, 55.0, 272, 248, 025); 
  
}

void draw() {
  background(img);
  playermove();
  playerellipse();
  chase();
  enemyellipse();
  collision();
  orbrun();
  
  if (endgame == 1) {
    fill(255);
    text("YOU LOSE", width/2, height/2);
  }
  else if (endgame == 2) {
    textAlign(CENTER);
    fill(255);
    text("YOU WIN", width/2, height/2);
  }
}

void orbrun() {
  
  orb1.disp();
  orb1.collide();
  orb1.movement();

  orb2.disp();
  orb2.collide();
  orb2.movement();
  
  orb3.disp();
  orb3.collide();
  orb3.movement();
 
  orb4.disp();
  orb4.collide();
  orb4.movement(); 
  
  orb5.disp();
  orb5.collide();
  orb5.movement();
  
  orb6.disp();
  orb6.collide();
  orb6.movement();
  
  orb7.disp();
  orb7.collide();
  orb7.movement();
  
  orb8.disp();
  orb8.collide();
  orb8.movement();
  
  orb9.disp();
  orb9.collide();
  orb9.movement();
  
  orb10.disp();
  orb10.collide();
  orb10.movement();  
}




