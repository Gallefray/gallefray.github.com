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

public class main extends PApplet {

//String textvar = "";



public void setup() {
  size(800, 600);
  frameRate(24);
  smooth();
}

public void draw() {
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



// ellipse(x, y, width, height);
float playerX = 400.0f;
float playerY = 300.0f;
float playersize = 50.0f;

public void playerellipse() {
  fill(0, 0, 255);
  ellipse(playerX, playerY, playersize, playersize);
}

// movement
public void playermove() {
  if (keyPressed) { 
    // up / North
    if (key == 'e') {
      playerY-=5.0f;
    } 
    // down / South
    else if (key == 'd') {
      playerY+=5.0f;
    }
    // left / West
    else if (key == 's') {
      playerX-=5.0f;
    }
    // right / East
    else if (key == 'f') {
      playerX+=5.0f;
    }
    // top left / North West
    else if (key == 'w') {
      playerY-=5.0f; playerX-=5.0f;
    }
    // bottom left / South West
    else if (key == 'z') {
      playerY+=5.0f; playerX-=5.0f;
    }
    //top right / North East
    else if (key == 'r') {
      playerY-=5.0f; playerX+=5.0f;
    }
    // bottom right / South East 
    else if (key == 'v') {
      playerY+=5.0f; playerX+=5.0f;
    }
  }
}
// ellipse(x, y, width, height);

float enemyY = 100.0f;
float enemyX = 100.0f;
float enemysize = 150.0f;
float enemyspeed = 5.0f;

public void enemyellipse() {
  fill(255, 0, 0);
  ellipse(enemyX, enemyY, enemysize, enemysize);
}

float vectX, vectY;
float normX, normY;

public void chase() {
  //thanks to SteelRaven7 nd others, for the help, and the basic code construct ^_^
  float Xchasevector = playerX - enemyX; 
  float Ychasevector = playerY - enemyY; 
  Xchasevector = Xchasevector * enemyspeed;
  Ychasevector = Ychasevector * enemyspeed;
  println("chase code"); //prints a line to the debug console
  normX = norm(Xchasevector, 0.0f, 800.0f);
  normY = norm(Ychasevector, 0.0f, 600.0f);
  enemyX = enemyX + normX;
  enemyY = enemyY + normY;
  println("has run"); 
}

public void collision() {
  // thanks to http://forum.processing.org/#User/asimes for the collision physics calculations
  // http://forum.processing.org/topic/trying-to-do-circle-on-circle-collision-detection-but-i-can-t-make-it-work-where-is-the-bug
  if (sqrt(sq(playerX-enemyX)+sq(playerY-enemyY)) < (playersize+enemysize)/2) {
    if (playersize < enemysize) {
      println("Collision");
      //endgame();
      while (playersize > 0.0f) {
        playersize = playersize - 5.0f;
        enemysize = enemysize + 5.0f;
        if (playersize <= 0.0f) {
          break;         
        }      
      }
    }
  }
  else {
    println("No Collision");
  }
  
}

//void endgame() {
//  textvar = "YOU LOSE";
//}
//thanks to lyndon_daniels for the basic code construct here ^_^
class orb {
  int R;
  int G;
  int B;
  float orbX;
  float orbY;
  float orbsize;

  orb(float temporbX, float temporbY, float tempOrbsizeX, float tempOrbsizeY, int colourR, int colourG, int colourB) {
     orbX = temporbX;
     orbY = temporbY;
     orbsize = tempOrbsizeX;
     orbsize = tempOrbsizeY;
     R = colourR;
     G = colourG;
     B = colourB;
   }

  public void disp() {
    fill(R, G, B);
    ellipse(orbX, orbY, orbsize, orbsize);
   }
   
   public void collide() {
     if (sqrt(sq(orbX-playerX)+sq(orbY-playerY)) < (orbsize+playersize)/2) {
       if (playersize > orbsize) {
         println("Collision: player > orb");
         while (orbsize > 0.0f) {
           playersize = playersize + orbsize;
           orbsize = 0.0f;
           if (orbsize == 0.0f) {
             break;
           }
         }
       }
     }
     else if (sqrt(sq(orbX-playerX)+sq(orbY-playerY)) < (orbsize+playersize)/2) {
       if (playersize < orbsize) {
         println("Collision: player < orb");
         while (playersize > 0.0f) {
           orbsize = orbsize + playersize;
           playersize = 0.0f;
           if (playersize <= 0.0f) {
             break;
           }
         }
       }
     }
     
} 
     
       
   float OrbVectX, OrbVectY;
   float OrbNormX, OrbNormY;
   float OrbSpeed = 3.0f;

   public void movement() {
       float OrbChaseVectorX = playerX - orbX; 
       float OrbChaseVectorY = playerY - orbY; 
       OrbChaseVectorX = OrbChaseVectorX * OrbSpeed;
       OrbChaseVectorY = OrbChaseVectorY * OrbSpeed;
       println("chase code: orb"); //prints a line to the debug console
       OrbNormX = norm(OrbChaseVectorX, 0.0f, 800.0f);
       OrbNormY = norm(OrbChaseVectorY, 0.0f, 600.0f);
       orbX = orbX - OrbNormX;
       orbY = orbY - OrbNormY;
       println("has run"); 
     
   }
         
}



public void orbs() {
  orb orb1;    // orbX, orbY,  size, size, R,  G,  B
  orb1 = new orb(600.0f, 600.0f, 49.0f, 49.0f, 0, 255, 0);
  orb1.disp();
  orb1.collide();
  orb1.movement();
}
  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#ECE9D8", "main" });
  }
}
