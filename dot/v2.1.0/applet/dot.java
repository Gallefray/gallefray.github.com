import processing.core.*; 
import processing.xml.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class dot extends PApplet {

/** ------------------------------------
 <  -  less-than
 >  -  more-than
 ----------------------------------- **/

int bg = 0;
int dotX = 200;
int dotY = 200;
int dotsize = 48;

public void setup() {
  size(400, 400);
  smooth();
}


public void draw () {
  //code for objcollenemy1:
  int xDist = enemyX - dotX;
  int yDist = enemyY - dotY;
  
  background(bg);
  fill(255, 0, 0);
  ellipse(dotX, dotY, dotsize, dotsize);
  wallcoll();
  enemy1();
  objcollenemy1();
}

public void keyPressed() {
  if (key == CODED) { 

    if (keyCode == UP) {
      dotY-=4;
    } 
    else if (keyCode == DOWN) {
      dotY+=4;
    }
    else if (keyCode == LEFT) {
      dotX-=4;
    }
    else if (keyCode == RIGHT) {
      dotX+=4;
    }
  }
}

/** ------------------------------------
 <  -  less-than
 >  -  more-than
 ----------------------------------- **/

public void wallcoll() {
  if (dotX-25 <= 0) {
    dotX+=12;
  }
  else if (dotX+25 >= 400) {
    dotX-=12;
  }
  else if (dotY-25 <= 0) {
    dotY+=12;
  }
  else if (dotY+25 >= 400) {
    dotY-=12;
  } 
  // -------------------------------------------------------------
  // Repeats with enemy1
  if (enemyX-25 <= 0) {
    enemyX+=12;
  }
  else if (enemyX+25 >= 400) {
    enemyX-=12;
  }
  else if (enemyY-25 <= 0) {
    enemyY+=12;
  }
  else if (enemyY+25 >= 400) {
    enemyY-=12;
  }
}

//void objcollenemy1() {
//  /** O -> O **/
//  if (dotX+25 >= enemyX-25 && (dotY == enemyY)) {
//    enemyX+=4;
//    println("enemyX " + enemyX);
//  }
//  // But why is the following statement true when the one above is? is it to do with the Y co-ordinates?
//  else if (dotX-25 <= enemyX+25 && (dotY == enemyY+4)) {
////    enemyX-=4;
//    bg = 255;
//    println("enemyX " + enemyX);
//  }
//}

public void objcollenemy1() {
  /** Thanks to http://forum.processing.org/user/benja for the solution to the problem **/

  // minumum distance
  int minDist = 50;

  // total distance 
  int xDist = enemyX - dotX;
  int yDist = enemyY - dotY;


  if (dotX > enemyX - enemysize/2 && dotX < enemyX+enemysize/2) { //(abs(xDist) < minDist && dotY == enemyY) {
    if (xDist >= 0) {
      enemyX += minDist - xDist;
      
    }
    else {
      enemyX -= minDist + xDist;
      
    }
  }
  if (dotY > enemyY-enemysize/2 && dotY < enemyY+enemysize/2) { //(abs(yDist) < minDist && dotX == enemyX) {
    if (yDist >= 0) {
      enemyY += minDist - yDist; 
    }
    else {
      enemyY -= minDist + yDist;
      
    }
  }
} 


/** ------------------------------------
 <  -  less-than
 >  -  more-than
 ----------------------------------- **/

int enemyX = 100;
int enemyY = 100;
int enemysize = 48;

public void enemy1 () {
  fill(96, 129, 53);
  rectMode(CENTER);
  rect(enemyX, enemyY, enemysize, enemysize);
}
 
  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#ECE9D8", "dot" });
  }
}
