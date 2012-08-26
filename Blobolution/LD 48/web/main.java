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

public void setup() {
  frame.setTitle("Blobolution");
  
  img = loadImage("data/background.jpg");
  PFont myFont;
  myFont = loadFont("EurasiaBold-30.vlw");
  textFont(myFont, 30);
  textAlign(CENTER);
  
  size(800, 600);
  frameRate(24);
  smooth();    // X      Y    Xsize  Ysize R   G   B 
  
  orb1 = new orb(600.0f, 400.0f, 20.0f, 20.0f, 209, 144, 74);
  orb2 = new orb(480.0f, 500.0f, 35.0f, 35.0f, 128, 15, 100);
  orb3 = new orb(500.0f, 250.0f, 30.0f, 30.0f, 290, 104, 407); 
  orb4 = new orb(290.0f, 450.0f, 50.0f, 50.0f, 240, 100, 25); // 50 + 80 = 135 | size needed = 200
  orb5 = new orb(301.0f, 241.0f, 40.0f, 40.0f, 50, 150, 250); 
  orb6 = new orb(200.0f, 700.0f, 50.0f, 50.0f, 100, 5, 280);
  orb7 = new orb(350.0f, 300.0f, 25.0f, 25.0f, 120, 182, 298);
  orb8 = new orb(128.0f, 340.0f, 29.0f, 29.0f, 241, 482, 120);
  orb9 = new orb(228.0f, 134.8f, 10.0f, 10.0f, 728, 0, 224);
  orb10 = new orb(482.1f, 325.0f, 55.0f, 55.0f, 272, 248, 025); 
  
}

public void draw() {
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

public void orbrun() {
  
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




float playerX = 400.0f;
float playerY = 300.0f;
float playersize = 60.0f;

public void playerellipse() {
  fill(0, 0, 255);
  ellipse(playerX, playerY, playersize, playersize);
}

// movement
float playerspeed = 7.5f;
public void playermove() {
  if (keyPressed) { 
    // up / North
    if (key == 'e') {
      playerY-=playerspeed;
    } 
    // down / South
    else if (key == 'd') {
      playerY+=playerspeed;
    }
    // left / West
    else if (key == 's') {
      playerX-=playerspeed;
    }
    // right / East
    else if (key == 'f') {
      playerX+=playerspeed;
    }
    // top left / North West
    else if (key == 'w') {
      playerY-=playerspeed; playerX-=playerspeed;
    }
    // bottom left / South West
    else if (key == 'z') {
      playerY+=playerspeed; playerX-=playerspeed;
    }
    //top right / North East
    else if (key == 'r') {
      playerY-=playerspeed; playerX+=playerspeed;
    }
    // bottom right / South East 
    else if (key == 'v') {
      playerY+=playerspeed; playerX+=playerspeed;
    }
  }
}


float enemyY = 100.0f;
float enemyX = 100.0f;
float enemysize = 200.0f;
float enemyspeed = 3.8f;

public void enemyellipse() {
  fill(255, 0, 0);
  ellipse(enemyX, enemyY, enemysize, enemysize);
}

float vectX, vectY;
float normX, normY;

public void chase() {
  //thanks to SteelRaven7 and others, for the help, and the basic code construct ^_^
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
      println("Player Loses");
      while (playersize > 0.0f) {
        playersize = playersize - 5.0f;
        enemysize = enemysize + 5.0f;
        if (playersize <= 0.0f) {
          endgame = 1;
          break;         
        }
       }      
      }
    } 
  if (sqrt(sq(playerX-enemyX)+sq(playerY-enemyY)) < (playersize+enemysize)/2) {
    if (playersize > enemysize) {
      println("Player Wins!");
      while (enemysize > 0.0f) {
        playersize = playersize + 5.0f;
        enemysize = enemysize - 5.0f;
        if (enemysize <= 0.0f) {
          endgame = 2;
          break;
        }        
      }
    } 
   }
   else {
     println("No Collision");
   } 
}



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
     if  (sqrt(sq(playerX-orbX)+sq(playerY-orbY)) < (playersize+orbsize)/2) {
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
     if (sqrt(sq(playerX-orbX)+sq(playerY-orbY)) < (playersize+orbsize)/2) {
       if (playersize < orbsize) {
         println("Collision: player < orb");
         while (playersize > 0.0f) {
           playersize = playersize - 5.0f;
           orbsize = orbsize + 5.0f;
           if (playersize <= 0.0f) {
             break;
           }
         }
       }
     }
//     
} 
     
       
   float OrbVectX, OrbVectY;
   float OrbNormX, OrbNormY;
   float OrbSpeed = 3.8f;

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
  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#ECE9D8", "main" });
  }
}
