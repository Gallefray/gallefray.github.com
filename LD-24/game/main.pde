//String textvar = "";



void setup() {
  size(800, 600);
  frameRate(24);
  smooth();
}

void draw() {
  background(0);
  playermove();
  playerellipse();
  chase();
  enemyellipse();
  collision();
  orbs();
}

//void displaytext() {
//  PFont myFont;
//  myFont = loadFont("EurasiaBold-30.vlw");
//  textFont(myFont, 30);
//  textAlign(CENTER);
//  fill(255);
//  text(textvar, width/2, height/2);
//}



